package com.example.ieeehackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatButton FoodServicesButton = findViewById(R.id.food_services_button);
        FoodServicesButton.setOnClickListener(view -> {
        Intent myIntent = new Intent(MainActivity.this, FoodServicesHome.class);
        myIntent.putExtra("type", "food");          //to know from which button the intent was called
        startActivity(myIntent);
        });

        AppCompatButton BedServicesButton = findViewById(R.id.bed_services_button);
        BedServicesButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, FoodServicesHome.class);
            myIntent.putExtra("type", "bed");          //to know from which button the intent was called
            startActivity(myIntent);
        });
    }
}