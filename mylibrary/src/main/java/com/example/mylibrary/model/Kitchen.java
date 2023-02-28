package com.example.mylibrary.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Kitchen implements Serializable {
    private String kitchenId;
    private String companyId;
    private String storageId;
    private String name;
    private String address;
    private String contact;
    private ArrayList<String> wallets;

    public Kitchen(String kitchenId, String companyId,String storageId, String name, String address, String contact) {
        this.kitchenId = kitchenId;
        this.companyId = companyId;
        this.storageId =storageId;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public Kitchen() {
        this.kitchenId = "";
        this.companyId = "";
        this.storageId ="";
        this.name = "";
        this.address = "";
        this.contact = "";
        this.wallets = new ArrayList<>();
    }

    public String getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(String kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ArrayList<String> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<String> wallets) {
        this.wallets = wallets;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
