package com.example.newsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0,news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview=convertView;
        if(listview==null){
            listview= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

            }
        News getnews=getItem(position);
        TextView txt1=(TextView) listview.findViewById(R.id.title);
        TextView txt2=(TextView) listview.findViewById(R.id.author);
        TextView txt3=(TextView) listview.findViewById(R.id.newstype);
        TextView txt4=(TextView) listview.findViewById(R.id.date);
        ImageView bmp1=(ImageView) listview.findViewById(R.id.image);
        txt1.setText(getnews.getTitle());
        txt2.setText(getnews.gettype());
        txt3.setText(getnews.getNewsform());
        txt4.setText(getnews.getDate());
        bmp1.setImageBitmap(getnews.getBmp());
        return listview;
    }
}
