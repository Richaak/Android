package com.example.assignment11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

   TextView tt1;
   TextView tt2;
   Button b1;
    EditText Edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tt1=findViewById(R.id.t1);
        tt2=findViewById(R.id.t2);
        //b1.findViewById(R.id.submit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
       /* Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        Edittext.setText(str);*/
        String v;
        String v2;
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            v=bundle.getString("name");
            v2=bundle.getString("gender");
            tt1.setText(v);
            tt2.setText(v2);
        }


       /* b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = Edittext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", str);
                startActivity(intent);
            }
        });*/
    }
}