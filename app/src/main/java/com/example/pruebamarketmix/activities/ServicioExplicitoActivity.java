package com.example.pruebamarketmix.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebamarketmix.R;
import com.example.pruebamarketmix.apiService.ApiAsteroidsP;
import com.example.pruebamarketmix.models.Asteroids;
import com.example.pruebamarketmix.models.ShopingCar;
import com.example.pruebamarketmix.utils.NaviUtilities;
import com.example.pruebamarketmix.utils.RecyclerAdapterApi;
import com.iammert.library.readablebottombar.ReadableBottomBar;

import java.util.List;

public class ServicioExplicitoActivity extends AppCompatActivity {

    private ReadableBottomBar bottomBar;
    private NaviUtilities naviUtilities;

    private Button btnConsultar;
    private TextView textViewFirsY;
    private TextView textViewEndY;

    private ApiAsteroidsP apiAsteroids;

    private RecyclerView recyclerView;
    private int listaNUmeros;
    private List<Asteroids> asteroidsList;

    private ShopingCar shopingCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_service);
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
                    case 0:
                        naviUtilities.callActivityParameters( ServicioExplicitoActivity.this, MainActivity.class, shopingCar);
                        break;
                    case 2:
                        //Enviar al 3 que todavia no se ha echo...
                        naviUtilities.callActivityParameters( ServicioExplicitoActivity.this, ShopingCarActivity.class, shopingCar);
                        break;

                }

            }
        });


        apiAsteroids = new ApiAsteroidsP();
        textViewFirsY = (TextView) findViewById(R.id.editTextFirstYear);
        textViewFirsY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.INVISIBLE);
            }
        });
        textViewEndY = (TextView) findViewById(R.id.editTextEndYear);
        textViewEndY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.INVISIBLE);
            }
        });
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui tengo el problrma de la asincronidad
                apiAsteroids.getApiAsteroidsDate(textViewFirsY.getText().toString(), textViewEndY.getText().toString(), ServicioExplicitoActivity.this);

            }
        });
    }

    public void executeViewRecucler(int listaAsteroids, List<Asteroids> asteroidsList){
        recyclerView = (RecyclerView)  findViewById(R.id.peSLRecyclerView);
        /*if(recyclerView.getVisibility() == View.VISIBLE){
            recyclerView.setVisibility(View.INVISIBLE);
        }
        else{
            recyclerView.setVisibility(View.VISIBLE);
        }

        /* Aqui tengo problema de sincornizidad correjir ademas falta meterle al objeto la info necesaria...*/

        recyclerView.addItemDecoration(new DividerItemDecoration(ServicioExplicitoActivity.this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager ll = new LinearLayoutManager(ServicioExplicitoActivity.this); //error analizar...
        recyclerView.setLayoutManager(ll);
        RecyclerAdapterApi recyclerAdapterApi = new RecyclerAdapterApi(listaAsteroids, asteroidsList);
        recyclerView.setAdapter(recyclerAdapterApi);
        recyclerView.setVisibility(View.VISIBLE);



    }

}
