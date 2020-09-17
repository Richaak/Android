package com.example.assign4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= findViewById(R.id.b1);
        button2= findViewById(R.id.b2);
        button3= findViewById(R.id.b3);
        button4= findViewById(R.id.b4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                LayoutInflater i=getLayoutInflater();
                View v=i.inflate(R.layout.layoutred,null);
                LinearLayout L=(LinearLayout)findViewById(R.id.layoutt);
                L.addView(v);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater i=getLayoutInflater();
                View v=i.inflate(R.layout.layoutyellow,null);
                LinearLayout L=(LinearLayout)findViewById(R.id.layoutt);
                L.addView(v);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater i=getLayoutInflater();
                View v=i.inflate(R.layout.layoutgreen,null);
                LinearLayout L=(LinearLayout)findViewById(R.id.layoutt);
                L.addView(v);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater i=getLayoutInflater();
                View v=i.inflate(R.layout.layoutblue,null);
                LinearLayout L=(LinearLayout)findViewById(R.id.layoutt);
                L.addView(v);
            }
        });
    }
}