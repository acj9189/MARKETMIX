package com.example.pruebamarketmix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("serial")
public class ApproachInformationAsteroids  implements Serializable {

    @SerializedName("close_approach_date")
    @Expose
    private String close_approach_date;

    @SerializedName("close_approach_date_full")
    @Expose
    private String close_approach_date_full;

    @SerializedName("epoch_date_close_approach")
    @Expose
    private Long epoch_date_close_approach;

    @SerializedName("relative_velocity")
    @Expose
    private HashMap<String,Double> relative_velocity;

    @SerializedName("miss_distance")
    @Expose
    private HashMap<String,Double> miss_distance;

    @SerializedName("orbiting_body")
    @Expose
    private String orbiting_body;

    public ApproachInformationAsteroids() {
    }

    public ApproachInformationAsteroids(String close_approach_date, String close_approach_date_full, Long epoch_date_close_approac, HashMap<String, Double> relative_velocity, HashMap<String, Double> miss_distance, String orbiting_body) {
        this.close_approach_date = close_approach_date;
        this.close_approach_date_full = close_approach_date_full;
        this.epoch_date_close_approach = epoch_date_close_approac;
        this.relative_velocity = relative_velocity;
        this.miss_distance = miss_distance;
        this.orbiting_body = orbiting_body;
    }

    public String getClose_approach_date() {
        return close_approach_date;
    }

    public void setClose_approach_date(String close_approach_date) {
        this.close_approach_date = close_approach_date;
    }

    public String getClose_approach_date_full() {
        return close_approach_date_full;
    }

    public void setClose_approach_date_full(String close_approach_date_full) {
        this.close_approach_date_full = close_approach_date_full;
    }

    public Long getEpoch_date_close_approach() {
        return epoch_date_close_approach;
    }

    public void setEpoch_date_close_approach(Long epoch_date_close_approac) {
        this.epoch_date_close_approach = epoch_date_close_approac;
    }

    public HashMap<String, Double> getRelative_velocity() {
        return relative_velocity;
    }

    public void setRelative_velocity(HashMap<String, Double> relative_velocity) {
        this.relative_velocity = relative_velocity;
    }

    public HashMap<String, Double> getMiss_distance() {
        return miss_distance;
    }

    public void setMiss_distance(HashMap<String, Double> miss_distance) {
        this.miss_distance = miss_distance;
    }

    public String getOrbiting_body() {
        return orbiting_body;
    }

    public void setOrbiting_body(String orbiting_body) {
        this.orbiting_body = orbiting_body;
    }
}
