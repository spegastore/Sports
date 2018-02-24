package com.example.admin.sports;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.List;

/**
 * Created by Admin on 2/19/2018.
 */

public class Recycler_Youtube extends RecyclerView.Adapter<Recycler_Youtube.ViewData_youtube> {
    Integer i;
    List<Dataclass_Video> datas;
    Context context;

    public Recycler_Youtube(Context context) {
        this.context = context;
    }

    public Recycler_Youtube(Context context, List<Dataclass_Video> datas) {
        this.datas = datas;
        this.context = context;

    }

    @Override
    public ViewData_youtube onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_cardview, parent, false);
        ViewData_youtube viewdata = new ViewData_youtube(view);
        return viewdata;
    }

    @Override
    public void onBindViewHolder(final ViewData_youtube holder, final int position) {
        final Dataclass_Video list = datas.get(position);
        holder.head.setText(list.getTitle());
        final YouTubeThumbnailLoader.OnThumbnailLoadedListener onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {


            @Override
            public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

            }

            @Override
            public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                youTubeThumbnailView.setVisibility(View.VISIBLE);
            }
        };

        holder.youTubeThumbnailView.initialize("AIzaSyAQJ2sa2VNb7cs159DQYzcqIFfsv-6Lf_k", new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(list.getVideo_link());
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                //write something for failure
            }
        });
        if (position % 2 == 0) {

            holder.cv.setBackgroundColor(ContextCompat.getColor(context, R.color.list_odd_color));

        } else {
            holder.cv.setBackgroundColor(ContextCompat.getColor(context, R.color.list_even_color));

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(v.getContext(),Sports_Video_Desc.class);
                intent.putExtra("title", datas.get(position).getTitle());
                intent.putExtra("video",datas.get(position).getVideo_link());
                intent.putExtra("desc",datas.get(position).getDesc());
                intent.putExtra("cdate",datas.get(position).getDate());
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }


    public class ViewData_youtube extends RecyclerView.ViewHolder {

        CardView cv;
        TextView head, play;
        protected RelativeLayout relativeLayoutOverYouTubeThumbnailView;
        YouTubeThumbnailView youTubeThumbnailView;
        protected ImageView playButton;


        public ViewData_youtube(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.video_cardview);
            head = (TextView) itemView.findViewById(R.id.textView_heading);
            play = (TextView) itemView.findViewById(R.id.textView_play);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);

        }


    }
}
