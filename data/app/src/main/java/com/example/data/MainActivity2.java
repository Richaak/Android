package com.example.data;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.data.R;
import com.example.data.MainActivity3;

public class MainActivity2 extends AppCompatActivity {
Button button;
    EditText edittext2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = (Button)findViewById(R.id.button2);
        edittext2 = (EditText)findViewById(R.id.editText2);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message_key");
        edittext2.setText(str);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String str = edittext2.getText().toString();
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("message_key", str);
                startActivity(intent);
            }
        });
    }
}