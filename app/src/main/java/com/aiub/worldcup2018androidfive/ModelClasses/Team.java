package com.aiub.worldcup2018androidfive.ModelClasses;

public class Team {

    int id;
    String name, fifaCode, flag;

    public Team() {

    }

    // ALT+insert
    public Team(int id, String name, String fifaCode, String flag) {
        this.id = id;
        this.name = name;
        this.fifaCode = fifaCode;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFifaCode() {
        return fifaCode;
    }

    public void setFifaCode(String fifaCode) {
        this.fifaCode = fifaCode;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
