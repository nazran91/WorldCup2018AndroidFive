package com.nazran.worldcup2018androidfive.ScheduleFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nazran.worldcup2018androidfive.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchesFragment extends Fragment {


    public MatchesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matches, container, false);


        return view;
    }

}
