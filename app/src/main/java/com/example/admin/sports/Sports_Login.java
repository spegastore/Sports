package com.example.admin.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Sports_Login extends AppCompatActivity {

    ImageButton news,video;
    int pid=android.os.Process.myPid();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__login);
        getSupportActionBar().hide();
        news=(ImageButton)findViewById(R.id.imageButton_news);
        video=(ImageButton)findViewById(R.id.imageButton_video);
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Sports_Login.this, Sports_News.class);
                startActivity(intent);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(Sports_Login.this, Sports_Video.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(2);
    }
}
