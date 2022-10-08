package com.example.ieeehackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Patient> PatientList;
        PatientList = new ArrayList<>();

        PatientList.add(new Patient("Kartik", 21, "Dermatologist", 1, "Patient ill" ));
        PatientList.add(new Patient("Ashish", 22, "Psychologist", 1, "Patient mentally ill" ));
        PatientList.add(new Patient("Kartik", 22, "Psychologist", 1, "Patient mentally ill" ));

        AppCompatButton FoodServicesButton = findViewById(R.id.food_services_button);
        FoodServicesButton.setOnClickListener(view -> {
        Intent myIntent = new Intent(MainActivity.this, FoodServicesHome.class);
        myIntent.putExtra("type", "food");          //to know from which button the intent was called
        Bundle args = new Bundle();
        args.putSerializable("ARRAYLIST",PatientList);
        myIntent.putExtra("BUNDLE",args);
        startActivity(myIntent);
        });

        AppCompatButton BedServicesButton = findViewById(R.id.bed_services_button);
        BedServicesButton.setOnClickListener(view -> {
            Intent myIntent = new Intent(MainActivity.this, FoodServicesHome.class);
            myIntent.putExtra("type", "bed");          //to know from which button the intent was called
            Bundle args = new Bundle();
            args.putSerializable("ARRAYLIST",PatientList);
            myIntent.putExtra("BUNDLE",args);
            startActivity(myIntent);
        });
    }
}