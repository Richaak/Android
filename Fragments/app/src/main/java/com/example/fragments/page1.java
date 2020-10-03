package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class page1 extends Fragment
{
    Toolbar tb;
    public page1()
    {
    }

    // new instance
    public static page1 newInstance()
    {
        page1 fragment = new page1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    // inflate from page1 xml page
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_page1, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        tb = (Toolbar)view.findViewById(R.id.tool);


        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onViewCreated(view, savedInstanceState);
    }




    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater)
    {
        ((AppCompatActivity)getActivity()).getMenuInflater().inflate(R.menu.right,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}