package com.example.newsapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class QueryUtils {
    public static final  String LOG_TAG=QueryUtils.class.getName();
    public  static ArrayList<News> fetchdatafromurl(String url)
    {

        URL url1=createURL(url);
        String jsonResponse="";
        if(url==null) {
            return null;
        }
        try
        {
            jsonResponse=makeHttpRequest(url1);
        }
        catch (IOException e)
        {
            Log.e(LOG_TAG,"Problem in http problem in 1st function");

        }
        ArrayList<News> news=extractfeaturesfromjson(jsonResponse);
        return news;

    }
    private static URL createURL(String url)
    {
        URL newurl=null;
        if(url==null)
        {
            return null;
        }
        try
        {
            newurl=new URL(url);

        }
        catch (MalformedURLException e)
        {
            Log.e(LOG_TAG,"Issues in creating the URL");
        }
        return newurl;
    }
    private static String makeHttpRequest(URL url) throws IOException {
String jsonResponse="";
if(url==null)
{
    return jsonResponse;
}
        HttpURLConnection urlConnection=null;
        InputStream inputStream=null;
        try
        {
            urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if(urlConnection.getResponseCode()==200)
            {
                inputStream=urlConnection.getInputStream();
                jsonResponse=readfronStream(inputStream);
            }
            else
            {
                Log.e(LOG_TAG,"ResponseCode error :"+urlConnection.getResponseCode());
            }
        }
        catch (IOException E)
        {
            Log.e(LOG_TAG,"Error in make http function");
        }
        finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
return jsonResponse;
    }
    private static String readfronStream(InputStream inputStream) throws IOException
    {
        StringBuilder output=new StringBuilder();
        if(inputStream!=null)
        {
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader reader=new BufferedReader(inputStreamReader);
            String line=reader.readLine();
            while(line!=null)
            {
                output.append(line);
                line=reader.readLine();
            }

        }
        return output.toString();
    }
    public static ArrayList<News> extractfeaturesfromjson(String url)
    {
        ArrayList<News> news=new ArrayList<>();
        try
        {
            JSONObject rootobj=new JSONObject(url);
            JSONObject responseonj=rootobj.getJSONObject("response");
            JSONArray results=responseonj.getJSONArray("results");
            for (int i=0;i<results.length();i++)
            {
JSONObject currentnews=results.getJSONObject(i);
String title=currentnews.getString("webTitle");
String type=currentnews.getString("type");
String Datemain=currentnews.getString("webPublicationDate");
String newsform=currentnews.getString("sectionName");
String urlstring=currentnews.getString("webUrl");
JSONObject thumb=currentnews.getJSONObject("fields");
String img=thumb.getString("thumbnail");
URL urlimg=new URL(img);

                Bitmap bmp=BitmapFactory.decodeStream(urlimg.openConnection().getInputStream());
String[] dateo=Datemain.split("T");
news.add(new News(title,type,newsform,dateo[0],bmp,urlstring));
            }
        }
        catch (JSONException | IOException E)
        {
            Log.e(LOG_TAG,"Error in JSON parsing ");
        }
        return news;
    }
}
