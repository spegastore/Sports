package com.example.admin.sports;

/**
 * Created by Admin on 2/19/2018.
 */

public class Dataclass_Video {
    String title;
    String video_link;
    String desc;
    String date;

    public Dataclass_Video(String title, String video_link) {
        this.title = title;
        this.video_link = video_link;
    }

    public Dataclass_Video(String title, String video_link, String desc, String date) {
        this.title = title;
        this.video_link = video_link;
        this.desc = desc;
        this.date = date;
    }

    public Dataclass_Video() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo_link() {
        return video_link;
    }

    public void setVideo_link(String video_link) {
        this.video_link = video_link;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
