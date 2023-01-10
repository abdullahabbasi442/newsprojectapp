package com.example.newsapp;

import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ScreenSlideAdapter extends FragmentStateAdapter
{
    public ScreenSlideAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==0){
            return new Fragment1();
    }
        else
        {
            return new Fragment1();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
