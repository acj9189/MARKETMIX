package com.example.pruebamarketmix.models;

import android.util.Log;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("serial")
public class ShopingCar implements Serializable {

    private Double totalPay;
    private List<Asteroids> asteroidsList;

    public ShopingCar(Double totalPay, List<Asteroids> asteroidsList) {
        this.totalPay = totalPay;
        this.asteroidsList = asteroidsList;
    }

    public ShopingCar() {
        totalPay = 0.0;
    }



    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public List<Asteroids> getAsteroidsList() {
        return asteroidsList;
    }

    public void setAsteroidsList(List<Asteroids> asteroidsList) {
        this.asteroidsList = asteroidsList;
    }

    public boolean addElementShopingCar(Asteroids asteroids){
        return addElementShopingCarP(asteroids);
    }

    private boolean addElementShopingCarP(Asteroids asteroids){
        boolean flag = false;
        try {
            if(asteroidsList == null){
               asteroidsList = new LinkedList<>();
               totalPay = 0.0;
            }
            asteroidsList.add(asteroids);
            totalPay = totalPay + asteroids.getAbsolute_magnitude_h();
            flag = true;
            return flag;
        }
        catch (Exception ex){
            return flag;
        }
    }

    public boolean deleteElementShopingCar(Asteroids asteroids){
        return deleteElementShopingCarP(asteroids);
    }

    private boolean deleteElementShopingCarP(Asteroids asteroids){
        boolean flag = false;
        try {
            if(asteroidsList == null){
              return flag;
            }
            asteroidsList.remove(asteroidsList.indexOf(asteroids));
            totalPay = totalPay - asteroids.getAbsolute_magnitude_h();
            flag = true;
            return flag;
        }
        catch (Exception ex){
            return flag;
        }
    }
}
