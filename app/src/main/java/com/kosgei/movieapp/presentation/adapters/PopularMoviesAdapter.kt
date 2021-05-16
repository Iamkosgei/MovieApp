package com.kosgei.movieapp.presentation.adapters


import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView;
import com.kosgei.movieapp.R
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.databinding.FragmentMovieDetailsBinding
import com.kosgei.movieapp.databinding.MovieItemBinding
import com.kosgei.movieapp.presentation.adapters.PopularMoviesAdapter.*
import com.kosgei.movieapp.presentation.fragments.PopularMoviesFragment
import com.kosgei.movieapp.presentation.fragments.PopularMoviesFragmentDirections

class PopularMoviesAdapter(private var movies: List<Movie>) :
    ListAdapter<Movie, PopularMoviesViewHolder>(PopularMoviesDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMoviesViewHolder {
        val binding = MovieItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return PopularMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMoviesViewHolder, position: Int) {
        val movie = getItem(position)
        holder.setMovie(movie)
    }


    class PopularMoviesViewHolder(private val movieItemBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(movieItemBinding.root), View.OnClickListener {
        private lateinit var movie: Movie

        init {

            movieItemBinding.root.setOnClickListener(this)
        }

        fun setMovie(movie: Movie) {
            this.movie = movie
            movieItemBinding.movie = movie
        }

        override fun onClick(v: View) {
            val directions =
                PopularMoviesFragmentDirections.actionPopularMoviesFragmentToMovieDetailsFragment(
                    movie
                )
            val extras = FragmentNavigatorExtras(
                movieItemBinding.movieImage to movie.poster_path
            )

            v.findNavController().navigate(
                directions,
                extras
            )
        }

    }

}
