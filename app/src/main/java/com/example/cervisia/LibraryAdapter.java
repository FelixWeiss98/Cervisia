package com.example.cervisia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibraryAdapter extends RecyclerView.Adapter<LibraryAdapter.LibraryViewHolder> {

    //Variables
    private List<BeverageRating> beverageRatingList;
    private Context context;

    //Constructors
    public LibraryAdapter(Context context) {
        this.context = context;
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
        holder.beverageNameTextView.setText(beverageRatingList.get(position).beverageName);
        holder.beveragePriceTextView.setText(beverageRatingList.get(position).beveragePrice);
    }

    @Override
    public int getItemCount() {
        return this.beverageRatingList.size();
    }
}
