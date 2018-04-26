package com.example.benjamin.databasemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    private DatabaseManager db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseManager(this);
        setContentView(R.layout.activity_profile);
        setGreet();
    }

    public void setGreet() {
        TextView greet = (TextView) findViewById(R.id.Greet);
        greet.setText("Hello " + SignIn.signedInUser + "!");
    }

    public void removeWorkout(View view) {
        EditText idview = (EditText) findViewById(R.id.DeleteText);

        int id = Integer.valueOf(idview.getText().toString());

        try {
            db.removeWorkout(id);
            displayWorkouts();
            Toast.makeText(this, "Workout Removed", Toast.LENGTH_SHORT).show();

        } catch (Exception exception) {
            Toast.makeText(this, "Error: " + exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void displayWorkouts() {
        TextView display = (TextView) findViewById(R.id.Workouts);
        try {
            display.setText(db.selectWorkouts().toString());
        } catch (Exception exception) {
            Toast.makeText(this, "Error: " + exception.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

 /*   public void changeToWorkout(View v) {
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
    }*/

}
