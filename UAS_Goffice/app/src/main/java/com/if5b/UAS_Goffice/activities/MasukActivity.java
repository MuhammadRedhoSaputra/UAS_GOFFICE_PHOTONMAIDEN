package com.if5b.UAS_Goffice.activities;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.if5b.UAS_Goffice.adapters.AbsenAdapter;
import com.if5b.UAS_Goffice.R;
import com.if5b.UAS_Goffice.databinding.ActivityMasukBinding;
import com.if5b.UAS_Goffice.models.Absen;
import com.if5b.UAS_Goffice.retrofit.ApiService;
import com.if5b.UAS_Goffice.retrofit.Utilities;

import java.util.ArrayList;
import java.util.List;

import io.github.muddz.styleabletoast.StyleableToast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MasukActivity extends AppCompatActivity {
    private ActivityMasukBinding binding;
    public static final String Typedata = "typedata";

    AbsenAdapter absenAdapter;
    List<Absen>absens= new ArrayList<>();
    RecyclerView rvMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMasukBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        rvMasuk= findViewById(R.id.rv_masuk);
        binding.fabAdd.bringToFront();
        String Type = getIntent().getStringExtra(Typedata);

        binding.fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleableToast.makeText(MasukActivity.this, "Button ditekan", R.style.gofficetoast).show();
                Intent intent = new Intent(MasukActivity.this, PostActivity.class);
                intent.putExtra(PostActivity.Typedata, Type);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        String Type = getIntent().getStringExtra(Typedata);

        if(getIntent().equals("Masuk")){
            getAbsen();

        } else if(Type.equals("Keluar")){

            ApiService.apiEndPoint().getKeluar().enqueue(new Callback<ArrayList<Absen>>() {
                @Override
                public void onResponse(Call<ArrayList<Absen>> call, Response<ArrayList<Absen>> response) {
                    absens= response.body();
                    loadAdapter(absens);
                }

                @Override
                public void onFailure(Call<ArrayList<Absen>> call, Throwable t) {

                }
            });

        } else {
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
    }

    private void getAbsen() {
        ApiService.apiEndPoint().getMasuk().enqueue(new Callback<ArrayList<Absen>>() {
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
        rvMasuk.setLayoutManager(new LinearLayoutManager(this));
        rvMasuk.setAdapter(absenAdapter);
        absenAdapter.setAbsens(absens);
    }

}