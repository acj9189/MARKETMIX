package com.example.pruebamarketmix.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.models.ShopingCar;

import java.io.Serializable;
import java.util.List;


public class NaviUtilities  {

    private Toast toastmessage;
    private Intent executeIntent;


    public void UtilitiesNavi (){
    }

    public Toast getToastmessage() {
        return toastmessage;
    }


    public void setToastmessage(Toast toastmessage) {
        this.toastmessage = toastmessage;
    }

    public Intent getExecuteIntent() {
        return executeIntent;
    }

    public void setExecuteIntent(Intent executeIntent) {
        this.executeIntent = executeIntent;
    }

    public void sentMessagetoUser(Context applicationContext, String message){
        sentMessagetoUserP(applicationContext, message);
    }

    /***
     *        Método que se encarga de enviar un mensaje a través del objeto toast al usuario.
     * @param applicationContext Contexto en el cual se va ejecutar el Toast.
     * @param message Mensaje que se le va enviar al usuario a través del objeto Toast.
     */
    private void sentMessagetoUserP(Context applicationContext, String message){
        this.toastmessage = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT);
        this.toastmessage.show();
    }

    public void sentMessageToUserCustomToast(Context applicationContext, String message){
        sentMessageToUserCustomToastP(applicationContext, message);
    }

    /***
     *        Método que se encarga de enviar un mensaje a través del objeto toast al usuario, cuando este Toast es un objeto Modificado o es custom.
     * @param applicationContext Contexto en el cual se va ejecutar el Toast.
     * @param message Mensaje que se le va enviar al usuario a través del objeto Toast.
     */
    private void sentMessageToUserCustomToastP(Context applicationContext, String message){

        LayoutInflater inflater = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tt = new RelativeLayout(applicationContext);
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup)tt.findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.textViewcustomToast);
        text.setText(message);
        Toast toast = new Toast(applicationContext);
        toast.setGravity(Gravity.CENTER_VERTICAL, 10, 10);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();


    }

    public void callActivity(Activity actualactivity , Class nextActivity){
        callActivityP(actualactivity ,nextActivity);
    }

    /***
     *        Método que se encarga de llamar un nuevo activity utilizando el activity actual, a través del objeto Intent.
     * @param actualActivity Contexto actual quien va a realizar el llamado.
     * @param nextActivity Contexto siguiente quien recibe el llamado.
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

    /***
     *        Método que se encarga de llamar un nuevo activity utilizando el activity actual, a través del objeto Intent además envía información de tipo objetos a él activity siguiente .
     * @param actualActivity Contexto actual quien va a realizar el llamado.
     * @param nextActivity Contexto siguiente quien recibe el llamado.
     * @param car Objetivo que va a ser enviado al activity siguiente.
     */
    private void callActivityParametersP(Activity actualActivity, Class nextActivity, ShopingCar car){
        try{

            this.executeIntent = new Intent(actualActivity, nextActivity);
            this.executeIntent.putExtra("CarritoCompras", car);
            actualActivity.startActivity(executeIntent);
        }
        catch(Exception e){
           Log.d("Error " , e.getMessage());
        }
    }



    public void openWebPage(Activity actualactivity, String url){
        openWebPageP(actualactivity, url);
    }

    /***
     *        Método que se encarga de abrir páginas web utilizando el objeto Intent.
     * @param actualactivity Contexto actual quien va a realizar el llamado de la pagina.
     * @param url Cadena de texto que contiene la ruta de la página a abrir.
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
