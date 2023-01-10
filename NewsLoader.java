package com.example.newsapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import androidx.loader.content.AsyncTaskLoader;

import java.util.ArrayList;

public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {
    private String murl;
    public NewsLoader(@NonNull Context context,String url) {

        super(context);
        murl=url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public ArrayList<News> loadInBackground() {
        if(murl==null)
        {
        return null;
    }
        ArrayList<News> news=QueryUtils.fetchdatafromurl(murl);
        return news;
}}
