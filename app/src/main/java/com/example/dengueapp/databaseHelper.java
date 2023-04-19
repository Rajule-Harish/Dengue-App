package com.example.dengueapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class databaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "dengueApp.db";
    public static final int DATABASE_VERSION = 1;


    public databaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q= "create table users(sl integer primary key autoincrement, name text, email text UNIQUE, phno text ,pass text, userId text)" ;
        db.execSQL(q);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS users" );
        onCreate(db);
    }

    public Boolean insert_data(String name, String email, String phno, String pass)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put("name", name);        //  public void put(String key, String value)
        c.put("email", email);      // key is a string that represents the column name
        c.put("phno", phno);        // value is the data that you want to insert or update in that column.
        c.put("pass", pass);

        String initials = "";
        for (String s : name.split(" ")) {
            initials+= s.charAt(0);
        }
        Cursor cursor= db.rawQuery("select * from users",null);
        int cc = cursor.getCount();
        String tempc= Integer.toString(cc);
        initials+=tempc+"@p";
        c.put("userId", initials);

        long rId= db.insert("users", null, c);
        db.close();
        if(rId==-1)
        {
            return false;
        }
        return true;

    }

    public boolean checkUser(String email)
    {
        SQLiteDatabase db= this.getReadableDatabase();

        Cursor cursor= db.rawQuery("select * from users where email=?",new String[]{email});
        int cc = cursor.getCount();
        cursor.close();
        db.close();

        return cc > 0;

    }

    public boolean checkUser(String email,String pass)
    {


        SQLiteDatabase db= this.getReadableDatabase();


        Cursor cursor= db.rawQuery("select * from users where email=? and pass=?",new String[]{email,pass});
        int cc = cursor.getCount();
        cursor.close();
        db.close();

        return cc > 0;

    }

    public boolean checkAdmin(String email,String pass)
    {


        SQLiteDatabase db= this.getReadableDatabase();


        Cursor cursor= db.rawQuery("select * from users where email=? and pass=?",new String[]{email,pass});
        int cc = cursor.getCount();
        cursor.close();
        db.close();

        return cc > 0;

    }

    public boolean checkGovOff(String email,String pass)
    {


        SQLiteDatabase db= this.getReadableDatabase();


        Cursor cursor= db.rawQuery("select * from users where email=? and pass=?",new String[]{email,pass});
        int cc = cursor.getCount();
        cursor.close();
        db.close();

        return cc > 0;

    }

    public boolean checkLabAuth(String email,String pass)
    {


        SQLiteDatabase db= this.getReadableDatabase();


        Cursor cursor= db.rawQuery("select * from users where email=? and pass=?",new String[]{email,pass});
        int cc = cursor.getCount();
        cursor.close();
        db.close();

        return cc > 0;

    }

}
