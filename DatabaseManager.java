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
    private static final String TABLE_USERS="Users";
    private static final String USER = "USERNAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlCreateTable = "CREATE TABLE " + TABLE_USERS + " (" +
                USER + " TEXT PRIMARY KEY, " + EMAIL + " TEXT," + PASSWORD + " TEXT)";
        sqLiteDatabase.execSQL(sqlCreateTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+ TABLE_USERS);
        onCreate(sqLiteDatabase);
    }

    public boolean checkUnique(String user){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS +  " WHERE " + USER  + " = " + user;
        Cursor cur = db.rawQuery(query, new String[] { user });
        if (cur.getCount()==0){
            cur.close();
            db.close();
            return true;
        }
        else {
            cur.close();
            db.close();
            return false;
        }
    }

    public boolean login(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM "+TABLE_USERS+" WHERE user=? AND password=?";
        Cursor cur = db.rawQuery(sql, new String[] { user, password });
        if(cur.getCount()==0){
            cur.close();
            db.close();
            return false;
        }
        else{
            cur.close();
            db.close();
            return true;
        }
    }

    public void insert( User user) {
        SQLiteDatabase db = this.getWritableDatabase( );
        String sqlInsert = "INSERT INTO " + TABLE_USERS + "(" + USER + "," + EMAIL + "'" + PASSWORD + ")";
        sqlInsert += " values("+null+",'"+ user.getName() +"','"+ user.getEmail() + "','" + user.getPassword() + "')";
        db.execSQL( sqlInsert );
        db.close( );
    }

    public void delete(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlDelete = "delete from" + TABLE_USERS + "where id_number = "+id+"";
        db.execSQL(sqlDelete);
        db.close();
    }

    public ArrayList<User> selectAll( ) {
        String sqlQuery = "select * from " + TABLE_USERS;

        SQLiteDatabase db = this.getWritableDatabase( );
        Cursor cursor = db.rawQuery( sqlQuery, null );

        ArrayList<User> userList = new ArrayList<User>( );
        while( cursor.moveToNext( ) ) {
            User currentStudent
                    = new User(cursor.getString( 0 ),
                    cursor.getString( 1 ), cursor.getString(2));
            userList.add( currentStudent );
        }
        db.close( );
        return userList;
    }
}

