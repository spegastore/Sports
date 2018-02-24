package com.example.admin.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Sports_News_Desc extends AppCompatActivity {

    ImageView icon;
    TextView tv,description;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__news__desc);
        icon=(ImageView)findViewById(R.id.imageView_icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Sports_News_Desc.this, Sports_Menu.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().hide();

        tv=(TextView)findViewById(R.id.textView_head);
        description=(TextView)findViewById(R.id.textView_desc);
        iv=(ImageView)findViewById(R.id.imageView_news);
        Bundle extras= getIntent().getExtras();
        String title=extras.getString("title");
        String thumb=extras.getString("thumbnail");
        String desc=extras.getString("desc");
        tv.setText(title);
        Picasso.with(this).load("http://www.spegasports.com/admin/uploads/"+thumb).error(R.drawable.loading).placeholder(R.drawable.loading).into(iv);
        description.setText(desc);
    }
}
