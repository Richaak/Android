package com.example.calculatorassign;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Float.*;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonclear,buttondiv, buttonadd,buttonsub,buttonmult,buttonans,buttondot;
    TextView TV;
    float val1,val2;
    boolean add = true;
    boolean sub=true;
    boolean mult=true;
    boolean div=true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.b1);
        button2=(Button)findViewById(R.id.b2);
        button3=(Button)findViewById(R.id.b3);
        button4=(Button)findViewById(R.id.b4);
        button5=(Button)findViewById(R.id.b5);
        button6=(Button)findViewById(R.id.b6);
        button7=(Button)findViewById(R.id.b7);
        button8=(Button)findViewById(R.id.b8);
        button9=(Button)findViewById(R.id.b9);
        button0=(Button)findViewById(R.id.b0);
        buttonans=(Button)findViewById(R.id.bans);
        buttonadd=(Button)findViewById(R.id.badd);
        buttondot=(Button)findViewById(R.id.bdot);
        buttonsub=(Button)findViewById(R.id.bsub);
        buttonmult=(Button)findViewById(R.id.bmult);
        buttondiv=(Button)findViewById(R.id.bdiv);
        buttonclear=(Button)findViewById(R.id.bclear);
        TV=(TextView)findViewById(R.id.tv);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+"0");
            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if (TV==null)
                {
                    TV.setText("");
                }
                else
                    {

                        val1 = Float.parseFloat(TV.getText() + "");
                        add = true;
                        TV.setText(null);
                }

        }});



        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TV==null) {
                    TV.setText("");
                }
                else
                {

                    val1 = Float.parseFloat(TV.getText() + "");
                    sub = true;
                    TV.setText(null);
                }

            }});


        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TV==null) {
                    TV.setText("");
                }
                else
                {

                    val1 = Float.parseFloat(TV.getText() + "");
                    div = true;
                    TV.setText(null);
                }

            }});

        buttonmult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TV!=null){


                    val1 = Float.parseFloat(TV.getText() + "");
                    mult = true;
                    TV.setText(null);
                }
                else
                    {
                    TV.setText("");

                }

            }});

        buttondot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText(TV.getText()+".");
            }
        });

        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV.setText("");
            }
        });

buttonans.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        val2 = Float.parseFloat(TV.getText() + "");

        if (add == true) {
            TV.setText(val1 + val2 + "");
            add = false;
        }

        if (sub == true)
        {
            TV.setText(val1 - val2 + "");
            sub = false;
        }
        if (div == true)
        {
            TV.setText(val1 / val2 + "");
            div = false;
        }

        if (mult == true)
        {
            TV.setText(val1 * val2 + "");
            mult = false;
        }
    }
});

    }
}