package com.example.cervisia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    //Arraylist of BeverageRatings
    private ArrayList<BeverageRating> beverageRatingArrayList;

    //Constructor
    public LibraryAdapter(ArrayList<BeverageRating> beverageRatingArrayList) {
        this.beverageRatingArrayList = beverageRatingArrayList;
    }

    //ViewHolder Class
    public class LibraryViewHolder extends RecyclerView.ViewHolder{
        //All Views in the Holder
        private TextView beverageNameTextView;
        private TextView beveragePriceTextView;

        public LibraryViewHolder(@NonNull View beverageRatingItemView) {
            //Master View
            super(beverageRatingItemView);

            //Assign all View to the master View
            beverageNameTextView = beverageRatingItemView.findViewById(R.id.textViewBeverageNameLA);
            beveragePriceTextView = beverageRatingItemView.findViewById(R.id.textViewBeveragePriceLA);
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
        if (beverageRatingArrayList.get(position) != null) {
            BeverageRating beverageRating = (BeverageRating) beverageRatingArrayList.get(position);

            //Get the Content of the Model
            String beverageNameString = beverageRating.getBeverageName();
            String beveragePriceString = beverageRating.getBeveragePrice();

            //Define Content of the holder
            holder.beverageNameTextView.setText(beverageNameString);
            holder.beveragePriceTextView.setText(beveragePriceString);
        }
    }

    @Override
    public int getItemCount() {
        return beverageRatingArrayList.size();
    }
}
