package com.example.ieeehackathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class PatientList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

//        PatientListAdapter adapter = new PatientListAdapter(PatientList.this, WList);
//        ListView listView = findViewById(R.id.workout_list);
//        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
//        // {@link ListView} will display list items for each {@link Word} in the list.
//
//        listView.setAdapter(adapter);
//        WorkoutStartButton.setEnabled(true);
    }
}