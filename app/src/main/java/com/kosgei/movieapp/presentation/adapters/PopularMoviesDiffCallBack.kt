package com.kosgei.movieapp.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.kosgei.movieapp.data.models.Movie


class PopularMoviesDiffCallBack : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
      return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
       return oldItem == newItem
    }
}