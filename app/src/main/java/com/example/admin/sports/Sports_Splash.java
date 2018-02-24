package com.example.admin.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

public class Sports_Splash extends AppCompatActivity {

    long Delay = 4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__splash);
        getSupportActionBar().hide();
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearlayout);
        ll.setAlpha((float) 0.6);
        Timer Runsplash = new Timer();
        TimerTask Showsplash = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(Sports_Splash.this, Sports_Login.class);
                startActivity(intent);
            }
        };
        Runsplash.schedule(Showsplash, Delay);
    }
}
