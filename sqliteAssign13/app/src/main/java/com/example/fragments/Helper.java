package com.example.fragments;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Helper extends SQLiteOpenHelper


{
    public Helper(Context context) {
        super(context,"USERDATABASE.DB",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table users (id INTEGER PRIMARY KEY AUTOINCREMENT,name text,num text,email text,pass text,gender text,district text,dob text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists users");
        onCreate(sqLiteDatabase);
    }
}
