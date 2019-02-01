package com.fashioncatalogue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by FAMY on 22-Jan-17.
 */

public interface REAPI {
    @GET("/dd/register.php")
    Call<String> register(@Query("username") String username, @Query("password") String password,
                          @Query("email") String email, @Query("address") String address,
                          @Query("contact_number") String contact_number);

    @GET("/login.php")
    Call<String> login(@Query("uname") String username, @Query("pass") String password);

    @GET("/get_product_detail.php")
    Call<List<ProductModel>> ProductDetail(@Query("prod_name") String prod_name, @Query("from") String from, @Query("to") String to);
}