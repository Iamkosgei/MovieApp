package com.kosgei.movieapp.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kosgei.movieapp.R
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
        setUpErrorLayout()
    }

    private fun setUpErrorLayout() {
        binding.buttonRetry.setOnClickListener {
            getPopularMovies()
        }
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        popularMoviesAdapter = PopularMoviesAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = popularMoviesAdapter
    }

    private fun getPopularMovies() {
        moviesViewModel.getCurrentPopularMovies().observe(viewLifecycleOwner, {
            it?.let { resultWrapper ->
                run {
                    when (resultWrapper.status) {
                        Status.SUCCESS -> {
                            binding.shimmerFrameLayout.isVisible = false
                            binding.popularMoviesRecycler.isVisible = true
                            binding.errorLayout.isVisible = false
                            resultWrapper.data?.let { it1 -> setPopularMovies(it1.movies) }
                        }
                        Status.ERROR -> {

                            binding.shimmerFrameLayout.isVisible = false
                            binding.popularMoviesRecycler.isVisible = false

                            if (resultWrapper.refreshing!!) {
                                binding.popularMoviesRecycler.isVisible = true
                                binding.errorLayout.isVisible = false
                                resultWrapper.message?.let { it1 ->
                                    Snackbar.make(requireView(), it1, Snackbar.LENGTH_SHORT)
                                        .show()
                                }
                            } else {
                                resultWrapper.message?.let { it1 ->
                                    binding.errorMessage.text = it1
                                }
                                binding.errorLayout.isVisible = true
                            }

                        }
                        Status.LOADING -> {
                            binding.popularMoviesRecycler.isVisible = false

                            if (resultWrapper.refreshing!!) {
                                Snackbar.make(requireView(), "Refreshing", Snackbar.LENGTH_SHORT)
                                    .show()
                            } else {
                                binding.shimmerFrameLayout.isVisible = true
                            }
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