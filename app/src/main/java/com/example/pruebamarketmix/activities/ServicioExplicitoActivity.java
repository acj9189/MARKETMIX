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

    private ReadableBottomBar bottomBar;    // Botón del menu.
    private NaviUtilities naviUtilities;   // Clase con servicios adicionales.
    private RecyclerView recyclerView;     // Objeto de la Lista reciclable.
    private Button btnConsultar;           // Botón que ejecuta la consulta de la Api.
    private TextView textViewFirsY;        // Caja de texto que se encarga de almacenar el año seleccionado por el usuario.
    private TextView textViewMonth;         // Caja de texto que se encarga de almacenar el Mes seleccionado por el usuario.

    private ApiAsteroidsP apiAsteroids;




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

            /***
             * Método donde se verifique el item seleccionado al hacer click en el objeto bottomBar.
             * @param index
             */
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
        textViewMonth = (TextView) findViewById(R.id.editTextMonth);
        textViewMonth.setOnClickListener(new View.OnClickListener() {
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
                apiAsteroids.getApiAsteroidsDate(textViewFirsY.getText().toString(), textViewMonth.getText().toString(), ServicioExplicitoActivity.this);

            }
        });
    }

    /***
     *        Método que se encarga de asignarle al objeto Recyclerview de la vista todo lo necesario para que este contenga la información de los anteriores, su nombre y su máximo Diámetro.
     * @param listaAsteroids Contiene el número de asteroides de la lista de los asteroids.
     * @param asteroidsList Esta lista contiene todos los asteroids traídos de la consulta realizada a través de retrofit.
     */
    public void executeViewRecucler(int listaAsteroids, List<Asteroids> asteroidsList){
        recyclerView = (RecyclerView)  findViewById(R.id.peSLRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(ServicioExplicitoActivity.this, DividerItemDecoration.VERTICAL));
        LinearLayoutManager ll = new LinearLayoutManager(ServicioExplicitoActivity.this); //error analizar...
        recyclerView.setLayoutManager(ll);
        RecyclerAdapterApi recyclerAdapterApi = new RecyclerAdapterApi(listaAsteroids, asteroidsList);
        recyclerView.setAdapter(recyclerAdapterApi);
        recyclerView.setVisibility(View.VISIBLE);
    }

}
