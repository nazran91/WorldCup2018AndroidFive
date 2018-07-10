package com.aiub.worldcup2018androidfive.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.aiub.worldcup2018androidfive.ModelClasses.Team;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "world_cup";

    private static final String TEAM_TABLE_NAME = "teams";
    private static final String TEAM_ID = "team_id";
    private static final String TEAM_NAME = "team_name";
    private static final String TEAM_FIFA_CODE = "team_fifacode";
    private static final String TEAM_FLAG_URL = "team_flag_url";
    private static final String TEAM_GROUP_NAME = "team_group_name";

    public DatabaseHelper(Context context){
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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TEAM_TABLE_NAME;
        db.execSQL(DROP_TABLE);
    }

    public void addTeam(Team team) {

    }
}
