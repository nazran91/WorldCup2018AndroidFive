package com.nazran.worldcup2018androidfive.ScheduleFragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nazran.worldcup2018androidfive.Adapters.GroupListAdapter;
import com.nazran.worldcup2018androidfive.ModelClasses.Team;
import com.nazran.worldcup2018androidfive.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<List<Team>> groupList = new ArrayList<>();

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prepareData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        ;

        recyclerView = view.findViewById(R.id.groupRecyclerView);
        GridLayoutManager gridLayoutManager =
                new GridLayoutManager(getActivity(), 2);

        GroupListAdapter groupListAdapter = new GroupListAdapter(getActivity(), groupList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(groupListAdapter);

        return view;
    }


    private void prepareData() {

        List<Team> teams = new ArrayList<>();
        Team team = new Team(1, "Russia", "RUS",
                "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/23px-Flag_of_Russia.svg.png");
        teams.add(team);

        team = new Team(2, "Saudi Arabia", "KSA",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/23px-Flag_of_Saudi_Arabia.svg.png");
        teams.add(team);

        team = new Team(3, "Egypt", "EGY",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/23px-Flag_of_Egypt.svg.png");
        teams.add(team);

        team = new Team(4, "Uruguay", "URU",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/23px-Flag_of_Uruguay.svg.png");
        teams.add(team);

        groupList.add(teams);

        teams = new ArrayList<>();
        team = new Team(5, "Portugal", "POR",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Flag_of_Portugal.svg/23px-Flag_of_Portugal.svg.png");
        teams.add(team);

        team = new Team(6, "Spain", "ESP",
                "https://upload.wikimedia.org/wikipedia/en/thumb/9/9a/Flag_of_Spain.svg/23px-Flag_of_Spain.svg.png");
        teams.add(team);

        team = new Team(7, "Morocco", "MAR",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Morocco.svg/23px-Flag_of_Morocco.svg.png");
        teams.add(team);

        team = new Team(8, "Iran", "IRN",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/23px-Flag_of_Iran.svg.png");
        teams.add(team);

        groupList.add(teams);
    }

}
