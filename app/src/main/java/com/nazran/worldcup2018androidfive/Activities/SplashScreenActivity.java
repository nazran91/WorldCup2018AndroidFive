package com.nazran.worldcup2018androidfive.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nazran.worldcup2018androidfive.Database.DatabaseHelper;
import com.nazran.worldcup2018androidfive.ModelClasses.MatchModel;
import com.nazran.worldcup2018androidfive.ModelClasses.Team;
import com.nazran.worldcup2018androidfive.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    private String API_URL = "https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/data.json";
    private DatabaseHelper databaseHelper;
    private List<Team> teamList = new ArrayList<>();
    private String[] groupNames = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scren);

        databaseHelper = new DatabaseHelper(SplashScreenActivity.this);
        teamList = databaseHelper.getAllTeams();

        getJSONData();
    }

    private void getJSONData() {

        RequestQueue requestQueue = Volley.newRequestQueue(SplashScreenActivity.this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, response.toString());

                try {
                    JSONArray stadiums = response.getJSONArray("stadiums");

                    for (int i = 0; i < stadiums.length(); i++) {
                        JSONObject jsonObject = stadiums.getJSONObject(i);

                        Log.e(TAG, "" + jsonObject.getInt("id"));
                        Log.e(TAG, "" + jsonObject.getString("name"));
                        Log.e(TAG, "" + jsonObject.getString("city"));
                        Log.e(TAG, "" + jsonObject.getDouble("lat"));
                        Log.e(TAG, "" + jsonObject.getDouble("lng"));
                        Log.e(TAG, "" + jsonObject.getString("image"));
                    }

                    JSONArray teams = response.getJSONArray("teams");

                    for (int i = 0; i < teams.length(); i++) {
                        JSONObject team = teams.getJSONObject(i);

                        int id = team.getInt("id");
                        String name = team.getString("name");
                        String fifaCode = team.getString("fifaCode");

                        Team teamObject = new Team(id, name, fifaCode, null);
                        databaseHelper.addTeam(teamObject);
                    }

                    JSONObject groups = response.getJSONObject("groups");

                    for (int k = 0; k < groupNames.length; k++) {
                        JSONObject group = groups.getJSONObject(groupNames[k]);

                        JSONArray matches = group.getJSONArray("matches");

                        for (int i = 0; i < matches.length(); i++) {
                            JSONObject match = matches.getJSONObject(i);

                            int name = match.getInt("name");
                            int home_team = match.getInt("home_team");
                            int away_team = match.getInt("away_team");
                            int home_result = match.getInt("home_result");
                            int away_result = match.getInt("away_result");
                            int stadium = match.getInt("stadium");
                            String date = match.getString("date");

                            MatchModel matchModel = new MatchModel(name, home_team, away_team, home_result,
                                    away_result, stadium, date, groupNames[k]);
                            databaseHelper.addMatch(matchModel);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage());
            }
        }
        );

        requestQueue.add(jsonObjectRequest);
    }
}
