package com.example.pruebamarketmix.activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.utils.NaviUtilities;

public class SplashActivity extends AppCompatActivity {

    private final int DURACION_SPLASH = 4000;

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
