package com.kosgei.movieapp.data.repositories

import com.kosgei.movieapp.data.local.dao.MovieDao
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.data.remote.api.MovieApiService
import javax.inject.Inject

class MoviesRepository  @Inject constructor(private val movieApiService: MovieApiService, private val movieDao: MovieDao) {

    suspend fun getCachedMovies() = movieDao.getAllMovies()

    suspend fun getCurrentPopularMovies() = movieApiService.getPopularMovies()

    suspend fun  saveMovies(movies:List<Movie>)= movieDao.insertMultiple(movies)
}