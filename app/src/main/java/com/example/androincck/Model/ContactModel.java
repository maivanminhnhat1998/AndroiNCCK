package com.example.androincck.Model;

public class ContactModel {
    private int Id;
    private String TenMH;
    private String MaMH;
    private int TinhChi;
    private String Description;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenMH() {
        return TenMH;
    }

    public void setTenMH(String tenMH) {
        TenMH = tenMH;
    }

    public String getMaMH() {
        return MaMH;
    }

    public void setMaMH(String maMH) {
        MaMH = maMH;
    }

    public int getTinhChi() {
        return TinhChi;
    }

    public void setTinhChi(int tinhChi) {
        TinhChi = tinhChi;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
