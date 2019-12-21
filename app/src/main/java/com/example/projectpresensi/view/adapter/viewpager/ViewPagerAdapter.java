package com.example.projectpresensi.view.adapter.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectpresensi.view.fragment.HomeFragment;
import com.example.projectpresensi.view.fragment.PresenceFragment;
import com.example.projectpresensi.view.fragment.ProfileFragment;
import com.example.projectpresensi.view.fragment.ScheduleFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                return new ScheduleFragment();
            case 2:
                return new PresenceFragment();
            case 3:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


}
