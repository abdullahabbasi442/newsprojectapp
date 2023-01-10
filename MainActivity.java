package com.example.newsapp;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {


    private static final String LOG_TAG=MainActivity.class.getName();
    private ViewPager2 viewPager2;
    private FragmentStateAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2=findViewById(R.id.pager);
        adapter=new ScreenSlideAdapter(this);
        viewPager2.setAdapter(adapter);
        TabLayout tabLayout=findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0)
                {
tab.setText("TODAY NEWS");
            }

            }
        }).attach();

    }
}