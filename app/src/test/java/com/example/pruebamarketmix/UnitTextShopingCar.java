package com.example.pruebamarketmix;

import com.example.pruebamarketmix.models.Asteroids;
import com.example.pruebamarketmix.models.ShopingCar;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class UnitTextShopingCar {

    ShopingCar shopingCar;
    List<Asteroids> asteroidsList;
    Asteroids asteroids;
    @Before
    public void setUp() throws Exception {
        shopingCar = new ShopingCar();
        asteroidsList = new LinkedList<>();

    }

    @Test
    public void textAddShopingCard(){
        asteroids = new Asteroids();
        shopingCar.addElementShopingCar(asteroids);
        assertEquals(1, shopingCar.getAsteroidsList().size());
    }

    @Test
    public void textDeleteShopingCard(){
        asteroids = new Asteroids();
        shopingCar.addElementShopingCar(asteroids);
        shopingCar.deleteElementShopingCar(asteroids);
        assertEquals(0, shopingCar.getAsteroidsList().size());

    }
}
