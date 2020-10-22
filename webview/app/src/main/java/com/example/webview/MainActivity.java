package com.example.webview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView web;
    private Toolbar toolbar;
    private Context context;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Webview");



        web = (WebView) findViewById(R.id.webvieww);
          web.setWebViewClient((new WebViewClient()));
        web.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setGeolocationEnabled(true);
         web.loadUrl("https://www.youtube.com/watch?v=3olM-9vcd4M");




        //web.getSettings().setJavaScriptEnabled(true);
        //web.getSettings().setGeolocationEnabled(true);
       // web.loadUrl("file:///android_asset/myprofile.html");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null)
        {
            web.setWebViewClient((new WebViewClient()));
            web.getSettings().setJavaScriptEnabled(true);
            web.getSettings().setGeolocationEnabled(true);
            web.loadUrl("https://www.youtube.com/watch?v=3olM-9vcd4M");
        } else
            {
                web.getSettings().setJavaScriptEnabled(true);
                web.getSettings().setGeolocationEnabled(true);
            web.loadUrl("file:///android_asset/myprofile.html");
        }
        return super.onOptionsItemSelected(item);
    }
}
