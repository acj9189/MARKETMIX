package com.example.pruebamarketmix.apiService;

import android.content.Context;
import android.util.Log;

import com.example.pruebamarketmix.activities.MainActivity;
import com.example.pruebamarketmix.activities.ServicioExplicitoActivity;
import com.example.pruebamarketmix.models.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAsteroidsP {
    private String BASE_URL = "https://api.nasa.gov/neo/rest/v1/";
    private ApiInterfaceServices apiInterface;

    private List<Asteroids> asteroidsList;


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

    private void getAsteroidsp(final MainActivity context){

        Call<AsteroidContainer> call = this.apiInterface.getAsteroids("1991-08-08","1991-08-10","qvXJabbnDj7KD2FpQKm2bQg0vleUKfg9Zr4Fg461");
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

                    context.executeViewRecucler(asteroidsList.size(),asteroidsList);
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

    public void getApiAsteroidsDate(String year, String month, ServicioExplicitoActivity context){
        getApiAsteroidsDatep(year, month, context);

    }

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
