package com.example.a1818_isa2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class edit extends AppCompatActivity {
Button editt;
EditText e1;
nicknamee nicknamee;
ArrayList<String> nicknames;
String currnick;
    @Override

    //edit the nick name
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        editt=(Button)findViewById(R.id.submit);
        e1=(EditText)findViewById(R.id.edittext);

        Bundle bundle =getIntent().getExtras();
        if(bundle!=null){
            currnick = bundle.getString("nickname");
        }
        e1.setText(currnick);

        editt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nm = e1.getText().toString();
                nicknamee = new nicknamee();
                nicknames = nicknamee.getNicknames();
                for(int i=0;i<nicknames.size();i++){
                    if(nicknames.get(i).equals(currnick)){
                        nicknames.set(i,nm);
                    }
                }
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("nick",nm);
                startActivity(intent);

            }
        });


    }
}