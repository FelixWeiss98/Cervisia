package com.example.cervisia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

public class AddBeverageRatingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_beverage_rating);

        defineMenuButton();

        EditText beverageName = findViewById(R.id.editTextNameRA);
        EditText beveragePrice = findViewById(R.id.editTextPriceRA);
        EditText beverageType = findViewById(R.id.editTextTypeRA);
        Button createButton = findViewById(R.id.buttonCreateRA);
        RatingBar beverageRank = findViewById(R.id.ratingBarBeverageRA);
        createButton.setOnClickListener(v -> createNewRating(beverageName.getText().toString(),
                beveragePrice.getText().toString() + " €",
                beverageRank.getRating() * 2,
                beverageType.getText().toString()));
    }

    //create a new Rating within the RecyclerView of the Library Activity
    private void createNewRating(String beverageName, String beveragePrice, float beverageRank, String beverageType){
        BeverageRatingDB db = BeverageRatingDB.getDatabaseInstance(this.getApplicationContext());

        BeverageRating beverageRating = new BeverageRating();
        beverageRating.beverageName = beverageName;
        beverageRating.beveragePrice = beveragePrice;
        beverageRating.beverageRank = beverageRank;
        beverageRating.beverageType = beverageType;

        db.beverageRatingDAO().insertRating(beverageRating);

        finish();
    }

    //creates an Intent to switch form the add screen back to the menu
    private void defineMenuButton() {
        ImageButton imageButton;
        imageButton = findViewById(R.id.imageButtonMenuRA);
        imageButton.setOnClickListener(v -> {
            Intent changeActivityIntent = new Intent(AddBeverageRatingActivity.this, MenuActivity.class);
            startActivity(changeActivityIntent);
        });
    }
}