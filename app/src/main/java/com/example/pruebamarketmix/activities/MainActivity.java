package com.example.pruebamarketmix.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.apiService.ApiAsteroidsP;
import com.example.pruebamarketmix.utils.NaviUtilities;
import com.iammert.library.readablebottombar.ReadableBottomBar;

public class MainActivity extends AppCompatActivity {

    private Button btnP;
    private ReadableBottomBar bottomBar;

    private NaviUtilities naviUtilities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ApiAsteroidsP apiAsteroids = new ApiAsteroidsP();
        apiAsteroids.getApiAsteroids();
        setTitle(R.string.title);

        naviUtilities = new NaviUtilities();

        bottomBar = (ReadableBottomBar) findViewById(R.id.ReadableBottomBar);
        bottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int index) {

                switch (index){
                    case 0:
                       naviUtilities.sentMessagetoUser( MainActivity.this,"Home");
                       // naviUtilities.callActivity(MainActivity.this, SplashActivity.class);
                        break;
                    case 1:
                        naviUtilities.callActivity( MainActivity.this, ServicioExplicitoActivity.class);
                        break;
                    case 2:
                       // naviUtilities.sentMessagetoUser( MainActivity.this,"Carrito");
                        break;

                }

            }
        });





    }
}
