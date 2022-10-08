package com.example.ieeehackathon;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class PatientListAdapter extends ArrayAdapter<Patient> {
    FragmentActivity con;
    Context contex;

    public PatientListAdapter(Context context, ArrayList<Patient> Patients) {
        super(context, 0, Patients);
        con = (FragmentActivity) context;
        contex = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.patient_list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Patient currentPatient = getItem(position);


        TextView nameTextView = listItemView.findViewById(R.id.name_text_view);
        nameTextView.setText(currentPatient.getName());

        TextView priorTextView = listItemView.findViewById(R.id.priority_text_box);
        priorTextView.setText(currentPatient.getPrior());

        TextView profTextView = listItemView.findViewById(R.id.check_profile_text_view);
        profTextView.setOnClickListener(view -> {
            Intent myIntent = new Intent(contex, PatientProfile.class);
            contex.startActivity(myIntent);
        });
        return listItemView;

    }

}
