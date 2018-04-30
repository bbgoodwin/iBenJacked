package com.example.benjamin.databasemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class addWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        LinearLayout layout = new LinearLayout(this);

        TextView addWorkout = new TextView(this);
        addWorkout.setText("Add a workout");
        layout.addView(addWorkout);

        ArrayList<String> spinnerArray = new ArrayList<String>();
        spinnerArray.add("Choose a Body Part");
        spinnerArray.add("arms");
        spinnerArray.add("legs");
        spinnerArray.add("abs");
        spinnerArray.add("back");
        spinnerArray.add("chest");

        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);

        layout.setPadding(100,50,100,100);

        layout.addView(spinner);

        ArrayList<String> armWorkouts = new ArrayList<String>();
        ArrayList<String> legWorkouts = new ArrayList<String>();
        ArrayList<String> abWorkouts = new ArrayList<String>();

        if(spinner.getSelectedItem().toString()=="arms"){
            armWorkouts.add("Choose a Workout");
            armWorkouts.add("Bicep Curl");
            armWorkouts.add("EZ-Bar Curl");
            armWorkouts.add("Zottman Curl");
            armWorkouts.add("Hammer Curl");
            armWorkouts.add("Overhead Cable Curl");
            armWorkouts.add("Dips");
            armWorkouts.add("EZ-Bar Tricep Extension");
            armWorkouts.add("Dumbbell Floor Press");
            armWorkouts.add("Tricep Pushdown");
            armWorkouts.add("Weighted Bench Dip");
            armWorkouts.add("Standing Dumbbell Tricep Extension");
        }
        else if(spinner.getSelectedItem().toString()=="legs"){
            legWorkouts.add("Choose a Workout");
            legWorkouts.add("Front Squat");
            legWorkouts.add("Bulgarian Split Squat");
            legWorkouts.add("Romanian Deadlift");
            legWorkouts.add("Squat");
            legWorkouts.add("Dumbbell Stepup");
            legWorkouts.add("Deadlift");
            legWorkouts.add("Swiss Ball Leg Curl");
            legWorkouts.add("Leg Press");
            legWorkouts.add("Calf Raise");
            legWorkouts.add("Lunge");
        }
        else if(spinner.getSelectedItem().toString()=="abs"){
            abWorkouts.add("Crunches");
            abWorkouts.add("Sit-ups");
            abWorkouts.add("Ab Wheel Rollout");
            abWorkouts.add("");
        }

        setContentView(layout);
    }
}
