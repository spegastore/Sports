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

public class Sports_Video extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView icon;
    List<Dataclass_Video> datas;
    ProgressBar bar;

    private static final String TAG=Sports_Video.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__video);
        getSupportActionBar().hide();
        icon=(ImageView)findViewById(R.id.imageView_icon);
        bar = (ProgressBar) this.findViewById(R.id.progressBar);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Sports_Video.this, Sports_Menu_Video.class);
                startActivity(intent);
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.video_recycler);
        LinearLayoutManager llm=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        String url="http://www.spegasports.com/admin/get_alldata.php";
        new Generate().execute(url);
    }
    private class Generate extends AsyncTask<String,Void,Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            bar.setVisibility(View.VISIBLE);
          /*  Toast.makeText(getApplicationContext(),"Data Loading",Toast.LENGTH_LONG).show();*/
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
                Recycler_Youtube adapter=new Recycler_Youtube(Sports_Video.this,datas);
                recyclerView.setAdapter(adapter);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"ERROR Occured during parsing",Toast.LENGTH_LONG).show();
            }
        }
    }

    public void parseResult(String result) {
        datas=new ArrayList<>();
        try {
            JSONObject response=new JSONObject(result);
            JSONArray array=response.getJSONArray("result");
            for(int i=0;i<array.length();i++)
            {
                JSONObject datalist=array.getJSONObject(i);
                Dataclass_Video dc=new Dataclass_Video();
                dc.setTitle(datalist.getString("post_head"));
                dc.setVideo_link(datalist.getString("link"));
                dc.setDesc(datalist.getString("description"));
                dc.setDate(datalist.getString("cdate"));
                datas.add(dc);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
