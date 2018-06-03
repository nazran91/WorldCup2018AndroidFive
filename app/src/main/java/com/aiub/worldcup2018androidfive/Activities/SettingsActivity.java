package com.aiub.worldcup2018androidfive.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.aiub.worldcup2018androidfive.R;

public class SettingsActivity extends AppCompatActivity {

    private TextView teamsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        teamsText = findViewById(R.id.teamsText);
        teamsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
