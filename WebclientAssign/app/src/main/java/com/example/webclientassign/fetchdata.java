package com.example.webclientassign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class fetchdata extends AsyncTask<Void,Void,Void> {
String wholedata="";
String dataParsed="";
String singleparsed="";
String dataa="";

@SuppressLint("StaticFieldLeak")
Context context;
MainActivity main;
static Integer Salary;

    public fetchdata(Context context1)
    {

        context=context1;
    }

    //Async method
    @Override
    protected Void doInBackground(Void... voids)
    {    //background thread
        try {
            URL url=new URL("https://api.jsonbin.io/b/5f98044c30aaa01ce619982d");
            HttpURLConnection Httpconn= (HttpURLConnection) url.openConnection();
            InputStream inputStream=Httpconn.getInputStream();
            BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream));
            String data="";
            while(data!=null){
                data=bf.readLine();
                wholedata=wholedata+data;

            }
            Salary=0;
            JSONArray J=new JSONArray(wholedata);

            JSONArray sorteddata = new JSONArray();
            sorteddata = sortData(J);
            for(int i=0;i<sorteddata.length();i++)
            {

                JSONObject jo= (JSONObject) sorteddata.get(i);

                singleparsed="     Id= "+jo.get("empCode")+"\n"+
                        "     "+jo.get("firstName")+"\n"+
                        "     "+jo.get("lastName")+"\n"+
                        "     Salary= "+jo.get("salary")+"\n";
                Salary += jo.getInt("salary");
                dataParsed=dataParsed+singleparsed+"\n";



            }





        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;

    }

    private JSONArray sortData(JSONArray posts) throws JSONException {

        List<JSONObject> jsonValues = new ArrayList<JSONObject>();
        JSONArray sorteddata = new JSONArray();

        for (int i = 0; i < posts.length(); i++)



        {
            jsonValues.add(posts.getJSONObject(i));
        }




        Collections.sort( jsonValues, new Comparator<JSONObject>() {
            private static final String KEY_NAME = "lastName";

            @Override
            public int compare(JSONObject a, JSONObject b) {
                String value1 = new String();
                String value2 = new String();

                try {
                    value1 = (String) a.get(KEY_NAME);
                    value2 = (String) b.get(KEY_NAME);
                }
                catch (JSONException e) {
                }

                return value1.compareTo(value2);
            }
        });

        for (int i = 0; i < posts.length(); i++) {
            sorteddata.put(jsonValues.get(i));
        }
        return sorteddata;
    }




    @Override
    protected void onPostExecute(Void aVoid) {  //UI thread
        super.onPostExecute(aVoid);
        MainActivity.t1.setText(this.dataParsed);
MainActivity.b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(context,"Total salary is "+Salary,Toast.LENGTH_SHORT).show();
    }
});



    }

}
