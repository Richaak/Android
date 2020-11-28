package com.example.fragments;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBClient {
    Helper helper;
    Context context;



    SQLiteDatabase database;

    public DBClient(Context context) {
        this.context = context;
    }
    public void open(){
        helper = new Helper(context);
        database = helper.getWritableDatabase();
    }

    public void close(){
        helper.close();
    }




//add user function
    public void add(String name,String num,String email,String pass,String gender,String district,String dob){
        ContentValues params = new ContentValues();
        params.put("name",name);
        params.put("num",num);
        params.put("email",email);
        params.put("pass",pass);


        params.put("gender",gender);
        params.put("district",district);
        params.put("dob",dob);
        database.insert("users",null,params);
    }

    public Cursor getUsers() {
        Cursor res = database.rawQuery("select * from users",null);
        return res;
    }
}

