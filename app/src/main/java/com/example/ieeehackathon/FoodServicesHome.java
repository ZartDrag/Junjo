package com.example.ieeehackathon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class FoodServicesHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_services_home);
        Intent thisIntent = getIntent();
        String type = thisIntent.getStringExtra("type");
        Bundle args = thisIntent.getBundleExtra("BUNDLE");
        ArrayList<Patient> PatientList = (ArrayList<Patient>) args.getSerializable("ARRAYLIST");

        View view = this.getWindow().getDecorView();
        if(type.equals("food"))
            view.setBackgroundColor(getResources().getColor(R.color.food_services_button_bg));
        else if(type.equals("bed"))
            view.setBackgroundColor(getResources().getColor(R.color.bed_services_button_bg));

        AppCompatButton NewRegistrationButton = findViewById(R.id.new_patient_registration_button);
        AppCompatButton ShowPatientListButton = findViewById(R.id.show_patient_list_button);

        NewRegistrationButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(FoodServicesHome.this, PatientRegistration.class);
            myIntent.putExtra("type", type);
            Bundle args1 = new Bundle();
            args1.putSerializable("ARRAYLIST",PatientList);
            myIntent.putExtra("BUNDLE",args1);
            startActivity(myIntent);
        });

        ShowPatientListButton.setOnClickListener(v -> {
            Intent myIntent = new Intent(FoodServicesHome.this, PatientList.class);
            myIntent.putExtra("type", type);
            Bundle args1 = new Bundle();
            args1.putSerializable("ARRAYLIST",PatientList);
            myIntent.putExtra("BUNDLE",args1);
            startActivity(myIntent);
        });
    }
}