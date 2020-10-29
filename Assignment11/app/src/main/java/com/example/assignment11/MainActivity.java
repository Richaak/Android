package com.example.assignment11;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mrecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    View relative1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // relative1=findViewById(R.id.relative);
        // Snackbar snackbar=Snackbar.make(relative1,"hey",Snackbar.LENGTH_LONG);
        // snackbar.show();

        ArrayList<exampleitem> examplelist=new ArrayList<>();
        examplelist.add(new exampleitem("Richa",""));
        examplelist.add(new exampleitem("Rahul",""));
        examplelist.add(new exampleitem("Rahul",""));
        examplelist.add(new exampleitem("Gauravi",""));
        examplelist.add(new exampleitem("Imtiyaz",""));
        examplelist.add(new exampleitem("Rahul",""));
        examplelist.add(new exampleitem("Lynessa",""));
        examplelist.add(new exampleitem("Eashan",""));
        examplelist.add(new exampleitem("Brijesh",""));
        examplelist.add(new exampleitem("Meera",""));
        examplelist.add(new exampleitem("Siya",""));
        examplelist.add(new exampleitem("Mohit",""));
        examplelist.add(new exampleitem("Kajal",""));
        examplelist.add(new exampleitem("Shubam",""));
        examplelist.add(new exampleitem("Riya",""));
        examplelist.add(new exampleitem("Radha",""));
        examplelist.add(new exampleitem("Supriya",""));
        examplelist.add(new exampleitem("Sheetal",""));
        examplelist.add(new exampleitem("Faizan",""));
        examplelist.add(new exampleitem("Jay",""));
        mrecycler=(RecyclerView)findViewById(R.id.recycler);
        mrecycler.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        mAdapter=new ExampleAdapter(examplelist);

        mrecycler.setLayoutManager(layoutManager);
        mrecycler.setAdapter(mAdapter);

    }
}