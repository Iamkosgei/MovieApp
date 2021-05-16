package com.kosgei.movieapp.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.kosgei.movieapp.data.models.Movie


@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
     fun getAllMovies():LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMultiple(movies: List<Movie>)

    @Query("DELETE FROM movie")
    suspend fun deleteAll()
}