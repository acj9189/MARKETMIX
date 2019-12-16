package com.example.pruebamarketmix.models;

import android.content.Context;
import android.util.Log;

import com.example.pruebamarketmix.db.ManageSQLiteDB;
import com.example.pruebamarketmix.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */
@SuppressWarnings("serial")
public class ShopingCar implements Serializable {


    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("totalPay")
    @Expose
    private Double totalPay;

    @SerializedName("asteroidsList")
    @Expose
    private List<Asteroids> asteroidsList;


    public ShopingCar(Integer id, Double totalPay, List<Asteroids> asteroidsList) {
        this.id = id;
        this.totalPay = totalPay;
        this.asteroidsList = asteroidsList;
    }

    public ShopingCar() {
        totalPay = 0.0;
        id = Constants.count.incrementAndGet();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /***
     *        Método que se encarga de agregar elementos al carrito de compras.
     * @param asteroids     // Asteroide que se va a ingresar al carrito de Compras.
     * @return
     */
    private boolean addElementShopingCarP(Asteroids asteroids){
        boolean response = false;
        try {
            if(asteroidsList == null){
               asteroidsList = new LinkedList<>();
               totalPay = 0.0;
            }
            asteroidsList.add(asteroids);
            totalPay = totalPay + asteroids.getAbsolute_magnitude_h();

           response = true;
            return response;
        }
        catch (Exception ex){
            return response;
        }
    }

    public boolean deleteElementShopingCar(Asteroids asteroids){
        return deleteElementShopingCarP(asteroids);
    }

    /***
     *        Método que se encarga de eliminar elementos al carrito de compras.
     * @param asteroids    // Asteroide que se va a eliminar del carrito de Compras.
     * @return
     */
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

    public boolean addListDataBase(Context context){
        return addListDataBaseP(context);
    }

    /***
     *        Método que se encarga de realizar la inserción a la base de datos de SQLite.
     * @param context     // Contexto que ejecuta la acción de agregar a la base de datos.
     * @return
     */
    private boolean addListDataBaseP(Context context){
        ManageSQLiteDB  manageSQLiteDB = new ManageSQLiteDB(context);
        boolean response = false;
        for (int i =0 ; i < asteroidsList.size(); i++){
            response = false;
            List<Object> data = new LinkedList<>();
            data.add(id);
            data.add(asteroidsList.get(i).getId());
            response = manageSQLiteDB.addTable(Constants.SHOPINGCAR_TABLE, data);
        }
        manageSQLiteDB.closeCoMakeConecction();
        return response;
    }
}
