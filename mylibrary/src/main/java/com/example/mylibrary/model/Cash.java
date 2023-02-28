package com.example.mylibrary.model;

import java.io.Serializable;

public class Cash implements Serializable {
    private long date;
    private String note;
    private boolean isIn;
    private double amount;

    public Cash(long date, String note, boolean isIn, double amount) {
        this.date = date;
        this.note = note;
        this.isIn = isIn;
        this.amount = amount;
    }

    public Cash() {
        this.date = 0L;
        this.note = "";
        this.isIn = false;
        this.amount = 0.0;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isIn() {
        return isIn;
    }

    public void setIn(boolean in) {
        isIn = in;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
