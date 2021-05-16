package com.kosgei.movieapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.databinding.FragmentPopularMoviesBinding
import com.kosgei.movieapp.presentation.adapters.PopularMoviesAdapter
import com.kosgei.movieapp.presentation.viewmodels.MoviesViewModel
import com.kosgei.movieapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding get() = _binding!!

    private val moviesViewModel: MoviesViewModel by viewModels()

    private lateinit var popularMoviesAdapter: PopularMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        recyclerView = binding.popularMoviesRecycler
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        getPopularMovies()
    }


    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        popularMoviesAdapter = PopularMoviesAdapter(arrayListOf())
        recyclerView.adapter = popularMoviesAdapter
    }

    private fun getPopularMovies() {
        moviesViewModel.popularMovies.observe(viewLifecycleOwner, {
            it?.let { resultWrapper ->
                run {
                    when (resultWrapper.status) {
                        Status.SUCCESS -> {
                            binding.shimmerFrameLayout.isVisible = false
                            binding.popularMoviesRecycler.isVisible = true
                            resultWrapper.data?.let { it1 -> setPopularMovies(it1) }
                        }
                        Status.ERROR -> {
                            binding.shimmerFrameLayout.isVisible = false
                            binding.popularMoviesRecycler.isVisible = false
                            Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                        }
                        Status.LOADING -> {
                            binding.shimmerFrameLayout.isVisible = true
                        }
                    }
                }
            }
        })
    }

    private fun setPopularMovies(movies: List<Movie>) {
        popularMoviesAdapter.submitList(movies)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}