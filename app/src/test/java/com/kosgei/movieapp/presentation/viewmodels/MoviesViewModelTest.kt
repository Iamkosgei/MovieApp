package com.kosgei.movieapp.presentation.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.data.models.ResultWrapper
import com.kosgei.movieapp.data.repositories.MovieRepository
import com.kosgei.movieapp.utils.Status
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class MoviesViewModelTest{
    private lateinit var viewModel: MoviesViewModel

    @Mock
    lateinit var movieRepository: MovieRepository

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MoviesViewModel(movieRepository)
    }
    @Test
    fun `Returns correct movie after a successful fetch`() {

        //given
        val movies = mutableListOf<Movie>()
        movies.add( Movie(
            id = 19404,
            adult = false,
            backdrop_path = "",
            original_language = "",
            original_title = "Dilwale Dulhania Le Jayenge",
            overview = "",
            popularity = 0.0,
            poster_path = "",
            release_date = "",
            title = "Dilwale Dulhania Le Jayenge",
            vote_average = 0.0,
            vote_count = 0
        ))

        val resultWrapper: ResultWrapper<List<Movie>> =
            ResultWrapper<List<Movie>>(data = movies, status = Status.SUCCESS, message = null)

        // Mock API response
        Mockito.`when`(movieRepository.getCurrentPopularMovies()).thenReturn(MutableLiveData(resultWrapper))


        // When get popular movies is called
        val movie = viewModel.getCurrentPopularMovies().value?.data?.get(0)

        //then
        assertNotNull(movie)
        assertEquals(movie?.title, "Dilwale Dulhania Le Jayenge")

    }

}