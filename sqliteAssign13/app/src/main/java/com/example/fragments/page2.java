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
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class page2 extends Fragment implements View.OnClickListener
{
    Toolbar tb;
    static String state;
    Button b1;
    Button b2;
   private MainActivity mainActivity;
    TextInputEditText calender;
    public page2()
    {
    }

    //new instance
    public static page2 newInstance(String stat)
    {
        page2 fragment = new page2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        state=stat;
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
     //   tb = (Toolbar)view.findViewById(R.id.tool);
        TextInputEditText stat=(TextInputEditText)view.findViewById(R.id.tb1);
        stat.setText(state);
    //   ((AppCompatActivity)getActivity()).setSupportActionBar(tb);
     //   ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setSpinner(view);
        calender = (TextInputEditText)view.findViewById(R.id.calender);
        b1=(Button)view.findViewById(R.id.submit);
        b2=(Button)view.findViewById(R.id.view);
        calender.setOnClickListener(this);
        super.onViewCreated(view, savedInstanceState);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ((MainActivity)getActivity()).insertuserdata();
    }
});

b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ((MainActivity)getActivity()).View();
    }
});

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