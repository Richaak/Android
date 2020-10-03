package com.example.fragments;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

public class page2 extends Fragment implements View.OnClickListener
{
    Toolbar tb;
    TextInputEditText calender;
    public page2()
    {
    }

    //new instance
    public static page2 newInstance()
    {
        page2 fragment = new page2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    // inflate from page2 activity xml
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_page2, container, false);
    }


    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.male:
                break;
            case R.id.Female:
                    break;
            case R.id.Other:
                    break;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        tb = (Toolbar)view.findViewById(R.id.tool);
        ((AppCompatActivity)getActivity()).setSupportActionBar(tb);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSpinner(view);
        calender = (TextInputEditText)view.findViewById(R.id.calender);
        calender.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
    }


    // for date picker calender

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.calender)
        {
            DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calender.setText((dayOfMonth + "/" + month +"/"+ year ));
                    calender.setText((dayOfMonth + "/" + (month+1) +"/"+ year ));
                }
            }, 2020, 9, 25);
            datePickerDialog.show();
        }
    }




// for spinner
    private void setSpinner(View view) {
        Spinner sp = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(getActivity(),R.array.array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

    }
}