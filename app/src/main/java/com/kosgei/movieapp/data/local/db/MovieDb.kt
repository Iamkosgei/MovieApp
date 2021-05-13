package com.kosgei.movieapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kosgei.movieapp.data.local.dao.MovieDao
import com.kosgei.movieapp.data.models.Movie

@Database(entities = [Movie::class], version = 1,exportSchema = false)
abstract class MovieDb : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}