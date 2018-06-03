package com.aiub.worldcup2018androidfive.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.aiub.worldcup2018androidfive.R;

public class NotificationsActivity extends AppCompatActivity {

    private ListView teamsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        teamsListView = findViewById(R.id.teamsListView);
    }
}
