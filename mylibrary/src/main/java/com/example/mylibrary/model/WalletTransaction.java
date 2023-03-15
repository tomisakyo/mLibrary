package com.example.mylibrary.model;

import java.io.Serializable;

public class WalletTransaction implements Serializable {
    private String walletTransactionId;
    private int transactionType;
    private double date;
    private double confirmedDate;
    private boolean isConfirmed;
    private String referenceId;
    //Sales: settelement ID
    //TransferIn walletSender
    //TransferOut wallet receiver
    //Opname: Settelement
    private String userId;
    private String userName;
    private String previousTransactionId;
    private double amount;
    private double balance;
    private String note;
    private String walletId; // Fungsi??

    public static int WALLET_TRANSACTION_TYPE_ADD = 100;
    public static int WALLET_TRANSACTION_TYPE_TRANSFER_IN = 200;
    public static int WALLET_TRANSACTION_TYPE_TRANSFER_OUT = 300;
    public static int WALLET_TRANSACTION_TYPE_SALES = 400;
    public static int WALLET_TRANSACTION_TYPE_EXPENSE = 500;
    public static int WALLET_TRANSACTION_TYPE_WITHDRAW = 600;
    public static int WALLET_TRANSACTION_TYPE_OPNAME = 700;


    public WalletTransaction() {
        this.walletTransactionId = "";
        this.transactionType = -1;
        this.date = -1;
        this.confirmedDate = -1;
        this.isConfirmed = false;
        this.referenceId = "";
        this.userId = "";
        this.userName = "";
        this.previousTransactionId = "";
        this.amount = 0;
        this.balance = 0;
        this.note = "";
        this.walletId = "";
    }

    public String getWalletTransactionId() {
        return walletTransactionId;
    }

    public void setWalletTransactionId(String walletTransactionId) {
        this.walletTransactionId = walletTransactionId;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public double getDate() {
        return date;
    }

    public void setDate(double date) {
        this.date = date;
    }

    public double getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(double confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPreviousTransactionId() {
        return previousTransactionId;
    }

    public void setPreviousTransactionId(String previousTransactionId) {
        this.previousTransactionId = previousTransactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }
}
