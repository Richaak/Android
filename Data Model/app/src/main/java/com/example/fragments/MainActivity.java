package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
ViewPager VP;
String name;
String number;
String email;
String pass;
String confirmpass;
String state;
String calende;
//private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VP = (ViewPager)findViewById(R.id.vp);
     //   button=(Button)findViewById(R.id.info);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentPagerAdapter Fpa = new MyPagerAdapter(fragmentManager);
        VP.setAdapter(Fpa);

        profile profile=new profile();
        name=profile.getName();
        number=profile.getNumber();
        email=profile.getEmail();
pass=profile.getPass();
confirmpass=profile.getConfirmpass();
state=profile.getState();

    }



    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        @Override
        public Fragment getItem(int position) {
            if (position == 0) {

                return page1.newInstance(name, number, email, pass, confirmpass);
            } else if (position == 1) {
                return page2.newInstance(state);
            }
            return null;
        }


        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return "Page 1";
            } else if (position == 1) {
                return "Page 2";
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
