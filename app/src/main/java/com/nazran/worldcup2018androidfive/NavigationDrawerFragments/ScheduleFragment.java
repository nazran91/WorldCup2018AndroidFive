package com.nazran.worldcup2018androidfive.NavigationDrawerFragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nazran.worldcup2018androidfive.Adapters.MatchesFragmentPagerAdapter;
import com.nazran.worldcup2018androidfive.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drawer_matches, container, false);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);

        MatchesFragmentPagerAdapter matchesFragmentPagerAdapter
                = new MatchesFragmentPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(matchesFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
