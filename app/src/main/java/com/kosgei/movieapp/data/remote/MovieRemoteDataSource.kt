package com.kosgei.movieapp.data.remote

import com.kosgei.movieapp.data.remote.api.MovieApiService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val movieApiService: MovieApiService) :
    BaseDataSource() {
    suspend fun getCurrentPopularMovies() = getResult { movieApiService.getPopularMovies() }
}