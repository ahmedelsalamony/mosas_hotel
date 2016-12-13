package com.example.ahmed.mosas_hotel.model;

/**
 * Created by ahmed on 10/20/2016.
 */

public class model_activities {


    private String actvities_title;
    private String discripton;
    private int activities_pics;


    public int getActivities_pics() {
        return activities_pics;
    }

    public void setActivities_pics(int activities_pics) {
        this.activities_pics = activities_pics;
    }

    public model_activities(String actvities_title, String discripton, int activities_pics) {
        this.actvities_title=actvities_title;
        this.discripton=discripton;
        this.activities_pics=activities_pics;

    }

    public String getActvities_title() {
        return actvities_title;
    }

    public void setActvities_title(String actvities_title) {
        this.actvities_title = actvities_title;
    }

    public String getDiscripton() {
        return discripton;
    }

    public void setDiscripton(String discripton) {
        this.discripton = discripton;
    }
}

