package com.example.cervisia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton backButton;
    TextView libraryMenu;
    TextView ratingMenu;
    TextView galleryMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        defineViews();
    }

    private void defineViews() {
        backButton = findViewById(R.id.imageButtonBackMA);
        libraryMenu = findViewById(R.id.textViewLibraryMA);
        ratingMenu = findViewById(R.id.textViewRatingMA);
        galleryMenu = findViewById(R.id.textViewGalleryMA);
        backButton.setOnClickListener(this);
        libraryMenu.setOnClickListener(this);
        ratingMenu.setOnClickListener(this);
        galleryMenu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent libraryIntent = new Intent(MenuActivity.this, LibraryActivity.class);
        Intent ratingIntent = new Intent(MenuActivity.this, AddBeverageRatingActivity.class);
        Intent galleryIntent = new Intent(MenuActivity.this, LibraryActivity.class); //TODO

        switch (v.getId()){
            case R.id.imageButtonBackMA:
                finish();
                break;
            case R.id.textViewLibraryMA:
                startActivity(libraryIntent);
                finish();
                break;
            case R.id.textViewRatingMA:
                startActivity(ratingIntent);
                finish();
                break;
            case R.id.textViewGalleryMA:
                startActivity(galleryIntent);
                finish();
                break;
            default:
                break;
        }
    }
}