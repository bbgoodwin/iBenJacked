package com.example.benjamin.databasemanager;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class addWorkout extends Activity implements
        AdapterView.OnItemSelectedListener {

    private Spinner spinner, workoutSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);
        spinner = (Spinner) findViewById(R.id.body);
        workoutSpinner = (Spinner) findViewById(R.id.workouts);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        String value = String.valueOf(spinner.getSelectedItem());

        if (value.contentEquals("Arms")) {
            List<String> workouts = new ArrayList<String>();
            workouts.add("Choose a Workout");
            workouts.add("Bicep Curl");
            workouts.add("EZ-Bar Curl");
            workouts.add("Zottman Curl");
            workouts.add("Hammer Curl");
            workouts.add("Overhead Cable Curl");
            workouts.add("Dips");
            workouts.add("EZ-Bar Tricep Extension");
            workouts.add("Dumbbell Floor Press");
            workouts.add("Tricep Pushdown");
            workouts.add("Weighted Bench Dip");
            workouts.add("Standing Dumbbell Tricep Extension");
            ArrayAdapter<String> workoutAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, workouts);
            workoutAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            workoutAdapter.notifyDataSetChanged();
            workoutSpinner.setAdapter(workoutAdapter);
        } else if (String.valueOf(spinner.getSelectedItem()).contentEquals("Legs")) {
            List<String> workouts = new ArrayList<String>();
            workouts.add("Choose a Workout");
            workouts.add("Front Squat");
            workouts.add("Bulgarian Split Squat");
            workouts.add("Romanian Deadlift");
            workouts.add("Squat");
            workouts.add("Dumbbell Stepup");
            workouts.add("Deadlift");
            workouts.add("Swiss Ball Leg Curl");
            workouts.add("Leg Press");
            workouts.add("Calf Raise");
            workouts.add("Lunge");
            ArrayAdapter<String> workoutAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, workouts);
            workoutAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            workoutAdapter2.notifyDataSetChanged();
            workoutSpinner.setAdapter(workoutAdapter2);
        } else if (spinner.getSelectedItem().toString() == "Abs") {
            List<String> workouts = new ArrayList<String>();
            workouts.add("Crunches");
            workouts.add("Sit-ups");
            workouts.add("Ab Wheel Rollout");
            workouts.add("Swiss Ball Crunch");
            workouts.add("Flutter Kick");
            workouts.add("Leg Raise");
            workouts.add("Medicine Ball Russian Twist");
            workouts.add("Mountain Climber");
            workouts.add("Plank");
            workouts.add("Side Plank");
            ArrayAdapter<String> workoutAdapter3 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, workouts);
            workoutAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            workoutAdapter3.notifyDataSetChanged();
            workoutSpinner.setAdapter(workoutAdapter3);
        } else if (spinner.getSelectedItem().toString() == "Chest") {
            List<String> workouts = new ArrayList<String>();
            workouts.add("Bench Press");
            workouts.add("Dumbbell Fly");
            workouts.add("Cable Crossover");
            workouts.add("Chest Press Machine");
            workouts.add("Landmine Press");
            workouts.add("Pullover");
            workouts.add("Plate Pressout");
            workouts.add("Push up");
            ArrayAdapter<String> workoutAdapter4 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, workouts);
            workoutAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            workoutAdapter4.notifyDataSetChanged();
            workoutSpinner.setAdapter(workoutAdapter4);
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

    public void inputWorkout(View v) {
        DatabaseManager db = new DatabaseManager(this);
        EditText weight = (EditText) findViewById(R.id.weight);
        EditText sets = (EditText) findViewById(R.id.sets);
        EditText reps = (EditText) findViewById(R.id.reps);

        db.addWorkout(new Workout(0,"user", "date", workoutSpinner.getSelectedItem().toString(),spinner.getSelectedItem().toString(),
                Integer.valueOf(weight.getText().toString()),Integer.valueOf(sets.getText().toString()),Integer.valueOf(reps.getText().toString())));

        Intent myIntent = new Intent(this, Profile.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }
}
