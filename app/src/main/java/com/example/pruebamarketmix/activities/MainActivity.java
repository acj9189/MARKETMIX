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

/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */
public class MainActivity extends AppCompatActivity implements RecyclerAdapterApiSelectedItemShopingCar.ClickLisener {


    private ReadableBottomBar bottomBar;     // Botón del menu.
    private NaviUtilities naviUtilities;     // Clase con servicios adicionales.
    private RecyclerView recyclerView;       // Objeto de la Lista reciclable.
    private ApiAsteroidsP apiAsteroids;      // Clase que contiene los métodos de llamados a la Api.
    private List<Asteroids> asteroidsList;   // Objeto lista de asteroides.
    private ShopingCar shopingCar;           // Objeto carrito de Compras.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.titleM);
        apiAsteroids = new ApiAsteroidsP();
        apiAsteroids.getApiAsteroids(MainActivity.this);
        callApi();
        bottomBar = (ReadableBottomBar) findViewById(R.id.ReadableBottomBar);
        bottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            /***
             * Método donde se verifique el item seleccionado al hacer click en el objeto bottomBar.
             * @param index
             */
            @Override
            public void onItemSelected(int index) {

                switch (index){
                    case 1:
                        naviUtilities.callActivityParameters( MainActivity.this, ServicioExplicitoActivity.class, shopingCar);
                        break;
                    case 2:
                        naviUtilities.callActivityParameters( MainActivity.this, ShopingCarActivity.class, shopingCar);
                        break;
                }

            }
        });
    }

    /***
     *        Método que se encarga de asignarle al objeto Recyclerview de la vista todo lo necesario para que este contenga la información de los anteriores, su nombre y su máximo Diámetro.
     * @param listaAsteroids Contiene el número de asteroides de la lista de los asteroids.
     * @param list Esta lista contiene todos los asteroids traídos de la consulta realizada a través de retrofit.
     */
    public void executeViewRecycler(int listaAsteroids, List<Asteroids> list){
            recyclerView = (RecyclerView)  findViewById(R.id.peSLRecyclerViewShoping);
            recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL));
            LinearLayoutManager ll = new LinearLayoutManager(MainActivity.this); //error analizar...
            recyclerView.setLayoutManager(ll);
            RecyclerAdapterApiSelectedItemShopingCar recyclerAdapterApi = new RecyclerAdapterApiSelectedItemShopingCar(listaAsteroids, list, MainActivity.this);
            recyclerView.setAdapter(recyclerAdapterApi);
            recyclerView.setVisibility(View.VISIBLE);
            asteroidsList = list;
    }

    /***
     *        MMétodo que se encarga de reaccionar cuando al el objeto recyclerview le realizaron un click, para agregar un asteroide al carrito de compra.
     * @param itemClicked Contiene el número del elemento de la lista que fue seleccionado.
     */
    @Override
    public void onClickLisener(int itemClicked) {
        NaviUtilities naviUtilities = new NaviUtilities();
        Asteroids asteroid = asteroidsList.get(itemClicked);
        shopingCar.addElementShopingCar(asteroid);
        naviUtilities.sentMessageToUserCustomToast(MainActivity.this, "Se agregó el elemento al carrito de Compras Correctamente");
    }

    /***
     * Método que se encarga de observar si el objeto carrito de compras contiene o no información.
     */
    private void callApi(){
        naviUtilities = new NaviUtilities();
        shopingCar = new ShopingCar();
        if(getIntent().hasExtra("CarritoCompras")){
            ShopingCar  shopingCarRecu = (ShopingCar) getIntent().getExtras().getSerializable("CarritoCompras");
            shopingCar = shopingCarRecu;
        }
    }
}
