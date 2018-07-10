package com.aiub.worldcup2018androidfive.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.aiub.worldcup2018androidfive.Database.DatabaseHelper;
import com.aiub.worldcup2018androidfive.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreenActivity extends AppCompatActivity {

    private static final String TAG = SplashScreenActivity.class.getSimpleName();
    private String API_URL = "https://raw.githubusercontent.com/lsv/fifa-worldcup-2018/master/data.json";
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scren);

        databaseHelper = new DatabaseHelper(SplashScreenActivity.this);

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
