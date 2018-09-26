package com.example.android.thebayelsatoureguideapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager mainView = (ViewPager) findViewById(R.id.main_view);

        CustomViewPagerAdapter adapt = new CustomViewPagerAdapter(this,getSupportFragmentManager());

        mainView.setAdapter(adapt);

        TabLayout tab = (TabLayout) findViewById(R.id.tabs);
        tab.setupWithViewPager(mainView);
    }
}