package com.example.pruebamarketmix.apiService;

import com.example.pruebamarketmix.models.*;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterfaceServices {


    /***
     *        Método que se encarga de realizar el llamado a la api utilizando la librería Retrofit.
     * @param START_DATE  // Fecha de inicio que se le envía a el servicio de la para definir los parámetros de búsqueda.
     * @param END_DATE    // Fecha final que se le envía a el servicio de la para definir los parámetros de búsqueda.
     * @param API_KEY    // String que contiene api Key de autenticación para realizar la consulta al servicio.
     * @return
     */
    @GET("feed")
    Call<AsteroidContainer> getAsteroids(@Query("start_date") String START_DATE , @Query("end_date") String END_DATE , @Query("api_key") String API_KEY );


}
