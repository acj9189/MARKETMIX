package com.example.pruebamarketmix.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;


import java.util.List;


public class NaviUtilities {

    private Toast toastmessage;
    private Intent executeIntent;



    public void UtilitiesNavi (){
    }


    private void sentMessagetoUserP(Context applicationContext, String message){
        this.toastmessage = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT);
        this.toastmessage.show();
    }

    /***
     * metodo que se encarga de enviar un mensaje a traves del objeto toast al usuario
     * @param applicationContext
     * @param message
     */
    public void sentMessagetoUser(Context applicationContext, String message){
        sentMessagetoUserP(applicationContext, message);
    }

    public void callActivity(Activity actualactivity , Class nextActivity){
        callActivityP(actualactivity ,nextActivity);
    }


    /***
     * metodo que se encarga de llamar un nuevo activity utilizando el actual, utilizanto el objeto Intent
     * @param actualactivity
     * @param nextActivity
     */
    private void callActivityP(Activity actualactivity, Class nextActivity) {
        try{
            this.executeIntent = new Intent(actualactivity, nextActivity);
            actualactivity.startActivity(executeIntent);
        }
        catch(Exception e){
            Log.d("Error " , e.getMessage());
        }
    }

    /*public void callActivityParameters(Activity actualactivity , Class nextActivity, Object Pameter){
        callActivityParametersP(actualactivity, nextActivity, Pameter);

    }

    private void callActivityParametersP(Activity actualactivity , Class nextActivity, Object Pameter){
        try{
            this.executeIntent = new Intent(actualactivity, nextActivity);
            this.executeIntent.p
            actualactivity.startActivity(executeIntent);
        }
        catch(Exception e){
            Log.d("Error " , e.getMessage());
        }

    }*/

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
