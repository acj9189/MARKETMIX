package com.example.pruebamarketmix.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;


import com.example.pruebamarketmix.models.ShopingCar;

import java.io.Serializable;
import java.util.List;


public class NaviUtilities {

    private Toast toastmessage;
    private Intent executeIntent;

    private static ShopingCar sCar;



    public void UtilitiesNavi (){
    }

    public void sentMessagetoUser(Context applicationContext, String message){
        sentMessagetoUserP(applicationContext, message);
    }

    /***
     * metodo que se encarga de enviar un mensaje a traves del objeto toast al usuario
     * @param applicationContext
     * @param message
     */
    private void sentMessagetoUserP(Context applicationContext, String message){
        this.toastmessage = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT);
        this.toastmessage.show();
    }

    public void callActivity(Activity actualactivity , Class nextActivity){
        callActivityP(actualactivity ,nextActivity);
    }

    /***
     * metodo que se encarga de llamar un nuevo activity utilizando el actual, utilizanto el objeto Intent
     * @param actualActivity
     * @param nextActivity
     */
    private void callActivityP(Activity actualActivity, Class nextActivity) {
        try{
            this.executeIntent = new Intent(actualActivity, nextActivity);
            actualActivity.startActivity(executeIntent);
        }
        catch(Exception e){
            Log.d("Error " , e.getMessage());
        }
    }

    public void callActivityParameters(Activity actualActivity, Class nextActivity, ShopingCar car){
        callActivityParametersP(actualActivity, nextActivity, car);
    }

    private void callActivityParametersP(Activity actualActivity, Class nextActivity, ShopingCar car){
        //try{
//Todos los objetos que van aqui tiene que ser serializables si no no deja pasdar...
            this.executeIntent = new Intent(actualActivity, nextActivity);
            this.executeIntent.putExtra("CarritoCompras", car);
            actualActivity.startActivity(executeIntent);
        //}
        //catch(Exception e){
          //  Log.d("Error " , e.getMessage());
        //}
    }



    public void openWebPage(Activity actualactivity, String url){
        openWebPageP(actualactivity, url);
    }

    /***
     * metodo que se encarga de abrir paginas web utilizando el objeto Intent
     * @param actualactivity
     * @param url
     */
    private void openWebPageP(Activity actualactivity, String url){
        try{
            Uri uri = Uri.parse(url);
            this.executeIntent = new Intent(Intent.ACTION_VIEW, uri);
            actualactivity.startActivity(this.executeIntent);
        }
        catch(Exception e){
            Log.d("Error" , e.getMessage());
        }
    }



}
