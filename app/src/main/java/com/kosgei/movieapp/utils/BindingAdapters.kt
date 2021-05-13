package com.kosgei.movieapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("posterPath")
fun loadImage(view: ImageView, url: String?) {
    if(!url.isNullOrEmpty()) {
        Glide.with(view).load(IMAGE_BASE_URL + url).diskCacheStrategy(DiskCacheStrategy.ALL).skipMemoryCache(true).into(view)
    }
}