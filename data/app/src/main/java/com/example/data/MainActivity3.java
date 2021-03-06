package com.example.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.data.R;

public class MainActivity3 extends AppCompatActivity {
    Button button;
    EditText edittext3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = (Button) findViewById(R.id.button3);
        edittext3 = (EditText) findViewById(R.id.editText3);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        edittext3.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str = edittext3.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("message_key", str);
                startActivity(intent);
            }
        });
    }
}