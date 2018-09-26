package com.example.android.thebayelsatoureguideapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Get details from intent

        Intent place_details = getIntent();
        final String placeName = place_details.getStringExtra("placeName");
        final String placeDescription = place_details.getStringExtra("placeDescription");

        final int placeImage = place_details.getIntExtra("placeImage", 0);

        // Set intent details on view

        ImageView setImage = (ImageView) findViewById(R.id.details_image);
        setImage.setImageResource(placeImage);

        TextView setName = (TextView) findViewById(R.id.details_name);
        setName.setText(placeName);

        TextView setDescription = (TextView) findViewById(R.id.details_desc);
        setDescription.setText(placeDescription);

        Button back = (Button) findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent(Details.this, MainActivity.class);
                startActivity(goBack);
            }
        });
    }
}
