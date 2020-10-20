package com.example.chatapplication;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyc;
    private RecyclerView.Adapter resadapter;
    private RecyclerView.LayoutManager layoutManager;
    Message message;
    ArrayList<Layoutt> layout;
    EditText type;Button send;
    String name;Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bundle = getIntent().getExtras();
        name = bundle.getString("name");
        layout = new ArrayList<>();
        message = new Message();
        Message.setCurrname(name);
        setMessage();
        type = findViewById(R.id.edittext); // id of edittext to type message by jerry and tom
        send = findViewById(R.id.send);  //button to send message
        send.setOnClickListener(this);







    }

    private void setMessage() {
        ArrayList<String> msg;
        ArrayList<String> m;
        msg = Message.getMsgs();
        m = Message.getName();
        layout.clear();
        for(int i=0;i<msg.size();i++){
            layout.add(new Layoutt(m.get(i),msg.get(i)));
        }
        recyc = findViewById(R.id.recycler);
        recyc.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        resadapter = new AdapterLayout(layout);
        recyc.setLayoutManager(layoutManager);
        recyc.setAdapter(resadapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.send){
            Message.setMsgs(type.getText().toString());
            Message.setName(name);
            setMessage();
            type.setText("");
        }
    }
}