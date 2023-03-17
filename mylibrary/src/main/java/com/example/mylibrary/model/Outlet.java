package com.example.mylibrary.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class Outlet implements Serializable {
    private static final long serialVersionUID = 1L;

    private String outletId;
    private String lastSessionId;
    private String name;
    private String contact;
    private String storageId;
    private String address;
    private String companyId;
    private long createdAt;

    private ArrayList<String> wallets;

    public Outlet(String outletId, String lastSessionId, String name, String contact, String storageId, String address, String companyId, long createdAt, ArrayList<String> wallets) {
        this.outletId = outletId;
        this.lastSessionId = lastSessionId;
        this.name = name;
        this.contact = contact;
        this.storageId = storageId;
        this.address = address;
        this.companyId = companyId;
        this.createdAt = createdAt;
        this.wallets = wallets;
    }
    public Outlet() {
        this.outletId = UUID.randomUUID().toString();
        this.lastSessionId = "";
        this.name = "";
        this.contact = "";
        this.storageId = "";
        this.address = "";
        this.companyId = "";
        this.createdAt = 0;
        this.wallets = new ArrayList<>();
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getLastSessionId() {
        return lastSessionId;
    }

    public void setLastSessionId(String lastSessionId) {
        this.lastSessionId = lastSessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Outlet) {
            Outlet outlet= (Outlet) obj;
            return getOutletId().equalsIgnoreCase(outlet.getOutletId());
        }
        if (obj instanceof String) {
            String outletId= (String) obj;
            return getOutletId().equalsIgnoreCase(outletId);
        }
        return false;
    }
}
