package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by tomis on 8/20/2017.
 */

public class Printer implements Serializable {
    private static final long serialVersionUID = 1L;
    public static String TMT82_88="TM-T82/88";
    public static String TM_U220="TM-U220";
    public static String BLUETOOTH="Portable Bluetooth";

    private String UID;
    private String name;
    private String brand;
    private String connection;

    public Printer(String name) {
        this.UID = UUID.randomUUID().toString();
        this.name = name;
        this.brand = "";
        this.connection = "";
    }

    public Printer(String name, String connection, String brand) {
        this.UID = UUID.randomUUID().toString();
        this.name = name;
        this.brand = brand;
        this.connection = connection;
    }

    public Printer(){
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
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof Printer) {
            Printer printer = (Printer) obj;
            return getUID().equalsIgnoreCase(printer.getUID());
        }
        if(obj instanceof String){
            String uid = (String) obj;
            return getUID().equalsIgnoreCase(uid);
        }
        return false;
    }

    @Override
    public String toString() {
        return getName();
    }
}
