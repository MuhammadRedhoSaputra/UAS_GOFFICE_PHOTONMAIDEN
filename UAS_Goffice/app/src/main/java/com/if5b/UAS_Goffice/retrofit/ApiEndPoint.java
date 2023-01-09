package com.if5b.UAS_Goffice.retrofit;

import com.if5b.UAS_Goffice.models.Absen;
import com.if5b.UAS_Goffice.models.ValueNoData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {

    @GET("masuk")
    Call<ArrayList<Absen>> getMasuk();
    @POST("masuk")
    @FormUrlEncoded
    Call<Absen> insertMasuk(@Field("nama") String namamasuk,
                                  @Field("tanggal") String tanggalmasuk,
                                  @Field("waktu") String waktumasuk,
                                  @Field("keterangan") String ketmasuk);

    @GET("keluar")
    Call<ArrayList<Absen>> getKeluar();
    @POST("keluar")
    @FormUrlEncoded
    Call<ValueNoData> insertKeluar(@Field("nama") String namakeluar,
                                  @Field("tanggal") String tanggalkeluar,
                                  @Field("waktu") String waktukeluar,
                                  @Field("keterangan") String ketkeluar);

    @GET("izin")
    Call<ArrayList<Absen>> getIzin();
    @POST("izin")
    @FormUrlEncoded
    Call<ValueNoData> insertIzin(@Field("nama") String namaizin,
                                  @Field("tanggal") String tanggalizin,
                                  @Field("waktu") String waktuizin,
                                  @Field("keterangan") String ketizin);

}
