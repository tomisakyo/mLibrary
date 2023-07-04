package com.example.mylibrary.model.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StockTransaction implements Serializable {
    private String transactionId;
    private long date;
    private int transactionType;
    private String referenceId; // used for Storage Reference in Transfer  // tidak ditampilkan
    //Untuk Transfer Out destinasi Storage, Transfer In Sumber Storage
    private String note;
    private ArrayList<StockTransactionItem> transactionStockItems;

    private int status;
    private Process process;
    private ArrayList<String> settledStockTransactions;

    private List<String> logs; //322392938932: Received by Tomi

    public static int STATUS_ONGOING = 100;
    public static int STATUS_COMPLETED = 200;

    public static int TRANSACTION_PURCHASE = 110;
    public static int TRANSACTION_SALES = 120;
    public static int TRANSACTION_TRANSFER_OUT = 130;
    public static int TRANSACTION_TRANSFER_OUT_REQUEST = 135;
    public static int TRANSACTION_TRANSFER_IN = 140;
    public static int TRANSACTION_TRANSFER_IN_REQUEST = 145;
    public static int TRANSACTION_OPNAME = 150;
    public static int TRANSACTION_ADD = 160;
    public static int TRANSACTION_PROCESS = 170;

    public StockTransaction(String transactionId, long date, int transactionType,
                            String referenceId, String note, ArrayList<StockTransactionItem> transactionStockItems) {
        this.transactionId = transactionId;
        this.date = date;
        this.transactionType = transactionType;
        this.referenceId = referenceId;
        this.note = note;
        this.transactionStockItems = transactionStockItems;
    }

    public StockTransaction() {
        this.transactionId = UUID.randomUUID().toString();
        this.date = 0L;
        this.transactionType = 0;
        this.referenceId = "";
        this.note = "";
        this.transactionStockItems = new ArrayList<>();
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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