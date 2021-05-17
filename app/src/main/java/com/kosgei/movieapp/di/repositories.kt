package com.kosgei.movieapp.di

import com.kosgei.movieapp.data.repositories.MovieRepository
import com.kosgei.movieapp.data.repositories.MoviesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    abstract fun bindRepository(impl: MoviesRepositoryImpl): MovieRepository
}