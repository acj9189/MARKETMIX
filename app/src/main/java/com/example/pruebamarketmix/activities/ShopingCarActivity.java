package com.example.pruebamarketmix.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.models.Asteroids;
import com.example.pruebamarketmix.models.ShopingCar;
import com.example.pruebamarketmix.utils.NaviUtilities;
import com.example.pruebamarketmix.utils.RecyclerAdapterApiSelectedItemShopingCar;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import java.util.LinkedList;
import java.util.List;

/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */
public class ShopingCarActivity extends AppCompatActivity implements RecyclerAdapterApiSelectedItemShopingCar.ClickLisener {

    private ReadableBottomBar bottomBar;  // Botón del menu.
    private NaviUtilities naviUtilities;  // Clase con servicios adicionales.
    private RecyclerView recyclerView;    // Objeto de la Lista reciclable.
    private ShopingCar shopingCar;        // Objeto carrito de Compras.
    private TextView countTextView;       // Caja de texto que contiene el número de elementos en el carrito de compras.
    private TextView payTextView;         // Caja de texto que contiene la sumatoria de todos los máximos diámetros de los asteroides, lo que representa el dinero a pagar.

    private Button btnComprar;            // Boton Comprar


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoping_car);
        setTitle(R.string.titleShoping);

        naviUtilities = new NaviUtilities();
        shopingCar = new ShopingCar();
        if(getIntent().hasExtra("CarritoCompras")){
            ShopingCar  shopingCarRecu = (ShopingCar) getIntent().getExtras().getSerializable("CarritoCompras");
            shopingCar = shopingCarRecu;

            if(shopingCar.getAsteroidsList() == null){
                shopingCar.setAsteroidsList(new LinkedList<Asteroids>());

            }
        }

        countTextView = (TextView) findViewById(R.id.textViewCountAsteroids);
        countTextView.setText( String.valueOf(shopingCar.getAsteroidsList().size()) );

        payTextView = (TextView) findViewById(R.id.textViewTotalNumber);
        payTextView.setText( String.valueOf( shopingCar.getTotalPay()));



        bottomBar = (ReadableBottomBar) findViewById(R.id.ReadableBottomBar);
        bottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {

            /***
             * Método donde se verifique el item seleccionado al hacer click en el objeto bottomBar.
             * @param index
             */
            @Override
            public void onItemSelected(int index) {

                switch (index){
                    case 0:
                        naviUtilities.callActivityParameters( ShopingCarActivity.this, MainActivity.class, shopingCar);
                        break;
                    case 1:
                        //Enviar al 3 que todavia no se ha echo...
                        naviUtilities.callActivityParameters( ShopingCarActivity.this, ServicioExplicitoActivity.class, shopingCar);
                        break;

                }

            }
        });

        btnComprar = (Button) findViewById(R.id.btnComprar);
        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(shopingCar.getAsteroidsList().size()> 0){
                    boolean response = shopingCar.addListDataBase(ShopingCarActivity.this);
                    if(response == true){
                        naviUtilities.sentMessageToUserCustomToast(ShopingCarActivity.this, "El carrito se almaceno correctmante en la base de datos..");
                        shopingCar = new ShopingCar();
                        naviUtilities.callActivity(ShopingCarActivity.this ,MainActivity.class);
                    }

                }

            }
        });

        executeViewRecucler();
    }

    /***
     *      Método que se encarga de asignarle al objeto Recyclerview de la vista todo lo necesario para que este contenga la información de los anteriores, su nombre y su máximo Diámetro.
     */
    private void executeViewRecucler(){
        recyclerView = (RecyclerView)  findViewById(R.id.peSLRecyclerViewShopingCard);

        recyclerView.addItemDecoration(new DividerItemDecoration(ShopingCarActivity.this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager ll = new LinearLayoutManager(ShopingCarActivity.this); //error analizar...
        recyclerView.setLayoutManager(ll);
        int cantidadElementoscarritro = 0;

        List<Asteroids> asteroidsList = new LinkedList<>();
        if(shopingCar.getAsteroidsList() != null){
            cantidadElementoscarritro = shopingCar.getAsteroidsList().size();
            asteroidsList = shopingCar.getAsteroidsList();
        }

        RecyclerAdapterApiSelectedItemShopingCar recyclerAdapterApi = new RecyclerAdapterApiSelectedItemShopingCar(cantidadElementoscarritro, asteroidsList, ShopingCarActivity.this);
        recyclerView.setAdapter(recyclerAdapterApi);
        recyclerView.setVisibility(View.VISIBLE);
        btnComprar.setEnabled(true);
    }

    /***
     *        Método que se encarga de reaccionar cuando al el objeto recyclerview le realizaron un click, para eliminar un asteroide al carrito de compra.
     * @param itemClicked
     */
    @Override
    public void onClickLisener(int itemClicked) {
        NaviUtilities naviUtilities = new NaviUtilities();
        Asteroids asteroid = shopingCar.getAsteroidsList().get(itemClicked);
        shopingCar.deleteElementShopingCar(asteroid);
        naviUtilities.sentMessageToUserCustomToast(ShopingCarActivity.this, "Se eliminó el elemento al carrito de Compras Correctamente");
        if(shopingCar.getAsteroidsList().size() == 0) {
            payTextView.setText(R.string.count);
        }
        else{
            payTextView.setText( String.valueOf(shopingCar.getTotalPay()) );
        }
        countTextView.setText( String.valueOf(shopingCar.getAsteroidsList().size()) );
        executeViewRecucler();

    }
}
