package com.example.admin.sports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Sports_Videodownload extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__videodownload);

        webView = (WebView) findViewById(R.id.videoView_download);
        getSupportActionBar().hide();
        Bundle extras = getIntent().getExtras();
        String link = extras.getString("link");

    }
}
