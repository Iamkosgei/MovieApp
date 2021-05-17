package com.kosgei.movieapp.data.repositories

import androidx.lifecycle.LiveData
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.data.models.Movies
import com.kosgei.movieapp.data.models.ResultWrapper

interface MovieRepository {
    fun getCurrentPopularMovies():  LiveData<ResultWrapper<List<Movie>>>

}