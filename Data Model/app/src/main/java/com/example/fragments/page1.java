package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;


public class page1 extends Fragment
{

    static String name;
    static String number;
    static String email;
    static String pass;
    static String confirmpass;
    Toolbar tb;
   Button button;
    public page1()
    {

    }


    // new instance
    public static page1 newInstance( String fname,String num,String em,String passw,String cpass)
    {
        page1 fragment = new page1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        name=fname;
        number=num;
        email=em;
        pass=passw;
        confirmpass=cpass;

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


        TextInputEditText fname=(TextInputEditText)view.findViewById(R.id.t1);
        TextInputEditText num=(TextInputEditText)view.findViewById(R.id.t2);
        TextInputEditText em=(TextInputEditText)view.findViewById(R.id.t3);
        TextInputEditText passw=(TextInputEditText)view.findViewById(R.id.t4);
        TextInputEditText cpass=(TextInputEditText)view.findViewById(R.id.t5);
         fname.setText(name);
         num.setText(number);
        em.setText(email);
        passw.setText(pass);
        cpass.setText(confirmpass);
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