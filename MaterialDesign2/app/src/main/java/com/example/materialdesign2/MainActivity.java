package com.example.materialdesign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.service.autofill.Dataset;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
private Toolbar toolbar;
private EditText editcal;
Button button;
private DatePickerDialog DateDialog;
int year,month,dayofmonth;
Calendar calender ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.tb);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        button=(Button)findViewById(R.id.buttoncal);
        editcal=(EditText)findViewById(R.id.editcalender);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Calendar cal= Calendar.getInstance();
                year=cal.get(Calendar.YEAR);
                month=cal.get(Calendar.MONTH);
                 dayofmonth=cal.get(Calendar.DAY_OF_MONTH);

                DateDialog=new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                editcal.setText((day + "/" + month +"/"+ year ));
                                editcal.setText((day + "/" + (month+1) +"/"+ year ));
                            }
                        }, year ,month,dayofmonth);

                        DateDialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.right, menu);
        return true;
    }
}