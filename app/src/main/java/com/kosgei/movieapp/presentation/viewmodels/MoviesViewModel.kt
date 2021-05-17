package com.kosgei.movieapp.presentation.viewmodels

import androidx.lifecycle.*
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.data.models.ResultWrapper
import com.kosgei.movieapp.data.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesRepository: MovieRepository) :
    ViewModel() {
    fun getCurrentPopularMovies() : LiveData<ResultWrapper<List<Movie>>>{
        return  moviesRepository.getCurrentPopularMovies()
    }
    }


