package com.example.android.popmovies.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.popmovies.R;
import com.example.android.popmovies.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

   public static Movie[] mMovie;
    static MovieClickHandler handler ;

    public interface MovieClickHandler {
       void OnClick(Movie movie );
    }

    public MovieAdapter(MovieClickHandler handler) {
        this.handler = handler;
    }

    @NonNull
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.list_item, parent, false);
        MovieAdapterViewHolder viewHolder = new MovieAdapterViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapterViewHolder movieAdapterViewHolder, int position) {
        final String MOVIE_URL = "http://image.tmdb.org/t/p/w185";
        Movie movie = mMovie[position];
        Context context = movieAdapterViewHolder.imageView.getContext();
        Picasso.with(context).load(MOVIE_URL+movie.getPoster()).into(movieAdapterViewHolder.imageView);


    }

    @Override
    public int getItemCount() {
        if (mMovie == null) {
            return 0;
        }
        return mMovie.length;
    }

    public static class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;

        public MovieAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            //view from onCreateViewHolder that inflated

            imageView = (ImageView) itemView.findViewById(R.id.iv_image);
            imageView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Movie movie = mMovie[position];
            handler.OnClick(movie);
        }
    }

    public void setMovieData(Movie[] movieData) {
        mMovie = movieData;
        notifyDataSetChanged();


    }



}
