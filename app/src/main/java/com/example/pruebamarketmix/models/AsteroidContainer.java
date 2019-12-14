package com.example.pruebamarketmix.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class AsteroidContainer {

    @SerializedName("links")
    @Expose
    private HashMap<String, String> links;

    @SerializedName("element_count")
    @Expose
    private int element_count;

    @SerializedName("near_earth_objects")
    @Expose
    private HashMap<String,List<Asteroids>> near_earth_objects;

    public AsteroidContainer() {
    }

    public AsteroidContainer(HashMap<String, String> links, int element_count, HashMap<String, List<Asteroids>> near_earth_objects) {
        this.links = links;
        this.element_count = element_count;
        this.near_earth_objects = near_earth_objects;
    }


    public HashMap<String, String> getLinks() {
        return links;
    }

    public void setLinks(HashMap<String, String> links) {
        this.links = links;
    }

    public int getElement_count() {
        return element_count;
    }

    public void setElement_count(int element_count) {
        this.element_count = element_count;
    }

    public HashMap<String, List<Asteroids>> getNear_earth_objects() {
        return near_earth_objects;
    }

    public void setNear_earth_objects(HashMap<String, List<Asteroids>> near_earth_objects) {
        this.near_earth_objects = near_earth_objects;
    }
}
