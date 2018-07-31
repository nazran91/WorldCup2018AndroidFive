package com.nazran.worldcup2018androidfive.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nazran.worldcup2018androidfive.ModelClasses.MatchModel;
import com.nazran.worldcup2018androidfive.ModelClasses.Team;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "world_cup_five";

    private static final String TEAM_TABLE_NAME = "teams";
    private static final String TEAM_ID = "team_id";
    private static final String TEAM_NAME = "team_name";
    private static final String TEAM_FIFA_CODE = "team_fifacode";
    private static final String TEAM_FLAG_URL = "team_flag_url";
    private static final String TEAM_GROUP_NAME = "team_group_name";

    private static final String MATCH_TABLE_NAME = "matches";
    private static final String MATCH_NAME = "name";
    private static final String MATCH_HOME_TEAM = "home_team";
    private static final String MATCH_AWAY_TEAM = "away_team";
    private static final String MATCH_HOME_RESULT = "home_result";
    private static final String MATCH_AWAY_RESULT = "away_result";
    private static final String MATCH_STADIUM = "stadium";
    private static final String MATCH_DATE = "date";
    private static final String MATCH_STAGE = "stage";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TEAMS_TABLE = "CREATE TABLE " + TEAM_TABLE_NAME + " ("
                + TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TEAM_NAME + " TEXT, "
                + TEAM_FIFA_CODE + " TEXT, "
                + TEAM_FLAG_URL + " TEXT DEFAULT NULL, "
                + TEAM_GROUP_NAME + " TEXT DEFAULT NULL)";
        db.execSQL(CREATE_TEAMS_TABLE);
        String CREATE_MATCHES_TABLE = "CREATE TABLE " + MATCH_TABLE_NAME + " ("
                + MATCH_NAME + " INTEGER PRIMARY KEY, "
                + MATCH_HOME_TEAM + " INTEGER, "
                + MATCH_AWAY_TEAM + " INTEGER, "
                + MATCH_HOME_RESULT + " INTEGER , "
                + MATCH_AWAY_RESULT + " INTEGER , "
                + MATCH_STADIUM + " INTEGER , "
                + MATCH_DATE + " TEXT ,"
                + MATCH_STAGE + " TEXT)";
        db.execSQL(CREATE_MATCHES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TEAM_TABLE = "DROP TABLE IF EXISTS " + TEAM_TABLE_NAME;
        db.execSQL(DROP_TEAM_TABLE);
        String DROP_MATCH_TABLE = "DROP TABLE IF EXISTS " + MATCH_TABLE_NAME;
        db.execSQL(DROP_MATCH_TABLE);
    }

    public void addTeam(Team team) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(TEAM_ID, team.getId());
        contentValues.put(TEAM_NAME, team.getName());
        contentValues.put(TEAM_FIFA_CODE, team.getFifaCode());

        sqLiteDatabase.insert(TEAM_TABLE_NAME, null, contentValues);

        sqLiteDatabase.close();
    }

    public void addMatch(MatchModel matchModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MATCH_NAME, matchModel.getName());
        contentValues.put(MATCH_HOME_TEAM, matchModel.getHome_team());
        contentValues.put(MATCH_AWAY_TEAM, matchModel.getAway_team());
        contentValues.put(MATCH_HOME_RESULT, matchModel.getHome_result());
        contentValues.put(MATCH_AWAY_RESULT, matchModel.getAway_result());
        contentValues.put(MATCH_DATE, matchModel.getDate());
        contentValues.put(MATCH_STADIUM, matchModel.getStadium());
        contentValues.put(MATCH_STAGE, matchModel.getStage());

        long rowId = sqLiteDatabase.insert(MATCH_TABLE_NAME, null, contentValues);
        Log.e("Database", "" + rowId);
        sqLiteDatabase.close();
    }

    public List<Team> getAllTeams() {
        List<Team> teamList = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String query = "SELECT * FROM " + TEAM_TABLE_NAME + " ORDER BY " + TEAM_ID;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Team team = new Team();
                team.setId(cursor.getInt(cursor.getColumnIndex(TEAM_ID)));
                team.setName(cursor.getString(cursor.getColumnIndex(TEAM_NAME)));
                team.setFifaCode(cursor.getString(cursor.getColumnIndex(TEAM_FIFA_CODE)));

                teamList.add(team);
            } while (cursor.moveToNext());
        }

        sqLiteDatabase.close();
        return teamList;
    }
}
