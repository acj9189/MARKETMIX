package com.example.pruebamarketmix.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.utils.NaviUtilities;

/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */
public class SplashActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 4500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setTitle(R.string.title);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable(){
            public void run(){
                NaviUtilities naviUtilities = new NaviUtilities();
                naviUtilities.callActivity(SplashActivity.this, MainActivity.class);
                finish();
            };
        }, DURACION_SPLASH);
    }

}
