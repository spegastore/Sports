package com.example.admin.sports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import pl.droidsonroids.gif.GifImageView;

public class Sports_Video_Desc extends AppCompatActivity implements YouTubePlayer.OnInitializedListener  {
    public  static final String Api_Key="AIzaSyAQJ2sa2VNb7cs159DQYzcqIFfsv-6Lf_k";
    ImageView icon;
    GifImageView download;
    TextView tv, desc, cdate;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports__video__desc);
        icon = (ImageView) findViewById(R.id.imageView_icon);
        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sports_Video_Desc.this, Sports_Menu_Video.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().hide();
        YouTubePlayerSupportFragment youTubePlayerView = (YouTubePlayerSupportFragment)getSupportFragmentManager().findFragmentById(R.id.youtube_player);
        youTubePlayerView.initialize(Api_Key, this);
      //  download = (GifImageView) findViewById(R.id.download);
        tv = (TextView) findViewById(R.id.textView_video);
        desc = (TextView) findViewById(R.id.textView_desc_video);
        cdate = (TextView) findViewById(R.id.textView_desc_date);

        Bundle extras = getIntent().getExtras();
        String title = extras.getString("title");
        String description = extras.getString("desc");
        url = extras.getString("video");
        String date = extras.getString("cdate");
        tv.setText(title);
        desc.setText(description);
        cdate.setText(date);
/*

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Sports_Video_Desc.this, Sports_Videodownload.class);
                intent.putExtra("link", url);
                startActivity(intent);



            }
        });
*/

    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        if(!wasRestored)
        {
            youTubePlayer.cueVideo(url);
              /*  youTubePlayer.loadVideo(url);*/
        }
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener=new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"Failured ti Initialize!",Toast.LENGTH_LONG).show();
    }
}
