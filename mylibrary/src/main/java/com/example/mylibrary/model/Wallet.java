package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Wallet implements Serializable {

    private String walletId;
    private String companyId;
    private String description;
    private String name;
    private int walletType;
    private String referenceId; // Can Be Empty. Example Reference = OutletId / KitchenId / "" (Empty)
    private boolean isDefault;
    private int priority;
    private String lastTransactionId;
    private ArrayList<String> tags;

    public final static int WALLET_MONEY_TYPE_CASH = 10; // DEF - PREDEFINE
    public final static int WALLET_MONEY_TYPE_QRIS = 20;
    public final static int WALLET_MONEY_TYPE_GOPAY = 30;
    public final static int WALLET_MONEY_TYPE_OVO = 40;

    public final static int WALLET_TYPE_OTHER = 400;
    public final static int WALLET_TYPE_COMPANY = 100;
    public final static int WALLET_TYPE_KITCHEN = 200;
    public final static int WALLET_TYPE_OUTLET = 300;
    public final static int WALLET_TYPE_USER = 500;

    private double balance;
    private int walletMoneyType;

    public Wallet() {
        this.walletId = "";
        this.name = "";
        this.companyId = "";
        this.description = "";
        this.walletType = -1;
        this.referenceId = "";
        this.isDefault = false;
        this.priority = -1;
        this.lastTransactionId = "";
        this.balance = 0.0;
        this.walletMoneyType = -1;
        this.tags = new ArrayList<>();
        this.priority = 0;
    }

    public Wallet(String walletId, String companyId, String description, String name, int walletType, String referenceId, boolean isDefault, String lastTransactionId, ArrayList<String> tags, int priority, double balance, int walletMoneyType) {
        this.walletId = walletId;
        this.companyId = companyId;
        this.description = description;
        this.name = name;
        this.walletType = walletType;
        this.referenceId = referenceId;
        this.isDefault = isDefault;
        this.lastTransactionId = lastTransactionId;
        this.tags = tags;
        this.priority = priority;
        this.balance = balance;
        this.walletMoneyType = walletMoneyType;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWalletType() {
        return walletType;
    }

    public void setWalletType(int walletType) {
        this.walletType = walletType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getLastTransactionId() {
        return lastTransactionId;
    }

    public void setLastTransactionId(String lastTransactionId) {
        this.lastTransactionId = lastTransactionId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getWalletMoneyType() {
        return walletMoneyType;
    }

    public void setWalletMoneyType(int walletMoneyType) {
        this.walletMoneyType = walletMoneyType;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
