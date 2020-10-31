package com.example.assignment11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    View relative1;
    ArrayList<exampleitem> examplelist;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // relative1=findViewById(R.id.relative);
        // Snackbar snackbar=Snackbar.make(relative1,"hey",Snackbar.LENGTH_LONG);
        // snackbar.show();

        ArrayList<exampleitem> examplelist = new ArrayList<>();
        examplelist.add(new exampleitem("Richa", "", "", "Female"));
        examplelist.add(new exampleitem("Rahul", "", "", "Male"));
        examplelist.add(new exampleitem("Rahul", "", "", "Male"));
        examplelist.add(new exampleitem("Gauravi", "", "", "Female"));
        examplelist.add(new exampleitem("Imtiyaz", "", "", "Male"));
        examplelist.add(new exampleitem("Rahul", "", "", "Male"));
        examplelist.add(new exampleitem("Lynessa", "", "", "Male"));
        examplelist.add(new exampleitem("Eashan", "", "", "Male"));
        examplelist.add(new exampleitem("Brijesh", "", "", "Male"));
        examplelist.add(new exampleitem("Meera", "", "", "Female"));
        examplelist.add(new exampleitem("Siya", "", "", "Female"));
        examplelist.add(new exampleitem("Mohit", "", "", "Male"));
        examplelist.add(new exampleitem("Kajal", "", "", "Female"));
        examplelist.add(new exampleitem("Shubam", "", "", "Male"));
        examplelist.add(new exampleitem("Riya", "", "", "Female"));
        examplelist.add(new exampleitem("Radha", "", "", "Female"));
        examplelist.add(new exampleitem("Supriya", "", "", "Female"));
        examplelist.add(new exampleitem("Sheetal", "", "", "Female"));
        examplelist.add(new exampleitem("Faizan", "", "", "Male"));
        examplelist.add(new exampleitem("Jay", "", "", "Male"));
        mrecycler = (RecyclerView) findViewById(R.id.recycler);
        mrecycler.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(examplelist, this);

        mrecycler.setLayoutManager(layoutManager);
        mrecycler.setAdapter(mAdapter);
        //cnt();

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.refresh) {
            ArrayList<exampleitem> examplelist = new ArrayList<>();
            examplelist.add(new exampleitem("Richa", "", "", "Female"));
            examplelist.add(new exampleitem("Rahul", "", "", "Male"));
            examplelist.add(new exampleitem("Rahul", "", "", "Male"));
            examplelist.add(new exampleitem("Gauravi", "", "", "Female"));
            examplelist.add(new exampleitem("Imtiyaz", "", "", "Male"));
            examplelist.add(new exampleitem("Rahul", "", "", "Male"));
            examplelist.add(new exampleitem("Lynessa", "", "", "Male"));
            examplelist.add(new exampleitem("Eashan", "", "", "Male"));
            examplelist.add(new exampleitem("Brijesh", "", "", "Male"));
            examplelist.add(new exampleitem("Meera", "", "", "Female"));
            examplelist.add(new exampleitem("Siya", "", "", "Female"));
            examplelist.add(new exampleitem("Mohit", "", "", "Male"));
            examplelist.add(new exampleitem("Kajal", "", "", "Female"));
            examplelist.add(new exampleitem("Shubam", "", "", "Male"));
            examplelist.add(new exampleitem("Riya", "", "", "Female"));
            examplelist.add(new exampleitem("Radha", "", "", "Female"));
            examplelist.add(new exampleitem("Supriya", "", "", "Female"));
            examplelist.add(new exampleitem("Sheetal", "", "", "Female"));
            examplelist.add(new exampleitem("Faizan", "", "", "Male"));
            examplelist.add(new exampleitem("Jay", "", "", "Male"));
            mrecycler.setHasFixedSize(true);
            layoutManager = new LinearLayoutManager(this);
            mAdapter = new ExampleAdapter(examplelist, this);

            mrecycler.setLayoutManager(layoutManager);
            mrecycler.setAdapter(mAdapter);
        }
        return super.onOptionsItemSelected(item);
    }

   /* private void cnt() {
        Integer scholarship = 0;
        for (int i = 0; i < examplelist.size(); i++) {
            if (examplelist.get(i).equals("Female")) ;
            {
                scholarship += 50000;
            }
        }
        Toast.makeText(this, "Amount is "+scholarship,Toast.LENGTH_SHORT).show();

    }*/
}