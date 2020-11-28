package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity
{
ViewPager VP;
String name;
String number;
String email;
String pass;
String confirmpass;
String state;
String calende;
DBClient dbClient;
Toolbar tb;
//private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VP = (ViewPager)findViewById(R.id.vp);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
     //   button=(Button)findViewById(R.id.info);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter Fpa = new MyPagerAdapter(fragmentManager);
        VP.setAdapter(Fpa);


        tb = (Toolbar)findViewById(R.id.tool);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*
        profile profile=new profile();
        name=profile.getName();
        number=profile.getNumber();
        email=profile.getEmail();
pass=profile.getPass();
confirmpass=profile.getConfirmpass();
state=profile.getState();
*/

        dbClient = new DBClient(this);
        dbClient.open();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.right, menu);
        return true;
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public Fragment getItem(int position) {
            if (position == 0) {

                return page1.newInstance(name, number, email, pass, confirmpass);
            } else if (position == 1) {
                return page2.newInstance(state);
            }
            return null;
        }


        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "PAGE 1";
            } else if (position == 1) {
                return "PAGE 2";
            }
            return null;
        }


        @Override
        public int getCount()
        {
            return 2;
        }


    }

    private void display(String Message){
        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setCancelable(true);
        al.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        al.setMessage(Message);
        al.show();
    }


    public void insertuserdata() {
        TextView namee = (TextView)findViewById(R.id.t1);
        TextView numm = (TextView)findViewById(R.id.t2);
        TextView emaill = (TextView)findViewById(R.id.t3);
        TextView passs = (TextView)findViewById(R.id.t4);
        TextView confirmpasss = (TextView)findViewById(R.id.t5);


        String passwordd = passs.getText().toString();
        String cpass = confirmpasss.getText().toString();
        String name = namee.getText().toString();
        String num = numm.getText().toString();
        String email = emaill.getText().toString();
        RadioGroup genders = (RadioGroup)findViewById(R.id.radgrp);
        int rid = genders.getCheckedRadioButtonId();



        RadioButton Gender = findViewById(rid);
        String gender = "";
        if(Gender!=null) {
            gender = Gender.getText().toString();
        }

/*else{
            Toast.makeText(getApplicationContext(),"Select your gender",Toast.LENGTH_LONG).show();

        }*/

        Spinner districts = findViewById(R.id.spinner);
        String d = (String) districts.getSelectedItem();


        TextInputEditText calender = findViewById(R.id.calender);




        String dob = calender.getText().toString();

        if(!name.isEmpty()&&!num.isEmpty()&&!email.isEmpty()

                &&!passwordd.isEmpty()&&!cpass.isEmpty()&&!gender.isEmpty()&&!dob.isEmpty()){

            if(passwordd.equals(cpass))

            {
                dbClient.add(name,num,email,passwordd,gender,d,dob);

                Toast.makeText(getApplicationContext(),"Data added",Toast.LENGTH_LONG).show();





            }
            else
                {
                Toast.makeText(getApplicationContext(),"Please enter same passwords!",Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(getApplicationContext(),"Some fields are empty!",Toast.LENGTH_LONG).show();
        }

    }

    public void View()



    {
        Cursor cursor = dbClient.getUsers();
        if(cursor.getCount()>0){





            StringBuffer b = new StringBuffer();
            while (cursor.moveToNext()) {
                b.append("Name="+ cursor.getString(1)+"\n");
                b.append("Phone Number="+ cursor.getString(2)+"\n");
                b.append("Email id="+ cursor.getString(3)+"\n");
                b.append("Password="+ cursor.getString(4)+"\n");
                b.append("Gender="+ cursor.getString(5)+"\n");
                b.append("District="+ cursor.getString(6)+"\n");
                b.append("Birthday="+ cursor.getString(7)+"\n\n");
            }

            display(b.toString());
        }else

            {
            Toast.makeText(this,"No data present",Toast.LENGTH_SHORT).show();
        }

    }


}
