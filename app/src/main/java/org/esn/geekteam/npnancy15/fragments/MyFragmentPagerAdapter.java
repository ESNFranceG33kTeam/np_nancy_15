package org.esn.geekteam.npnancy15.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    int count;
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        count = 5;
    }

    @Override
    public Fragment getItem(int position) {
        OCFragment ocFragment = new OCFragment();
        ScheduleFragment scheduleFragment = new ScheduleFragment();

        switch (position) {
            case 0: return ocFragment;
            case 1: return scheduleFragment;
            case 2: return ocFragment;
            case 3: return ocFragment;
            case 4: return ocFragment;
            default: return ocFragment;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
