package com.kosgei.movieapp.data.models

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("results")
    val movies: List<Movie>
)