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


    //@GET("/feed?start_date=1991-08-08&end_date=1991-08-10&api_key=qvXJabbnDj7KD2FpQKm2bQg0vleUKfg9Zr4Fg461")
   // @GET("feed?start_date=START_DATE&end_date=END_DATE&api_key=API_KEY")
    @GET("feed")
    Call<AsteroidContainer> getAsteroids(@Query("start_date") String START_DATE , @Query("end_date") String END_DATE , @Query("api_key") String API_KEY );


}
