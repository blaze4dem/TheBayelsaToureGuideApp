package com.example.android.thebayelsatoureguideapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CustomViewPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CustomViewPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 0){
            return new CoolSpotsfragment();
        }else if(i == 1){
            return new ResturantsFragment();
        }else if (i == 2){
            return new HotelsFragment();
        }else{
            return new EmagencyFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.cool);
        }else if (position == 1){
            return mContext.getString(R.string.rest);
        }else if (position == 2){
            return mContext.getString(R.string.hotels);
        }else{
            return mContext.getString(R.string.emergency);
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
