package com.example.mylibrary.model;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.UUID;

public class OrderingPrinter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Expose
    private String UID;
    @Expose
    private String name;
    @Expose
    private String brand;
    @Expose
    private int mode;
    @Expose
    private String connection;

    public OrderingPrinter(String name, String connection) {
        this.name = name;
        this.connection = connection;
    }

    public OrderingPrinter() {
        this.UID = UUID.randomUUID().toString();
        this.name = "";
        this.brand = "";
        this.mode = 0;
        this.connection = "";
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public boolean equals(Object obj) {
        OrderingPrinter prt = (OrderingPrinter) obj;
        return prt.getConnection().equalsIgnoreCase(((OrderingPrinter) obj).getName());
    }

    @Override
    public String toString() {
        return getName();
    }
}
