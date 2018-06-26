package com.aiub.worldcup2018androidfive.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.aiub.worldcup2018androidfive.MatchesFragments.MatchesFragment;
import com.aiub.worldcup2018androidfive.MatchesFragments.ScheduleFragment;
import com.aiub.worldcup2018androidfive.MatchesFragments.TablesFragment;

public class MatchesFragmentPagerAdapter extends FragmentPagerAdapter {


    public MatchesFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ScheduleFragment();
            case 1:
                return new MatchesFragment();
            case 2:
                return new TablesFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Schedules";
            case 1:
                return "Matches";
            case 2:
                return "TAbles";
        }
        return super.getPageTitle(position);
    }
}
