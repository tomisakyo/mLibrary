package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by tomis on 8/20/2017.
 */

public class PrinterHolder implements Serializable {

    private static final long serialVersionUID = 1L;
    private String UID;
    private String name;
    private String brand;
    private String connection;

    public PrinterHolder(String name, String connection) {
        this.name = name;
        this.connection = connection;
    }

    public PrinterHolder(){
        this.UID = UUID.randomUUID().toString();
        this.name = "";
        this.brand = "";
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


    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public boolean equals(Object obj) {
       PrinterHolder prt = (PrinterHolder) obj;
        return prt.getUID().equalsIgnoreCase(((PrinterHolder) obj).getUID());
    }

    @Override
    public String toString() {
        return getName();
    }
}
