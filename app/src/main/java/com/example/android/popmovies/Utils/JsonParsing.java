package com.example.android.popmovies.Utils;

import com.example.android.popmovies.MovieDetailActivity;
import com.example.android.popmovies.model.Movie;
import com.example.android.popmovies.model.Review;
import com.example.android.popmovies.model.Trailer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParsing {


    public static Movie[] DataParsed(String json) {
        Movie[] movie_data = null;


        try {


            JSONObject root = new JSONObject(json);
            JSONArray jsonArray = root.getJSONArray("results");

            movie_data = new Movie[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject movie = jsonArray.getJSONObject(i);
                int id = Integer.parseInt(movie.getString("id"));
                String vote_average = movie.getString("vote_average");
                String title = movie.getString("title");
                String poster_path = movie.getString("poster_path");

                String overview = movie.getString("overview");
                String release_date = movie.getString("release_date");


                movie_data[i] = new Movie(id, title, poster_path, release_date, vote_average, overview);
            }
            return movie_data;


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static void ParseMovieReviews(String rJson) {
        try {
            JSONObject ReviewRoot = new JSONObject(rJson);

            JSONArray jsonArray = ReviewRoot.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String content = jsonObject.getString("content");
                String author = jsonObject.getString("author");

                Review review = new Review();
                review.setContent(content);
                review.setAuthor(author);

                MovieDetailActivity.reviews.add(review);
            }

            MovieDetailActivity.reviewAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public static void ParseMovieTrailers(String tJson) {
        Trailer trailer;

        try {
            JSONObject TrailerRoot = new JSONObject(tJson);

            JSONArray jsonArray = TrailerRoot.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String key = jsonObject.getString("key");

                trailer = new Trailer();
                trailer.setTrailer("Trailer");
                trailer.setKey(key);

                MovieDetailActivity.trailerList.add(trailer);
            }

            MovieDetailActivity.youtubeAdapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
