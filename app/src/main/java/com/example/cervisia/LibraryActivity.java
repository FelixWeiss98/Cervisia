package com.example.cervisia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    private LibraryAdapter libraryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        //Methods
        defineMenuButton();
        setRecyclerViewAdapter();
        loadBeverageRatings();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (requestCode == 100) {
            loadBeverageRatings();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void loadBeverageRatings() {
        BeverageRatingDB db = BeverageRatingDB.getDatabaseInstance(this.getApplicationContext());
        List<BeverageRating> beverageRatingList = db.beverageRatingDAO().getAll();
        libraryAdapter.setBeverageRatingList(beverageRatingList);
    }

    private void setRecyclerViewAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewLibraryLA);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        libraryAdapter = new LibraryAdapter(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(libraryAdapter);
    }

    private void defineMenuButton() {
        ImageButton imageButton;
        imageButton = findViewById(R.id.imageButtonMenuLA);
        imageButton.setOnClickListener(v -> {
            Intent changeActivityIntent = new Intent(LibraryActivity.this, MenuActivity.class);
            startActivity(changeActivityIntent);
        });
    }
}