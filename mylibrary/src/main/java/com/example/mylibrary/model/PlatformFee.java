package com.example.mylibrary.model;

import java.io.Serializable;

public class PlatformFee implements Serializable {

    private String platformName;
    private double platformFee;
    private boolean isFixFee;
    private boolean isCharged;

    public PlatformFee(String platformName, double platformFee, boolean isFixFee, boolean isCharged) {
        this.platformName = platformName;
        this.platformFee = platformFee;
        this.isFixFee = isFixFee;
        this.isCharged = isCharged;
    }

    public PlatformFee() {
        this.platformName = "";
        this.platformFee = 0;
        this.isFixFee = true;
        this.isCharged = true;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public double getPlatformFee() {
        return platformFee;
    }

    public void setPlatformFee(double platformFee) {
        this.platformFee = platformFee;
    }

    public boolean isFixFee() {
        return isFixFee;
    }

    public void setFixFee(boolean fixFee) {
        isFixFee = fixFee;
    }

    public boolean isCharged() {
        return isCharged;
    }

    public void setCharged(boolean charged) {
        isCharged = charged;
    }
}
