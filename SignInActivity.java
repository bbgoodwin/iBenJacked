package com.example.benjamin.databasemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    private DatabaseManager db;

    @Override
    protected void oncreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseManager(this);
        setContentView(R.layout.signinactivity);
    }

    public boolean addUser(View view) {
        //This will register the user into the database. It takes the text from the
        //EditText boxes, gets the string from them and adds that to the database.
        EditText usernameBox = (EditText) findViewById(R.id.RegisterUsername);
        EditText emailBox = (EditText) findViewById(R.id.RegisterEmail);
        EditText passwordBox = (EditText) findViewById(R.id.RegisterPassword);

        String username = usernameBox.getText().toString();
        String useremail = emailBox.getText().toString();
        String userpassword = passwordBox.getText().toString();
        try {
            if (db.checkUnique(username) == true) {
                db.insert(new User(username, useremail, userpassword));
                change(view);
                Toast.makeText(this, "User Added", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception exception) {
            Toast.makeText(this, "Error: " + exception.getMessage(), Toast.LENGTH_LONG).show();
        }

        usernameBox.setText("");
        emailBox.setText("");
        passwordBox.setText("");
        return false;
    }

    public boolean signIn(View view) {
        //This will take the username and password from the EditText boxes and user the database
        //login function to see if the user entered the correct information.
        EditText usernameBox = (EditText) findViewById(R.id.username);
        EditText passwordBox = (EditText) findViewById(R.id.password);

        String username = usernameBox.getText().toString();
        String password = passwordBox.getText().toString();
        try {
            if (db.login(username, password) == true) {
                change(view);
                Toast.makeText(this, "User Signed In", Toast.LENGTH_SHORT).show();
                return true;
            }
        } catch (Exception exception) {
            Toast.makeText(this, "Error: " + exception.getMessage(), Toast.LENGTH_LONG).show();
        }

        usernameBox.setText("");
        passwordBox.setText("");
        return false;
    }

    public void change(View v) {
        Intent myIntent = new Intent(this, profileActivity.class);
        this.startActivity(myIntent);
        overridePendingTransition(R.anim.animation, 0);
    }
}
