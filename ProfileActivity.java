package com.example.benjamin.databasemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseManager(this);
        setContentView(R.layout.profileactivity);
    }

    public void removeWorkout(View view) {
        TextView idview = (TextView) findViewById(R.id.workoutID);

        int id = Integer.valueOf(idview.getText().toString());

        try {
            db.removeWorkout(id);
            Toast.makeText(this, "Workout Removed", Toast.LENGTH_SHORT).show();

        } catch (Exception exception) {
            Toast.makeText(this, "Error: " + exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void changeToWorkout(View v) {
        Intent myIntent = new Intent(this, workoutActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

    public void changeToPicture(View v){
        Intent myIntent = new Intent(this, pictureActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

    public void changeToPast(View v){
        Intent myIntent = new Intent(this, pastActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

}
