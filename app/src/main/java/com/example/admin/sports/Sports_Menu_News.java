package com.example.admin.sports;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Sports_Menu_News extends AppCompatActivity {

    RecyclerView recyclerView_menu;
    List<Dataclass_News> datanews;
    ImageView icon;
    ProgressBar bar;
    private static final String TAG = Sports_Menu_News.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__menu__news);
        getSupportActionBar().hide();
        bar = (ProgressBar) this.findViewById(R.id.progressBar);
        icon = (ImageView) findViewById(R.id.imageView_icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sports_Menu_News.this, Sports_Menu.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        recyclerView_menu = (RecyclerView) findViewById(R.id.menu_news_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView_menu.setLayoutManager(llm);
        recyclerView_menu.setHasFixedSize(true);
        Bundle extras=getIntent().getExtras();
        String api=extras.getString("api_key");
        new Generate().execute(api);

    }
    @Override
    public void onBackPressed() {
        Intent homeintent=new Intent(Sports_Menu_News.this, Sports_Login.class);
        homeintent.addCategory(Intent.CATEGORY_HOME);
        homeintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeintent);
    }

    private class Generate extends AsyncTask<String, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar.setVisibility(View.VISIBLE);
            /*Toast.makeText(getApplicationContext(),"Data Loading",Toast.LENGTH_LONG).show();*/
        }

        @Override
        protected Integer doInBackground(String... params) {
            Integer result=0;
            try {
                URL linkdata=new URL(params[0]);
                HttpURLConnection urlConnection=(HttpURLConnection)linkdata.openConnection();
                int Statuscode=urlConnection.getResponseCode();
                if(Statuscode==200) {

                    BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        builder.append(line);

                    }
                    parseResult(builder.toString());
                    result = 1;
                }
                else
                {
                    result=0;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }

        @Override
        protected void onPostExecute(Integer result) {
            super.onPostExecute(result);
            bar.setVisibility(View.GONE);

            if(result==1)
            {
                Recycler_News adapter=new Recycler_News(Sports_Menu_News.this,datanews);
                recyclerView_menu.setAdapter(adapter);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Poor Internet Connection",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void parseResult(String result) {
        datanews=new ArrayList<>();
        try {
            JSONObject response=new JSONObject(result);
            JSONArray array=response.getJSONArray("result");
            for(int i=0;i<array.length();i++)
            {
                JSONObject datalist=array.getJSONObject(i);
                Dataclass_News news=new Dataclass_News();
                news.setTitle(datalist.getString("post_head"));
                news.setImage(datalist.getString("image"));
                news.setDesc(datalist.getString("description"));
                news.setDate(datalist.getString("datetime"));
                datanews.add(news);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
