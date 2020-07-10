package com.example.mytest.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/")
    Call<MovieRsponse> getMovieList(@Query("apikey") String apiKey, @Query("s") String value,
                                    @Query("type") String type);
    @GET("/")
    Call<MovieDetailsResponse> getMovieDetails(@Query("apikey") String apiKey, @Query("i") String value);

}
