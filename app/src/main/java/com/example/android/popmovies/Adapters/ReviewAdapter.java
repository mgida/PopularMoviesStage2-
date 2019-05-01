

package com.example.android.popmovies.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.popmovies.R;
import com.example.android.popmovies.model.Review;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    private ArrayList<Review> reviews;

    public ReviewAdapter(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        TextView mAuthor;
        TextView mContent;


        public ReviewViewHolder(View view) {
            super(view);
            mAuthor = (TextView) itemView.findViewById(R.id.Review_author);

            mContent = (TextView) view.findViewById(R.id.Review_content);
        }
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.review_list_item, parent, false);

        ReviewViewHolder reviewViewHolder = new ReviewViewHolder(view);

        return reviewViewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position) {
        Review review = reviews.get(position);

        holder.mAuthor.setText(review.getAuthor());

        holder.mContent.setText(review.getContent());


    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }
}


