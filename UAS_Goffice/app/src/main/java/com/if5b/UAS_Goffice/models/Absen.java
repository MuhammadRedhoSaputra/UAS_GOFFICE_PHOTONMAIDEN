package com.if5b.UAS_Goffice.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Absen implements Parcelable {

    @SerializedName("Nama")
    private String nama;

    @SerializedName("Tanggal")
    private String tanggal;

    @SerializedName("Waktu")
    private String waktu;

    @SerializedName("Keterangan")
    private String keterangan;

    protected Absen(Parcel in) {
        nama = in.readString();
        tanggal = in.readString();
        waktu = in.readString();
        keterangan = in.readString();
    }

    public static final Creator<Absen> CREATOR = new Creator<Absen>() {
        @Override
        public Absen createFromParcel(Parcel in) {
            return new Absen(in);
        }

        @Override
        public Absen[] newArray(int size) {
            return new Absen[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Absen(String nama, String tanggal, String waktu, String keterangan) {
        this.nama = nama;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.keterangan = keterangan;
    }

    public Absen() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(tanggal);
        dest.writeString(waktu);
        dest.writeString(keterangan);
    }
}