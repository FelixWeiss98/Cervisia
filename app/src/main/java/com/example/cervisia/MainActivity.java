package com.example.cervisia;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defineViews();
    }

    private void defineViews() {
        startButton = findViewById(R.id.buttonStartMA);

        startButton.setOnClickListener(v -> {
            Intent changeActivityIntent = new Intent(MainActivity.this, LibraryActivity.class);
            startActivity(changeActivityIntent);
        });
    }
}