package com.example.cervisia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    //Variables
    private List<BeverageRating> beverageRatingList;
    private Context context;
    private ItemClickListener itemClickListener;

    //Constructors
    public LibraryAdapter(Context context, ItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    public void setBeverageRatingList(List<BeverageRating> beverageRatingList){
        this.beverageRatingList = beverageRatingList;
        notifyDataSetChanged();
    }

    //ViewHolder Class
    public class LibraryViewHolder extends RecyclerView.ViewHolder{
        //All Views in the Holder
        TextView beverageNameTextView;
        TextView beveragePriceTextView;
        TextView beverageTypeTextView;
        RatingBar beverageRankRatingBar;

        public LibraryViewHolder(@NonNull View beverageRatingItemView) {
            //Master View
            super(beverageRatingItemView);

            //Assign all View to the master View
            beverageNameTextView = beverageRatingItemView.findViewById(R.id.textViewBeverageNameLA);
            beveragePriceTextView = beverageRatingItemView.findViewById(R.id.textViewBeveragePriceLA);
            beverageRankRatingBar = beverageRatingItemView.findViewById(R.id.ratingBarBeverageLA);
            beverageTypeTextView = beverageRatingItemView.findViewById(R.id.textViewBeverageTypeLA);
        }
    }

    //Assign the List Item to the View Holder
    @NonNull
    @Override
    public LibraryAdapter.LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View beverageRatingItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_library, parent, false);
        return new LibraryViewHolder(beverageRatingItemView);
    }

    //Set the Text inside of the List Item
    @Override
    public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
        holder.beverageNameTextView.setText(beverageRatingList.get(position).beverageName);
        holder.beveragePriceTextView.setText(beverageRatingList.get(position).beveragePrice);
        holder.beverageRankRatingBar.setRating(beverageRatingList.get(position).beverageRank);
        holder.beverageTypeTextView.setText(beverageRatingList.get(position).beverageType);

        holder.itemView.setOnClickListener(v -> itemClickListener.onItemClick(beverageRatingList.get(position)));
    }

    @Override
    public int getItemCount() {
        return this.beverageRatingList.size();
    }

    public interface ItemClickListener{
        void onItemClick(BeverageRating beverageRating);
    }
}
