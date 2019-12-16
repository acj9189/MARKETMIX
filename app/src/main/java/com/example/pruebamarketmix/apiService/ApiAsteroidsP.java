package com.example.pruebamarketmix.apiService;

import android.util.Log;

import com.example.pruebamarketmix.activities.MainActivity;
import com.example.pruebamarketmix.activities.ServicioExplicitoActivity;
import com.example.pruebamarketmix.models.*;
import com.example.pruebamarketmix.utils.Constants;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/***
 *   Desarrollado por el ingeniero Andrés Eduardo Cárdenas Jaramillo del 14 de diciembre la 16 de diciembre del 2019.
 */
public class ApiAsteroidsP {
    private String BASE_URL = Constants.BASE_URL;                    // Contiene el main link de la ruta para hacer la consulta.
    private ApiInterfaceServices apiInterface;                      // Implementa la interfaz que sura retrofit para realizar el REST.
    private List<Asteroids> asteroidsList;                         // Objeto lista de asteroides.

    /***
     *     Se encarga de configurar todo los parámetros necesarios para que la librería los utilice según la configuración.
     */
    public ApiAsteroidsP(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create())
                .build();
        this.apiInterface = retrofit.create(ApiInterfaceServices.class);

    }

    public void getApiAsteroids(MainActivity context){
        getAsteroidsp(context);
    }

    /***
     *        Método que realiza la consulta al APi de la nasa con mi fecha de nacimiento para observar los asteroides cercanos a la tierra en esa fecha.
     * @param context   // Contexto para llevarlos a la Interfaz.
     */
    private void getAsteroidsp(final MainActivity context){

        Call<AsteroidContainer> call = this.apiInterface.getAsteroids("1991-08-08","1991-08-10","qvXJabbnDj7KD2FpQKm2bQg0vleUKfg9Zr4Fg461");
        call.enqueue(new Callback<AsteroidContainer>() {
            @Override
            public void onResponse(Call<AsteroidContainer> call, Response<AsteroidContainer> response) {

                    if(!response.isSuccessful()){
                    asteroidsList = null;
                    return ;
                }
                    AsteroidContainer asteroidContainer = (AsteroidContainer) response.body();
                    asteroidsList = new LinkedList<>();
                    Iterator it = asteroidContainer.getNear_earth_objects().entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        List<Asteroids> temp = (List<Asteroids>)pair.getValue();
                        for (int i = 0; i< temp.size(); i++){
                            asteroidsList.add(temp.get(i));
                        }
                        it.remove();
                    }
                    context.executeViewRecycler(asteroidsList.size(),asteroidsList);
                    asteroidsList = null;
                    return;
            }

            @Override
            public void onFailure(Call<AsteroidContainer> call, Throwable t) {
                asteroidsList = null;
                return;

            }
        });
    }

    public void getApiAsteroidsDate(String year, String month, ServicioExplicitoActivity context){
        getApiAsteroidsDatep(year, month, context);

    }

    /***
     *        Método que realiza la consulta al API de la nasa con las fechas en las que el usuario desea observar los asteroides cercanos a la tierra.
     * @param year       // Contiene el año en que el usuario desea buscar.
     * @param month     // Contiene el mes en las que el usuario desea buscar.
     * @param context   // Contexto para llevarlos a la Interfaz.
     */
    private void getApiAsteroidsDatep(String year, String month, final ServicioExplicitoActivity context ){
        Call<AsteroidContainer> call = this.apiInterface.getAsteroids(year + "-" + month +"-15", year + "-" + month +"-20", "qvXJabbnDj7KD2FpQKm2bQg0vleUKfg9Zr4Fg461");
        call.enqueue(new Callback<AsteroidContainer>() {
            @Override
            public void onResponse(Call<AsteroidContainer> call, Response<AsteroidContainer> response) {
                if(!response.isSuccessful()){
                    asteroidsList = null;
                    Log.e("Entre", "Por aqui en respuesta: "+ response.message());
                    return ;
                }
                AsteroidContainer asteroidContainer = (AsteroidContainer) response.body();
                asteroidsList = new LinkedList<>();

                Iterator it = asteroidContainer.getNear_earth_objects().entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    List<Asteroids> temp = (List<Asteroids>)pair.getValue();
                    for (int i = 0; i< temp.size(); i++){
                        asteroidsList.add(temp.get(i));
                    }
                    //System.out.println(pair.getKey() + " = " + pair.getValue());
                    it.remove();
                }

                context.executeViewRecucler(asteroidsList.size(), asteroidsList);

                Log.e("Cantidad de asteroides ", String.valueOf(asteroidsList.size()));
                //context.setCategorySpinnerP(asteroidsList);
                return;

            }

            @Override
            public void onFailure(Call<AsteroidContainer> call, Throwable t) {
                Log.e("Entre", "Por aqui en falla " + t.getMessage());
                asteroidsList = null;
                //context.setCategorySpinnerP(listCategories);
                return;

            }
        });

    }

    public List<Asteroids> getAsteroidsList() {
        return asteroidsList;
    }

    public void setAsteroidsList(List<Asteroids> asteroidsList) {
        this.asteroidsList = asteroidsList;
    }
}
