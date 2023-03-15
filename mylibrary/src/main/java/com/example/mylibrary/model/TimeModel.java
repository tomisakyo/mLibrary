package com.example.mylibrary.model;

public class TimeModel {

    private int tahun, bulan, hari, jam, menit, detik;
    private boolean isAM;

    public TimeModel() {}

    public TimeModel(int tahun, int bulan, int hari, int jam, int menit, int detik, boolean isAM) {
        this.tahun = tahun;
        this.bulan = bulan;
        this.hari = hari;
        this.jam = jam;
        this.menit = menit;
        this.detik = detik;
        this.isAM = isAM;
    }

    public boolean isAM() {
        return isAM;
    }

    public int getBulan() {
        return bulan;
    }

    public int getTahun() {
        return tahun;
    }
    public int getHari() {
        return hari;
    }

    public int getJam() {
        return jam;
    }

    public int getMenit() {
        return menit;
    }

    public int getDetik() {
        return detik;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }

    public void setHari(int hari) {
        this.hari = hari;
    }

    public void setJam(int jam) {
        this.jam = jam;
    }

    public void setMenit(int menit) {
        this.menit = menit;
    }

    public void setDetik(int detik) {
        this.detik = detik;
    }

    public void setAM(boolean AM) {
        isAM = AM;
    }
}
