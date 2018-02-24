package com.example.admin.sports;

/**
 * Created by Admin on 2/19/2018.
 */

public class Dataclass_News {
    String title;
    String image;
    String desc;
    String date;

    public Dataclass_News(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public Dataclass_News(String title, String image, String desc,String date) {

        this.title = title;
        this.image = image;
        this.desc = desc;
        this.date = date;
    }

    public Dataclass_News() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
