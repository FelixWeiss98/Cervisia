package com.example.cervisia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class UpdateBeverageRatingActivity extends AppCompatActivity {

    ImageButton backButton;
    TextView nameTextView;
    TextView priceTextView;
    TextView ratingTextView;
    TextView typeTextView;
    RatingBar rankRatingBar;
    Button deleteButton;
    Button updateButton;

    String nameText;
    String priceText;
    String ratingText;
    String typeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_beverage_rating);

        String info = getIntent().getExtras().getString("beverageName");

        System.out.println(info);

        initBackButton();
        setTextViews(info);
        getNewRating(info);
        deleteRating(info);
    }

    //Deletes the old rating
    //Used when deleting and updating a rating
    private void deleteRating(String name) {
        deleteButton = findViewById(R.id.buttonDeleteUA);
        BeverageRatingDB db = BeverageRatingDB.getDatabaseInstance(this.getApplicationContext());

        deleteButton.setOnClickListener(v -> {
            List<BeverageRating> beverageRatingList1 = db.beverageRatingDAO().getRating(name);
            BeverageRating deleteBR = beverageRatingList1.get(0);
            db.beverageRatingDAO().deleteRating(deleteBR);
        });

    }

    private void getNewRating(String name) {
        updateButton = findViewById(R.id.buttonUpdateUA);
        BeverageRatingDB db = BeverageRatingDB.getDatabaseInstance(this.getApplicationContext());

        updateButton.setOnClickListener(v -> {
            List<BeverageRating> beverageRatingList1 = db.beverageRatingDAO().getRating(name);
            BeverageRating updateBR = beverageRatingList1.get(0);
            String beveragePrice = updateBR.beveragePrice;
            String beverageName = updateBR.beverageName;
            String beverageType = updateBR.beverageType;
            rankRatingBar = findViewById(R.id.ratingBarBeverageUA);

            createNewRating(beverageName, beveragePrice, rankRatingBar.getRating() * 2, beverageType);
            db.beverageRatingDAO().deleteRating(updateBR);
        });
    }

    //Instead of updating the Database a new column gets created while updating information
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

    //Creates a new List of BeverageRating which holds only the selected item
    //Show the information about the list item
    @SuppressLint("SetTextI18n")
    private void setTextViews(String name) {
        BeverageRatingDB db = BeverageRatingDB.getDatabaseInstance(this.getApplicationContext());
        List<BeverageRating> beverageRatingList = db.beverageRatingDAO().getRating(name);

        nameText = beverageRatingList.get(0).beverageName;
        priceText = beverageRatingList.get(0).beveragePrice;
        float ratingFloat = beverageRatingList.get(0).beverageRank;
        ratingText = Float.toString(ratingFloat);
        typeText = beverageRatingList.get(0).beverageType;

        nameTextView = findViewById(R.id.textViewNameUA);
        priceTextView = findViewById(R.id.textViewPriceUA);
        ratingTextView = findViewById(R.id.textViewRatingUA);
        typeTextView = findViewById(R.id.textViewTypeUA);

        nameTextView.setText("The Name of your Beverage is: " + nameText);
        priceTextView.setText("The Price of your Beverage is: " + priceText);
        ratingTextView.setText("The Rating of your Beverage is: " + ratingText);
        typeTextView.setText("The Type of your Beverage is: " + typeText);
    }

    private void initBackButton() {
        backButton = findViewById(R.id.imageButtonBackUA);
        backButton.setOnClickListener(v -> finish());
    }
}