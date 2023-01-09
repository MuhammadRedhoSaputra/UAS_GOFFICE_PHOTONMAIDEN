package com.if5b.UAS_Goffice.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.if5b.UAS_Goffice.R;
import com.if5b.UAS_Goffice.databinding.ActivityMasukBinding;
import com.if5b.UAS_Goffice.databinding.ActivityPostBinding;
import com.if5b.UAS_Goffice.models.Absen;
import com.if5b.UAS_Goffice.models.ValueNoData;
import com.if5b.UAS_Goffice.retrofit.ApiService;

import io.github.muddz.styleabletoast.StyleableToast;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    private ActivityPostBinding binding;
    public static final String Typedata = "typedata";
    private String TypeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPostBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        TypeData = getIntent().getStringExtra(Typedata);

        binding.btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSimpanRequest();
            }
        });
    }

    private void btnSimpanRequest() {
        String namamasuk = binding.etNama.getText().toString();
        String tanggalmasuk = binding.etTanggal.getText().toString();
        String waktumasuk = binding.etWaktu.getText().toString();
        String ketmasuk = binding.etKeterangan.getText().toString();

        if(TypeData.equals("Masuk")){
            ApiService.apiEndPoint().insertMasuk(namamasuk, tanggalmasuk, waktumasuk, ketmasuk).enqueue(new Callback<Absen>() {
                @Override
                public void onResponse(Call<Absen> call, Response<Absen> response) {

                }

                @Override
                public void onFailure(Call<Absen> call, Throwable t) {
                    StyleableToast.makeText(PostActivity.this, "Masuk Berhasil", R.style.gofficetoast).show();
                    Intent intent = new Intent(PostActivity.this, MasukActivity.class);
                    intent.putExtra(MasukActivity.Typedata, TypeData);
                    startActivity(intent);
                    finish();
                }
            });
        } else if(TypeData.equals("Keluar")){
            ApiService.apiEndPoint().insertKeluar(namamasuk, tanggalmasuk, waktumasuk, ketmasuk).enqueue(new Callback<ValueNoData>() {
                @Override
                public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {

                }

                @Override
                public void onFailure(Call<ValueNoData> call, Throwable t) {
                    StyleableToast.makeText(PostActivity.this, "Keluar Berhasil", R.style.gofficetoast).show();
                    Intent intent = new Intent(PostActivity.this, MasukActivity.class);
                    intent.putExtra(MasukActivity.Typedata, TypeData);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            ApiService.apiEndPoint().insertIzin(namamasuk, tanggalmasuk, waktumasuk, ketmasuk).enqueue(new Callback<ValueNoData>() {
                @Override
                public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {

                }

                @Override
                public void onFailure(Call<ValueNoData> call, Throwable t) {
                    StyleableToast.makeText(PostActivity.this, "Izin Berhasil", R.style.gofficetoast).show();
                    Intent intent = new Intent(PostActivity.this, MasukActivity.class);
                    intent.putExtra(MasukActivity.Typedata, TypeData);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }
}