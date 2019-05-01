package com.example.android.popmovies.DataBase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.popmovies.model.Movie;

public class MainViewModel extends AndroidViewModel {

    LiveData<Movie[]> Movies ;
    public MainViewModel(@NonNull Application application) {
        super(application);
        Holder mDb = Holder.getInstance(this.getApplication());
        Movies=mDb.movieDao().loadAllMovies();
    }

    public LiveData<Movie[]> getMovies() {
        return Movies;
    }
}
