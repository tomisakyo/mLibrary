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
    private String outletCategoryId;
    private String lastSessionId;
    private String name;
    private String contact;
    private String storageId;
    private String address;
    private String companyId;
    private String companyName;
    private String templateId;
    private long createdAt;
    private boolean isSettled;
    private ArrayList<String> wallets;

    private String walletId, walletQrisId, walletGopayId, walletOvoId;


    public Outlet(String outletId, String outletCategoryId, String lastSessionId, String name, String contact, String storageId, String address, String companyId, String companyName, String templateId, long createdAt, boolean isSettled) {
        this.outletId = outletId;
        this.outletCategoryId = outletCategoryId;
        this.lastSessionId = lastSessionId;
        this.name = name;
        this.contact = contact;
        this.storageId = storageId;
        this.address = address;
        this.companyId = companyId;
        this.companyName = companyName;
        this.templateId = templateId;
        this.createdAt = createdAt;
        this.isSettled = isSettled;
    }

    public Outlet(String outletId, String outletCategoryId, String lastSessionId, String name, String contact, String storageId, String address, String companyId, String companyName, String templateId, long createdAt, boolean isSettled, ArrayList<String> wallets, String walletId, String walletQrisId, String walletGopayId, String walletOvoId) {
        this.outletId = outletId;
        this.outletCategoryId = outletCategoryId;
        this.lastSessionId = lastSessionId;
        this.name = name;
        this.contact = contact;
        this.storageId = storageId;
        this.address = address;
        this.companyId = companyId;
        this.companyName = companyName;
        this.templateId = templateId;
        this.createdAt = createdAt;
        this.isSettled = isSettled;
        this.wallets = wallets;
        this.walletId = walletId;
        this.walletQrisId = walletQrisId;
        this.walletGopayId = walletGopayId;
        this.walletOvoId = walletOvoId;
    }

    public Outlet() {
        this.outletId = UUID.randomUUID().toString();
        this.outletCategoryId = "";
        this.lastSessionId = "";
        this.name = "";
        this.contact = "";
        this.storageId = "";
        this.address = "";
        this.companyId = "";
        this.companyName = "";
        this.templateId = "";
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.isSettled = false;
        this.wallets = new ArrayList<>();
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public void setWalletQrisId(String walletQrisId) {
        this.walletQrisId = walletQrisId;
    }

    public void setWalletGopayId(String walletGopayId) {
        this.walletGopayId = walletGopayId;
    }

    public void setWalletOvoId(String walletOvoId) {
        this.walletOvoId = walletOvoId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getWalletQrisId() {
        return walletQrisId;
    }

    public String getWalletGopayId() {
        return walletGopayId;
    }

    public String getWalletOvoId() {
        return walletOvoId;
    }

    public String getOutletId() {
        return outletId;
    }

    public void setOutletId(String outletId) {
        this.outletId = outletId;
    }

    public String getOutletCategoryId() {
        return outletCategoryId;
    }

    public void setOutletCategoryId(String outletCategoryId) {
        this.outletCategoryId = outletCategoryId;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public void setSettled(boolean settled) {
        isSettled = settled;
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
