package com.kosgei.movieapp.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.data.models.Movies
import com.kosgei.movieapp.data.models.ResultWrapper
import com.kosgei.movieapp.data.repositories.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MoviesViewModel @Inject constructor(private val moviesRepository: MoviesRepository) :
    ViewModel() {
    var popularMovies  = moviesRepository.getCharacters()
//    init {
//        getCachedPopularMovies()
//    }

//    private fun getCachedPopularMovies(){
//      viewModelScope.launch {
//         var movies = moviesRepository.getCachedMovies()
//          popularMovies.value = movies
//      }
//    }

//    fun getCurrentPopularMovies() = liveData(Dispatchers.IO) {
//
//        val cachedMovies = moviesRepository.getCachedMovies()
//
//        val alreadyCached: Boolean = cachedMovies.isNotEmpty()
//
//        emit(ResultWrapper.loading(data = null, refreshing = alreadyCached))
//
//        if (alreadyCached) {
//            emit(ResultWrapper.success(data = Movies(cachedMovies)))
//        }
//        try {
//            val movies = moviesRepository.getCurrentPopularMovies()
//            //cache fetched movies
//            moviesRepository.saveMovies(movies.movies)
//            emit(ResultWrapper.success(data = movies))
//        } catch (exception: Exception) {
//            emit(
//                ResultWrapper.error(
//                    data = null,
//                    message = exception.message ?: "Error Occurred!",
//                    refreshing = alreadyCached
//                )
//            )
//        }
//
//    }
}


