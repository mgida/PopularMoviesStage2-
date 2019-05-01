package com.example.android.popmovies.DataBase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.android.popmovies.model.Movie;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movie ")
    LiveData<Movie[]> loadAllMovies();

    @Query("select * from movie where ID = :id")
    Movie selectMovieByID(int id);

    @Insert
    void insertMovie(Movie mMovie);


    @Delete
    void deleteMovie(Movie mMovie);


}
