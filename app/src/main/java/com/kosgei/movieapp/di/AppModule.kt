package com.kosgei.movieapp.di

import android.content.Context
import androidx.room.Room
import com.google.gson.GsonBuilder
import com.kosgei.movieapp.BuildConfig
import com.kosgei.movieapp.data.local.dao.MovieDao
import com.kosgei.movieapp.data.local.db.MovieDb
import com.kosgei.movieapp.data.remote.MovieRemoteDataSource
import com.kosgei.movieapp.data.remote.api.MovieApiService
import com.kosgei.movieapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideMovieDao(appDatabase: MovieDb): MovieDao {
        return appDatabase.movieDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): MovieDb {
        return Room.databaseBuilder(
            appContext,
            MovieDb::class.java,
            "MovieApp"
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiService(retrofit: Retrofit): MovieApiService = retrofit.create(MovieApiService::class.java)

    @Singleton
    @Provides
    fun provideRetrofitInstance(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = run {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            var original = chain.request()

            val url: HttpUrl = original.url().newBuilder()
              .addQueryParameter("api_key", BuildConfig.API_KEY)
                .build()

            val requestBuilder: Request.Builder = original.newBuilder()
                .url(url)

            val request = requestBuilder.build()

            Timber.i(
                "Sending request %s",
                request.url()
            )
            chain.proceed(request)
        }
        httpClient.connectTimeout(30, TimeUnit.SECONDS)
        httpClient.readTimeout(30, TimeUnit.SECONDS)
        httpClient.build()
    }

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(movieApiService: MovieApiService) = MovieRemoteDataSource(movieApiService)
}
