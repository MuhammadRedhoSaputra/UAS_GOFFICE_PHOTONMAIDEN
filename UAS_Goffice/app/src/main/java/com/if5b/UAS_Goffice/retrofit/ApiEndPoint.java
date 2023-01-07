package com.if5b.UAS_Goffice.retrofit;

import com.if5b.UAS_Goffice.models.Absen;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("masuk")
    Call<ArrayList<Absen>> getMasuk();
    @GET("keluar")
    Call<ArrayList<Absen>> getKeluar();
    @GET("izin")
    Call<ArrayList<Absen>> getIzin();
}
