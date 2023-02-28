package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class StockTransaction implements Serializable {
    private String transactionId;
    private String storageId;
    private long date;
    private int transactionType;
    private String referenceId; // used for Storage Reference in Transfer  // tidak ditampilkan
    private String note;
    private ArrayList<StockTransactionItem> transactionStockItems;
    private boolean isConfirmed;
    private boolean isSettled;
    private boolean hasProblem;
    private boolean isChecked;
    private String checkedBy;
    private String user;
    private Process process;
    private ArrayList<String> settledStockTransactions;

    public static int TRANSACTION_PURCHASE = 110;
    public static int TRANSACTION_SALES = 120;
    public static int TRANSACTION_TRANSFER_OUT = 130;
    public static int TRANSACTION_TRANSFER_OUT_VOID = 135;
    public static int TRANSACTION_TRANSFER_IN = 140;
    public static int TRANSACTION_TRANSFER_IN_VOID = 145;
    public static int TRANSACTION_OPNAME = 150;
    public static int TRANSACTION_ADD = 160;
    public static int TRANSACTION_PROCESS = 170;
    public static int TRANSACTION_AUTO_WASTED = 180;

    public StockTransaction(String transactionId, String storageId, long date, int transactionType,
                            String referenceId, String note, ArrayList<StockTransactionItem> transactionStockItems,
                            boolean isConfirmed, boolean isSettled, boolean hasProblem, boolean isChecked,
                            String checkedBy, String user, Process process) {
        this.transactionId = transactionId;
        this.storageId = storageId;
        this.date = date;
        this.transactionType = transactionType;
        this.referenceId = referenceId;
        this.note = note;
        this.transactionStockItems = transactionStockItems;
        this.isConfirmed = isConfirmed;
        this.isSettled = isSettled;
        this.hasProblem = hasProblem;
        this.isChecked = isChecked;
        this.checkedBy = checkedBy;
        this.user=user;
        this.settledStockTransactions=null;
    }

    public StockTransaction() {
        this.transactionId = UUID.randomUUID().toString();
        this.storageId = "";
        this.date = 0L;
        this.transactionType = 0;
        this.referenceId = "";
        this.note = "";
        this.transactionStockItems = new ArrayList<>();
        this.isConfirmed = false;
        this.isSettled = false;
        this.hasProblem = false;
        this.isChecked = false;
        this.checkedBy = "";
        this.user = "";
        this.process = null;
        this.settledStockTransactions=null;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(int transactionType) {
        this.transactionType = transactionType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ArrayList<StockTransactionItem> getTransactionStockItems() {
        return transactionStockItems;
    }

    public void setTransactionStockItems(ArrayList<StockTransactionItem> transactionStockItems) {
        this.transactionStockItems = transactionStockItems;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public void setSettled(boolean settled) {
        isSettled = settled;
    }

    public boolean isHasProblem() {
        return hasProblem;
    }

    public void setHasProblem(boolean hasProblem) {
        this.hasProblem = hasProblem;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getCheckedBy() {
        return checkedBy;
    }

    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public ArrayList<String> getSettledStockTransactions() {
        return settledStockTransactions;
    }

    public void setSettledStockTransactions(ArrayList<String> settledStockTransactions) {
        this.settledStockTransactions = settledStockTransactions;
    }
}