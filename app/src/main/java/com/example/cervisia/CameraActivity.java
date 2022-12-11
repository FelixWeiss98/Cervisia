package com.example.cervisia;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    private static final int REQUEST_CODE = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        button = findViewById(R.id.buttonCreateCA);
        imageView = findViewById(R.id.imageViewMainCA);

        defineMenuButton();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(cameraIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void defineMenuButton() {
        ImageButton imageButton;
        imageButton = findViewById(R.id.imageButtonBackCA);
        imageButton.setOnClickListener(v -> {
            Intent changeActivityIntent = new Intent(this, MenuActivity.class);
            startActivity(changeActivityIntent);
        });
    }
}