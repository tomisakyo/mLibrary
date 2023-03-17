package com.example.mylibrary.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Storage implements Serializable {
    private String storageId;
    private String companyId;
    private String name;
    private String address;
    private String contact;
    private String lastTransactionId;
    private ArrayList<StockQuantityHolder> stockQuantityHolders;

    private String tags;

    public Storage(String storageId, String companyId, String name, String address, String contact, String lastTransactionId, ArrayList<StockQuantityHolder> stockQuantityHolders, String tags) {
        this.storageId = storageId;
        this.companyId = companyId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.lastTransactionId = lastTransactionId;
        this.stockQuantityHolders = stockQuantityHolders;
        this.tags=tags;
    }

    public Storage() {
        this.storageId = UUID.randomUUID().toString();
        this.companyId = "";
        this.name = "";
        this.address = "";
        this.contact = "";
        this.lastTransactionId = "";
        this.stockQuantityHolders = new ArrayList<>();
        this.tags="";
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
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

    public String getLastTransactionId() {
        return lastTransactionId;
    }

    public void setLastTransactionId(String lastTransactionId) {
        this.lastTransactionId = lastTransactionId;
    }

    public ArrayList<StockQuantityHolder> getStockQuantityHolders() {
        return stockQuantityHolders;
    }

    public void setStockQuantityHolders(ArrayList<StockQuantityHolder> stockQuantityHolders) {
        this.stockQuantityHolders = stockQuantityHolders;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        if (getStorageId().length() > 8) {
            return getStorageId().substring(0, 7) + ":" + getName();
        } else {
            return getName();
        }
    }
}

