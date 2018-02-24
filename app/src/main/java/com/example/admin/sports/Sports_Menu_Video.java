package com.example.admin.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class Sports_Menu_Video extends AppCompatActivity {

    ImageView icon;
    TextView cricket,football,hockey,basketball,tennis,golf,shooting,volleyball,skiing,rugby,badminton,fencing,fomula_one,table_tennis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__menu__video);
        getSupportActionBar().hide();

     /*   DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        getWindow().setLayout((int)(width), (int)(height*.8));*/

        WindowManager.LayoutParams params=getWindow().getAttributes();
        params.x=5;
        params.height=950;
        params.width=1000;
        params.y=-10;
        this.getWindow().setAttributes(params);

        getWindow().addFlags( WindowManager.LayoutParams.ALPHA_CHANGED);


        icon=(ImageView)findViewById(R.id.imageView_close);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cricket=(TextView)findViewById(R.id.textView_cricket);
        football=(TextView)findViewById(R.id.textView_football);
        hockey=(TextView)findViewById(R.id.textView_hockey);
        basketball=(TextView)findViewById(R.id.textView_basketball);
        tennis=(TextView)findViewById(R.id.textView_tennis);
        golf=(TextView)findViewById(R.id.textView_golf);
        shooting=(TextView)findViewById(R.id.textView_shooting);
        volleyball=(TextView)findViewById(R.id.textView_volleyball);
        skiing=(TextView)findViewById(R.id.textView_skiing);
        rugby=(TextView)findViewById(R.id.textView_rugby);
        badminton=(TextView)findViewById(R.id.textView_badminton);
        fencing=(TextView)findViewById(R.id.textView_fencing);
        fomula_one=(TextView)findViewById(R.id.textView_formula_one);
        table_tennis=(TextView)findViewById(R.id.textView_table_tennis);

        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=1&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });

        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=2&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        hockey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=3&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        basketball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=4&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=5&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        golf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=6&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        shooting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=7&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        volleyball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=8&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        skiing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=9&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        rugby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=10&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        badminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=11&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        fencing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=12&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        fomula_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=13&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
        table_tennis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.spegasports.com/admin/cat_data.php?pid=14&offset=0";
                Intent intent=new Intent(Sports_Menu_Video.this,Sports_Menu_Videodata.class);
                intent.putExtra("api_key",url);
                startActivity(intent);
            }
        });
    }
    }

