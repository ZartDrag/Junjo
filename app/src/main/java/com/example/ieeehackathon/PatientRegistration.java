package com.example.ieeehackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PatientRegistration extends AppCompatActivity {

    private EditText NameTextBox, AgeTextBox, DescriptionTextBox;
    private ArrayList<Patient> PatientList;
    private Spinner PriorityDropdown, SpecialistDropdown;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        Intent thisIntent = getIntent();
        String type = thisIntent.getStringExtra("type");
        Bundle args = thisIntent.getBundleExtra("BUNDLE");
        PatientList = (ArrayList<Patient>) args.getSerializable("ARRAYLIST");


        Button SubmitButton = findViewById(R.id.submit_button);
        NameTextBox = findViewById(R.id.name_text_box);
        AgeTextBox = findViewById(R.id.dob_text_box);
        DescriptionTextBox = findViewById(R.id.description_text_box);
        PriorityDropdown = findViewById(R.id.priority_dropdown);
        SpecialistDropdown = findViewById(R.id.specialist_dropdown);

        String[] arraySpinner = new String[] { "4", "3", "2", "1" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        PriorityDropdown.setAdapter(adapter);

        arraySpinner = new String[]
                { "General Physician", "Orthologist", "Pathologist", "Dermatalogist", "Dentist" };

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpecialistDropdown.setAdapter(adapter);

        SubmitButton.setOnClickListener( view -> {
            if(SubmitForm()) {
                Toast.makeText(this, "Patient Added Successfully", Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent(PatientRegistration.this, PatientList.class);
                myIntent.putExtra("type", type);
                Bundle args1 = new Bundle();
                args1.putSerializable("ARRAYLIST", PatientList);
                myIntent.putExtra("BUNDLE", args1);
                startActivity(myIntent);
            }
            else
                Toast.makeText(this, "Unable to add patient", Toast.LENGTH_LONG).show();
        });

    }

    private boolean SubmitForm(){
        try {
            String name = String.valueOf(NameTextBox.getText());
            int age = Integer.parseInt(String.valueOf(AgeTextBox.getText()));
            String des = String.valueOf(DescriptionTextBox.getText());
            int priority = Integer.parseInt(PriorityDropdown.getSelectedItem().toString());
            String Spec = SpecialistDropdown.getSelectedItem().toString();

            PatientList.add(new Patient(name, age, Spec, priority, des));
            return true;
        } catch (Exception ex){
            return false;
        }
    }
}