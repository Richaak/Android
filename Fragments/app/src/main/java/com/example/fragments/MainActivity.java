package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
ViewPager VP;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VP = (ViewPager)findViewById(R.id.vp);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter Fpa = new MyPagerAdapter(fragmentManager);
        VP.setAdapter(Fpa);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter
    {
        public MyPagerAdapter(FragmentManager fragmentManager)
        {
            super(fragmentManager);
        }






        @Override
        public Fragment getItem(int position)
        {
            if(position==0)
            {
                return page1.newInstance();
            }
            else if(position==1)
            {
                return page2.newInstance();
            }
            return null;
        }



        @Override
        public int getCount()
        {
            return 2;
        }
    }
}
