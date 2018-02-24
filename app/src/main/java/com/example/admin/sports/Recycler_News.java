package com.example.admin.sports;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Admin on 2/19/2018.
 */

public class Recycler_News extends RecyclerView.Adapter<Recycler_News.Newsdata> {
    List<Dataclass_News> dataclassNewsList;
    Context context;

    public Recycler_News(Context context) {
        this.context = context;
    }

    public Recycler_News(Context context, List<Dataclass_News> dataclassNewsList) {
        this.context = context;
        this.dataclassNewsList = dataclassNewsList;

    }


    @Override
    public int getItemCount() {
        return dataclassNewsList.size();
    }

   // @Override
    public Object getItem(int location) {
        return dataclassNewsList.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public Recycler_News.Newsdata onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_cardview, parent, false);
        Newsdata newsdata = new Newsdata(view);
        return newsdata;
    }

    @Override
    public void onBindViewHolder(Recycler_News.Newsdata holder, final int position) {

        final Dataclass_News list = dataclassNewsList.get(position);
        holder.head.setText(list.getTitle());
        if (!TextUtils.isEmpty(list.getImage())) {
            Picasso.with(context).load("http://www.spegasports.com/admin/uploads/" + list.getImage())
                    .error(R.drawable.loading)
                    .placeholder(R.drawable.loading)
                    .into(holder.img);

        }
        holder.date.setText(list.getDate());
        if (position % 2 == 0) {

            holder.cv.setBackgroundColor(ContextCompat.getColor(context, R.color.list_odd_color));

        } else {
            holder.cv.setBackgroundColor(ContextCompat.getColor(context, R.color.list_even_color));

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Sports_News_Desc.class);
                intent.putExtra("title", list.getTitle());
                intent.putExtra("thumbnail", list.getImage());
                intent.putExtra("desc", list.getDesc());
                v.getContext().startActivity(intent);
            }
        });
    }



    public class Newsdata extends RecyclerView.ViewHolder {
        CardView cv;
        TextView head, play, date;
        ImageView img;

        public Newsdata(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.news_cardview);
            head = (TextView) itemView.findViewById(R.id.textView_heading_news);
            date = (TextView) itemView.findViewById(R.id.textView_heading_newsdate);
            play = (TextView) itemView.findViewById(R.id.textView_read);
            img = (ImageView) itemView.findViewById(R.id.imageView_news);
        }
    }
}
