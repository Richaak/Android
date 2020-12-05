package com.example.a1818_isa2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;


public class MainActivity extends AppCompatActivity {
TextView t1;
    private RecyclerView mrecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<exampleitem> example_item;
    String fetch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        example_item = new ArrayList<>();
        //given url
        fetch = "https://www.breakingbadapi.com/api/characters?limit=10";
        //class nicknamee to edit the nickname text
        nicknamee nicknamee = new nicknamee();
//        if(nicknamee.getNicknames()==null){
//
//        }
        post postsManager = new post(this);
        postsManager.execute(fetch);
    }


//asynctask

        @SuppressLint("StaticFieldLeak")
        class post extends AsyncTask<String,Void,String> {
            Context con;
            JSONArray posts;
            public post(Context con) {


//set context
                this.con=con;
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected String doInBackground(String... params) {
                String post_url=params[0];

                try{
                    URL url=new URL(post_url);
                    HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setDoInput(true);
                    InputStream inputStream=httpURLConnection.getInputStream();
                    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
                    String l;
                    StringBuffer stringBuffer =new StringBuffer("");
                    while ((l = bufferedReader.readLine()) != null) {
                        stringBuffer.append(l);
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuffer.toString();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String string)
            {
                try {
                    posts = new JSONArray(string);
                    content(posts);

                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }




            public void content(JSONArray posts) throws JSONException {
                ArrayList<exampleitem> ex = new ArrayList<>();
                nicknamee nickkk=new nicknamee();
                ArrayList<String> nicknames=new ArrayList<>();

                if(posts.length()==0){

                 //  Log.e("hi","hii"+posts.length());

                }
                JSONArray jasonarray = new JSONArray();
                jasonarray = JsonData(posts);

                nicknamee nicknamee = new nicknamee();


            //    Bundle bundle=getIntent().getExtras();

                if(nicknamee.getNicknames()==null||nicknamee.getNicknames().size()==0){


                    for(int i = 0;i<jasonarray.length();i++){
                        JSONObject post = jasonarray.getJSONObject(i);
                        ex.add(new exampleitem(post.getString("name"),post.getString("nickname"),
                                post.getString("appearance"),post.getString("portrayed"),
                                post.getString("img")));
                        nicknames.add(post.getString("nickname"));

                    }

                }else {

                    for(int i = 0;i<jasonarray.length();i++){
                        JSONObject post = jasonarray.getJSONObject(i);
                        // display name, nickname, appearance, portrayed, img
                        ex.add(new exampleitem(post.getString("name"),post.getString("nickname"),
                                post.getString("appearance"),post.getString("portrayed"),
                                post.getString("img")));
                        nicknames.add(nicknamee.getNicknames().get(i));


                    }
                }




                // recycler,layroutmanager,adapter
                mrecycler=(RecyclerView)findViewById(R.id.recycler);
                mrecycler.setHasFixedSize(true);
                layoutManager=new LinearLayoutManager(con);
                mAdapter=new ExampleAdapter(ex,con);
                mrecycler.setLayoutManager(layoutManager);
                mrecycler.setAdapter(mAdapter);
            }





            private JSONArray JsonData(JSONArray posts) throws JSONException {

                List<JSONObject> jsonValues = new ArrayList<>();
                JSONArray dataa = new JSONArray();

                for (int i = 0; i < posts.length(); i++) {
                    jsonValues.add(posts.getJSONObject(i));
                }


                for (int i = 0; i < posts.length(); i++) {
                    dataa.put(jsonValues.get(i));
                }
                return dataa;
            }
        }
    }
