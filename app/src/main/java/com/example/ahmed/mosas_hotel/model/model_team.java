package com.example.ahmed.mosas_hotel.model;

/**
 * Created by ahmed on 10/20/2016.
 */

public class model_team {


    private String team_title;
    private String discripton;
    private int team_pics;


    public model_team(String team_title, String discripton, int team_pics) {
        this.team_title=team_title;
        this.discripton=discripton;
        this.team_pics=team_pics;

    }

    public String getTeam_title() {
        return team_title;
    }

    public void setTeam_title(String team_title) {
        this.team_title = team_title;
    }

    public String getDiscripton() {
        return discripton;
    }

    public void setDiscripton(String discripton) {
        this.discripton = discripton;
    }

    public int getTeam_pics() {
        return team_pics;
    }

    public void setTeam_pics(int team_pics) {
        this.team_pics = team_pics;
    }
}

