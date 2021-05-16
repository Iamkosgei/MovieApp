package com.kosgei.movieapp.data.remote.api

import com.kosgei.movieapp.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<Movies>
}