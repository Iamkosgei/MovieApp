package com.kosgei.movieapp.presentation.adapters


import android.view.LayoutInflater
import android.view.View;
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView;
import com.kosgei.movieapp.data.models.Movie
import com.kosgei.movieapp.databinding.MovieItemBinding
import com.kosgei.movieapp.presentation.adapters.PopularMoviesAdapter.*

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
        private var movie: Movie? = null

        init {

            movieItemBinding.root.setOnClickListener(this)
        }

        fun setMovie(movie: Movie) {
            this.movie = movie

            movieItemBinding.movie = movie
//
//            Glide.with(movieItemBinding.root).load(IMAGE_BASE_URL + movie.poster_path)
//                .into(movieItemBinding.movieImage)
        }

        override fun onClick(v: View?) {

        }

    }

}
