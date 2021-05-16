package com.kosgei.movieapp.data.repositories

import com.kosgei.movieapp.data.local.dao.MovieDao
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.data.remote.MovieRemoteDataSource
import com.kosgei.movieapp.data.remote.api.MovieApiService
import com.kosgei.movieapp.utils.performGetOperation
import javax.inject.Inject

class MoviesRepository  @Inject constructor(private val remoteDataSource: MovieRemoteDataSource,
                                            private val movieDao: MovieDao) {

    fun getCharacters() = performGetOperation(
        databaseQuery = { movieDao.getAllMovies() },
        networkCall = { remoteDataSource.getCurrentPopularMovies() },
        saveCallResult = { movieDao.insertMultiple(it.movies) }
    )
}