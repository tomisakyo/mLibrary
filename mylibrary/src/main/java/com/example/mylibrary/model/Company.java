package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company implements Serializable {
    private String companyId;
    private String name;
    private String contact;
    private String ownerName;
    private String email;

    private String walletId;

    private boolean isEnabled;
    private long createdAt;

    private ArrayList<String> storageList; // storageId
    private ArrayList<String> wallets;
    private List<Attendance> attendanceList;


    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public Company() {
        this.companyId = "";
        this.name = "";
        this.storageList = null;
        this.contact = "";
        this.ownerName = "";
        this.email = "";
        this.isEnabled = false;
        this.createdAt = 0L;
        this.wallets = new ArrayList<>();
    }

    public List<Attendance> getAttendanceList() {
        return attendanceList;
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

    public ArrayList<String> getStorageList() {
        return storageList;
    }

    public void setStorageList(ArrayList<String> storageList) {
        this.storageList = storageList;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return ownerName;
    }

    public void setAddress(String ownerName) {
        this.ownerName = ownerName;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public static String getEmail() {
        return "Email";
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<String> getWallets() {
        return wallets;
    }

    public void setWallets(ArrayList<String> wallets) {
        this.wallets = wallets;
    }
}