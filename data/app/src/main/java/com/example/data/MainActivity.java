package com.example.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.data.R;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText Edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        Edittext = (EditText) findViewById(R.id.editText1);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        Edittext.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str = Edittext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                intent.putExtra("message_key", str);
                startActivity(intent);
            }
        });
    }
}