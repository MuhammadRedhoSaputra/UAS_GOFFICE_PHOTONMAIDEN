package com.if5b.UAS_Goffice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.if5b.UAS_Goffice.models.Absen;

import java.util.ArrayList;
import java.util.List;

public class AbsenAdapter extends RecyclerView.Adapter<AbsenAdapter.ViewHolder> {
    private List<Absen> absens= new ArrayList<>();

    public void setAbsens(List<Absen> absens) {
        this.absens = absens;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AbsenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_absen, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbsenAdapter.ViewHolder holder, int position) {
        Absen absen= absens.get(position);
        holder.tvNama.setText(absen.getNama());
        holder.tvTanggal.setText(absen.getTanggal());
        holder.tvWaktu.setText(absen.getWaktu());
        holder.tvKet.setText(absen.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return absens.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvTanggal, tvWaktu, tvKet;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama=itemView.findViewById(R.id.tv_Nama);
            tvTanggal=itemView.findViewById(R.id.tv_Tanggal);
            tvWaktu=itemView.findViewById(R.id.tv_Waktu);
            tvKet=itemView.findViewById(R.id.tv_Ket);
        }
    }
}
