package com.example.newsapp;

import android.graphics.Bitmap;

import java.net.URL;

public class News {
     private String key="b622a182-490c-44c1-8104-8b017ce65ef8";
     private String title;
     private String type;
     private String date;
     private String newsform;
     private Bitmap bmp;
     private String url;
     public News(String title,String type,String date,String newsform,Bitmap bmp,String url)
     {
         this.title=title;
         this.type=type;
         this.date=date;
         this.newsform=newsform;
         this.bmp=bmp;
         this.url=url;
     }
     public String getTitle()
     {
         return title;
     }
    public String gettype()
    {
        return type;
    }
    public String getDate()
    {
        return date;
    }
    public String getNewsform()
    {
        return newsform;
    }
    public Bitmap getBmp()
    {
        return bmp;
    }
    public String getUrl(){ return url;}
}
