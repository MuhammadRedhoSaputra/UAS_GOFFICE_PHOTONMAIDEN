package com.if5b.UAS_Goffice.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {
    private static String baseURL="https://uasgofficepab2.000webhostapp.com/api/";
    private static Retrofit retrofit;
    public static ApiEndPoint apiEndPoint(){
        retrofit=new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiEndPoint.class);
    }
}
