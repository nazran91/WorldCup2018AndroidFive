package com.aiub.worldcup2018androidfive.ModelClasses;

public class MatchModel {

    private int name, home_team, away_team, home_result, away_result, stadium;
    private String date, stage;

    public MatchModel(int name, int home_team, int away_team, int home_result, int away_result, int stadium, String date, String stage) {
        this.name = name;
        this.home_team = home_team;
        this.away_team = away_team;
        this.home_result = home_result;
        this.away_result = away_result;
        this.stadium = stadium;
        this.date = date;
        this.stage = stage;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getHome_team() {
        return home_team;
    }

    public void setHome_team(int home_team) {
        this.home_team = home_team;
    }

    public int getAway_team() {
        return away_team;
    }

    public void setAway_team(int away_team) {
        this.away_team = away_team;
    }

    public int getHome_result() {
        return home_result;
    }

    public void setHome_result(int home_result) {
        this.home_result = home_result;
    }

    public int getAway_result() {
        return away_result;
    }

    public void setAway_result(int away_result) {
        this.away_result = away_result;
    }

    public int getStadium() {
        return stadium;
    }

    public void setStadium(int stadium) {
        this.stadium = stadium;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
