package com.example.pruebamarketmix;

import com.example.pruebamarketmix.activities.ServicioExplicitoActivity;
import com.example.pruebamarketmix.apiService.ApiAsteroidsP;
import com.example.pruebamarketmix.models.Asteroids;
import com.example.pruebamarketmix.models.ShopingCar;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */

public class UnitTextCarritoCompras {

    ShopingCar shopingCar;
    List<Asteroids> asteroidsList;
    Asteroids asteroids;
    ApiAsteroidsP apiAsteroids;


    @Before
    public void setUp() throws Exception {
        shopingCar = new ShopingCar();
        asteroidsList = new LinkedList<>();
        apiAsteroids = new ApiAsteroidsP();

    }

    @Test
    public void textAddShopingCardEqual(){
        asteroids = new Asteroids();
        shopingCar.addElementShopingCar(asteroids);
        assertEquals(1, shopingCar.getAsteroidsList().size());
    }

    @Test
    public void textDeleteShopingCardEqual(){
        asteroids = new Asteroids();
        shopingCar.addElementShopingCar(asteroids);
        shopingCar.deleteElementShopingCar(asteroids);
        assertEquals(0, shopingCar.getAsteroidsList().size());

    }

    @Test
    public void textAddShopingCardNotEqual(){
        asteroids = new Asteroids();
        shopingCar.addElementShopingCar(asteroids);
        assertNotEquals(0, shopingCar.getAsteroidsList().size());
    }

    @Test
    public void textDeleteShopingCardNotEqual(){
        asteroids = new Asteroids();
        shopingCar.addElementShopingCar(asteroids);
        shopingCar.deleteElementShopingCar(asteroids);
        assertNotEquals(1, shopingCar.getAsteroidsList().size());

    }

    @Test
    public void getApiBeforeResponseNUll(){
        apiAsteroids.getApiAsteroidsDate("1991", "08", new ServicioExplicitoActivity());
        assertNotNull(apiAsteroids.getAsteroidsList());
    }
}
