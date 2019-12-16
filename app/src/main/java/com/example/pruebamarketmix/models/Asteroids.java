package com.example.pruebamarketmix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */

@SuppressWarnings("serial")
public class Asteroids implements Serializable {

    @SerializedName("links")
    @Expose
    private HashMap<String,String> links;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("neo_reference_id")
    @Expose
    private String neo_reference_id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("nasa_jpl_url")
    @Expose
    private String nasa_jpl_url;

    @SerializedName("absolute_magnitude_h")
    @Expose
    private double absolute_magnitude_h;

    @SerializedName("estimated_diameter")
    @Expose
    private HashMap<String, HashMap<String,Double>> estimated_diameter;

    @SerializedName("is_potentially_hazardous_asteroid")
    @Expose
    private boolean is_potentially_hazardous_asteroid;

    @SerializedName("close_approach_data")
    @Expose
    private List<ApproachInformationAsteroids> close_approach_data;

    @SerializedName("is_sentry_object")
    @Expose
    private boolean is_sentry_object;

    public Asteroids() {
    }

    public Asteroids(HashMap<String, String> links, String id, String neo_reference_id, String name, String nasa_jpl_url, double absolute_magnitude_h, HashMap<String, HashMap<String, Double>> estimated_diameter, boolean is_potentially_hazardous_asteroid, List<ApproachInformationAsteroids> close_approach_data, boolean is_sentry_object) {
        this.links = links;
        this.id = id;
        this.neo_reference_id = neo_reference_id;
        this.name = name;
        this.nasa_jpl_url = nasa_jpl_url;
        this.absolute_magnitude_h = absolute_magnitude_h;
        this.estimated_diameter = estimated_diameter;
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
        this.close_approach_data = close_approach_data;
        this.is_sentry_object = is_sentry_object;
    }

    public HashMap<String, String> getLinks() {
        return links;
    }

    public void setLinks(HashMap<String, String> links) {
        this.links = links;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNeo_reference_id() {
        return neo_reference_id;
    }

    public void setNeo_reference_id(String neo_reference_id) {
        this.neo_reference_id = neo_reference_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasa_jpl_url() {
        return nasa_jpl_url;
    }

    public void setNasa_jpl_url(String nasa_jpl_url) {
        this.nasa_jpl_url = nasa_jpl_url;
    }

    public double getAbsolute_magnitude_h() {
        return absolute_magnitude_h;
    }

    public void setAbsolute_magnitude_h(double absolute_magnitude_h) {
        this.absolute_magnitude_h = absolute_magnitude_h;
    }

    public HashMap<String, HashMap<String, Double>> getEstimated_diameter() {
        return estimated_diameter;
    }

    public void setEstimated_diameter(HashMap<String, HashMap<String, Double>> estimated_diameter) {
        this.estimated_diameter = estimated_diameter;
    }

    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public void setIs_potentially_hazardous_asteroid(boolean is_potentially_hazardous_asteroid) {
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
    }

    public boolean isIs_sentry_object() {
        return is_sentry_object;
    }

    public void setIs_sentry_object(boolean is_sentry_object) {
        this.is_sentry_object = is_sentry_object;
    }

    public List<ApproachInformationAsteroids> getClose_approach_data() {
        return close_approach_data;
    }

    public void setClose_approach_data(List<ApproachInformationAsteroids> close_approach_data) {
        this.close_approach_data = close_approach_data;
    }
}
