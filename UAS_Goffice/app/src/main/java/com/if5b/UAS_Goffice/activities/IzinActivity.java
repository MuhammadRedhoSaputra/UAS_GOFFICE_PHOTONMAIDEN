package com.if5b.UAS_Goffice.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.if5b.UAS_Goffice.adapters.AbsenAdapter;
import com.if5b.UAS_Goffice.R;
import com.if5b.UAS_Goffice.models.Absen;
import com.if5b.UAS_Goffice.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IzinActivity extends AppCompatActivity {
    AbsenAdapter absenAdapter;
    List<Absen> absens= new ArrayList<>();
    RecyclerView rvIzin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izin);
        rvIzin= findViewById(R.id.rv_Izin);

        getAbsen();
    }

    private void getAbsen() {
        ApiService.apiEndPoint().getIzin().enqueue(new Callback<ArrayList<Absen>>() {
            @Override
            public void onResponse(Call<ArrayList<Absen>> call, Response<ArrayList<Absen>> response) {
                absens= response.body();
                loadAdapter(absens);
            }

            @Override
            public void onFailure(Call<ArrayList<Absen>> call, Throwable t) {

            }
        });
    }

    private void loadAdapter(List<Absen> absens) {
        absenAdapter= new AbsenAdapter();
        rvIzin.setLayoutManager(new LinearLayoutManager(this));
        rvIzin.setAdapter(absenAdapter);
        absenAdapter.setAbsens(absens);
    }
}
