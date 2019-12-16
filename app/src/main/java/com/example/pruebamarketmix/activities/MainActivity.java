package com.example.pruebamarketmix.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.apiService.ApiAsteroidsP;
import com.example.pruebamarketmix.models.Asteroids;
import com.example.pruebamarketmix.models.ShopingCar;
import com.example.pruebamarketmix.utils.NaviUtilities;
import com.example.pruebamarketmix.utils.RecyclerAdapterApiSelectedItemShopingCar;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapterApiSelectedItemShopingCar.ClickLisener {

    private Button btnP;
    private ReadableBottomBar bottomBar;

    private NaviUtilities naviUtilities;
    private RecyclerView recyclerView;
    private int listaNUmeros;
    private ApiAsteroidsP apiAsteroids;

    private List<Asteroids> asteroidsList;
    private ShopingCar shopingCar;

    private boolean estadoConsulta = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiAsteroidsP apiAsteroids = new ApiAsteroidsP();

            apiAsteroids.getApiAsteroids(MainActivity.this);
            estadoConsulta = true;



        setTitle(R.string.title);

        naviUtilities = new NaviUtilities();
        shopingCar = new ShopingCar();

        if(getIntent().hasExtra("CarritoCompras")){
            ShopingCar  shopingCarRecu = (ShopingCar) getIntent().getExtras().getSerializable("CarritoCompras");
            shopingCar = shopingCarRecu;
        }

        bottomBar = (ReadableBottomBar) findViewById(R.id.ReadableBottomBar);
        bottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int index) {

                switch (index){
                    case 1:
                        naviUtilities.callActivityParameters( MainActivity.this, ServicioExplicitoActivity.class, shopingCar);
                        break;
                    case 2:
                        //Enviar al 3 que todavia no se ha echo...
                        naviUtilities.callActivityParameters( MainActivity.this, ShopingCarActivity.class, shopingCar);
                        break;

                }

            }
        });
    }

    public void executeViewRecucler(int listaAsteroids, List<Asteroids> list){

        //if (estadoConsulta == false) {
            recyclerView = (RecyclerView)  findViewById(R.id.peSLRecyclerViewShoping);
            recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
            LinearLayoutManager ll = new LinearLayoutManager(MainActivity.this); //error analizar...
            recyclerView.setLayoutManager(ll);
            RecyclerAdapterApiSelectedItemShopingCar recyclerAdapterApi = new RecyclerAdapterApiSelectedItemShopingCar(listaAsteroids, list, MainActivity.this);
            recyclerView.setAdapter(recyclerAdapterApi);
            recyclerView.setVisibility(View.VISIBLE);
            asteroidsList = list;
          //  estadoConsulta = true;
       // }


    }

    @Override
    public void onClickLisener(int itemClicked) {

        NaviUtilities naviUtilities = new NaviUtilities();
        Asteroids asteroid = asteroidsList.get(itemClicked);
        shopingCar.addElementShopingCar(asteroid);
        naviUtilities.sentMessageToUserCustomToast(MainActivity.this, "Se agregó el elemento al carrito de Compras Correctamente");
    }
}
