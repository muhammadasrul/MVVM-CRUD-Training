package com.asrul.training.model;

import com.google.gson.annotations.SerializedName;

public class TrainingModel {
    @SerializedName("gambar_training")
    private String gambarTraining;

    @SerializedName("nama_training")
    private String namaTraining;

    @SerializedName("status_training")
    private String statusTraining;

    @SerializedName("kode_training")
    private String kodeTraining;

    @SerializedName("id_training")
    private String idTraining;

    @SerializedName("type_training")
    private String typeTraining;

    @SerializedName("jumlah_training")
    private String jumlahTraining;

    @SerializedName("harga_training")
    private String hargaTraining;

    @SerializedName("tanggal_training")
    private String tanggalTraining;

    public String getGambarTraining() {
        return gambarTraining;
    }

    public void setGambarTraining(String gambarTraining) {
        this.gambarTraining = gambarTraining;
    }

    public String getNamaTraining() {
        return namaTraining;
    }

    public void setNamaTraining(String namaTraining) {
        this.namaTraining = namaTraining;
    }

    public String getStatusTraining() {
        return statusTraining;
    }

    public void setStatusTraining(String statusTraining) {
        this.statusTraining = statusTraining;
    }

    public String getKodeTraining() {
        return kodeTraining;
    }

    public void setKodeTraining(String kodeTraining) {
        this.kodeTraining = kodeTraining;
    }

    public String getIdTraining() {
        return idTraining;
    }

    public void setIdTraining(String idTraining) {
        this.idTraining = idTraining;
    }

    public String getTypeTraining() {
        return typeTraining;
    }

    public void setTypeTraining(String typeTraining) {
        this.typeTraining = typeTraining;
    }

    public String getJumlahTraining() {
        return jumlahTraining;
    }

    public void setJumlahTraining(String jumlahTraining) {
        this.jumlahTraining = jumlahTraining;
    }

    public String getHargaTraining() {
        return hargaTraining;
    }

    public void setHargaTraining(String hargaTraining) {
        this.hargaTraining = hargaTraining;
    }

    public String getTanggalTraining() {
        return tanggalTraining;
    }

    public void setTanggalTraining(String tanggalTraining) {
        this.tanggalTraining = tanggalTraining;
    }
}
