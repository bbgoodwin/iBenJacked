package com.example.benjamin.databasemanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Body extends AppCompatActivity {

    public static String passCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
    }

    public void changeToArmSelection() {
        passCategory="arms";
        Intent myIntent = new Intent(this, SelectWorkout.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

    public void changeToLegsSelection() {
        passCategory="legs";
        Intent myIntent = new Intent(this, SelectWorkout.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

    public void changeToAbsSelection() {
        passCategory="abs";
        Intent myIntent = new Intent(this, SelectWorkout.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

    public void changeToChestSelection() {
        passCategory="chest";
        Intent myIntent = new Intent(this, SelectWorkout.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }

    public void changeToBackSelection() {
        passCategory="back";
        Intent myIntent = new Intent(this, SelectWorkout.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }
}
