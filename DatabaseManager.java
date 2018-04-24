package com.example.benjamin.databasemanager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by bbgoodwin on 4/1/2018.
 */

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "iBenJackedDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "Users";
    private static final String TABLE_WORKOUT = "Profile";
    private static final String USER = "USERNAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Creates the database table with the user as the primary key because usernames will
        //be unique therefore they qualify as primary keys
        String sqlCreateUserTable = "CREATE TABLE " + TABLE_USERS + "(" +
                USER + " TEXT PRIMARY KEY NOT NULL, " + EMAIL + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(sqlCreateUserTable);
        String sqlCreateWorkoutTable = "CREATE TABLE " + TABLE_WORKOUT + "(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + USER
                + "TEXT NOT NULL, WORKOUT STRING NOT NULL, SETS INTEGER NOT NULL, REPS INTEGER NOT NULL, FOREIGN KEY(" + USER + ") REFERENCES " + TABLE_USERS + "(" + USER + "));";
        sqLiteDatabase.execSQL(sqlCreateWorkoutTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

    public void addWorkout(String username, Workout workout) {
        //This will insert the username and the workout into the table workout.
        //Also, the workouts will be given an auto incrementing id.
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "INSERT INTO " + TABLE_WORKOUT + "( ID, " + USER + ", WORKOUT, SETS, REPS)";
        sqlInsert += " values( null,'" + username + "','" + workout.getWorkout() + "'," + workout.getSets() + "," + workout.getReps() + ");";
        db.execSQL(sqlInsert);
        db.close();
    }

    public void removeWorkout(int id) {
        //This will take the id for one of the workouts and delete the workout
        //associated with that id.
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlRemove = "DELETE FROM " + TABLE_WORKOUT + " WHERE ID = " + id + ";";
        db.execSQL(sqlRemove);
        db.close();
    }

    public boolean checkUnique(String user) {
        //This will check the database to see if the requested username is there.
        //If the cursor counter is 0 then that means that the username is not used.
        //If the cursor counter is greater then 0 then that means that somebody already
        //has that username.
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + USER + " = ?;";
        Cursor cur = db.rawQuery(query, new String[]{user});
        if (cur.getCount() == 0) {
            cur.close();
            db.close();
            return true;
        } else {
            cur.close();
            db.close();
            return false;
        }
    }

    public boolean login(String user, String password) {
        //This will see if the inputted username and password input are paired together
        //in the database. If the cursor is 0 then that username and password are not
        //found together. If the cursor is greater than 0 then the username and password
        //are a match.
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_USERS + " WHERE USERNAME = ? AND PASSWORD = ?;";
        Cursor cur = db.rawQuery(sql, new String[]{user, password});
        if (cur.getCount() == 0) {
            cur.close();
            db.close();
            return false;
        } else {
            cur.close();
            db.close();
            return true;
        }
    }

    public void insert(User user) {
        //This will take in a new user and insert them into the database.
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlInsert = "INSERT INTO " + TABLE_USERS + " (" + USER + "," + EMAIL + "," + PASSWORD +  ") VALUES ('" + user.getName() + "' , '" + user.getEmail() + "' , '" + user.getPassword() + "');";
        db.execSQL(sqlInsert);
        db.close();
    }

    public void delete(String username) {
        //This will take in a username and delete that user from the database.
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "DELETE FROM " + TABLE_USERS + " WHERE USERNAME = " + username + ";";
        db.execSQL(sqlDelete);
        db.close();
    }

    public ArrayList<User> selectAll() {
        //This will display all the users in the database.
        String sqlQuery = "select * from " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sqlQuery, null);

        ArrayList<User> userList = new ArrayList<User>();
        while (cursor.moveToNext()) {
            User currentStudent
                    = new User(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2));
            userList.add(currentStudent);
        }
        db.close();
        return userList;
    }
}

