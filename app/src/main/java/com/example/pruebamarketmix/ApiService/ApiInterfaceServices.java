package com.example.pruebamarketmix.ApiService;

import com.innova.aplication.models.Autenticacion;
import com.innova.aplication.models.Categories;
import com.innova.aplication.models.Cliente;
import com.innova.aplication.models.Services;
import com.innova.aplication.models.SiteLocal;
import com.innova.aplication.models.Ubicacion;
import com.innova.aplication.models.Usuario;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterfaceServices {

    /***
     * Metodo que indica hacer GET a Categorias
     * @return
             */
    @GET("/categories")
    Call <List<Categories>> getListCategories();

    /***
     * Metodo que indica hacer GET a Categorias
     * @return
     */
    @GET("/services")
    Call<List<Services>> getListServices();

    @GET("usuarios/{id}")
    Call <Usuario> getUsuario(@Path("id") int id);


    //POST

    @POST("/clientes")
    Call <Cliente>  postUbicacion(@Body Cliente cliente);

    @POST("usuarios")
    Call <Usuario> postUsuario(@Body Usuario usuario);

    @POST("/sitiolugars") // Cuando se responde con posT es necesario  ResponseBody y el body  en los parametros de entrada..
    Call<ResponseBody> postSiteLocal(@Body SiteLocal local);
    //Call<SiteLocal> createUser(SiteLocal local);


}
