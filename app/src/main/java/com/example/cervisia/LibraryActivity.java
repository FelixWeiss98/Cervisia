package com.example.cervisia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private ArrayList<BeverageRating> beverageRatingArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //Initialise Variables
        beverageRatingArrayList = new ArrayList<>();

        //Methods
        defineView();
        setRecyclerViewAdapter();
        createDummyDate();
    }

    private void createDummyDate() {
        beverageRatingArrayList.add(new BeverageRating("Guinness"));
        beverageRatingArrayList.add(new BeverageRating("Bier"));
        beverageRatingArrayList.add(new BeverageRating("Kaiser"));
    }

    private void setRecyclerViewAdapter() {
        LibraryAdapter adapter = new LibraryAdapter(beverageRatingArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        //set LayoutManager ItemAnimator Adapter
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void defineView() {
        recyclerView = findViewById(R.id.recyclerViewLibraryLA);
        imageButton = findViewById(R.id.imageButtonMenuLA);

        imageButton.setOnClickListener(v -> {
            Intent changeActivityIntent = new Intent(LibraryActivity.this, MenuActivity.class);
            startActivity(changeActivityIntent);
        });
    }
}