package com.example.mylibrary.model;

import java.io.Serializable;

public class PaymentNonCash implements Serializable {
    private PaymentType paymentType;
    private double systemAmount;
    private double actualAmount;
    private String imageProofUrl;

    public PaymentNonCash(PaymentType paymentType, double systemAmount, double actualAmount, String imageProofUrl) {
        this.paymentType = paymentType;
        this.systemAmount = systemAmount;
        this.actualAmount = actualAmount;
        this.imageProofUrl = imageProofUrl;
    }

    public PaymentNonCash() {
        this.paymentType = null;
        this.systemAmount = 0.0;
        this.actualAmount = 0.0;
        this.imageProofUrl = "";
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getSystemAmount() {
        return systemAmount;
    }

    public void setSystemAmount(double systemAmount) {
        this.systemAmount = systemAmount;
    }

    public double getActualAmount() {
        return actualAmount;
    }

    public void setActualAmount(double actualAmount) {
        this.actualAmount = actualAmount;
    }

    public String getImageProofUrl() {
        return imageProofUrl;
    }

    public void setImageProofUrl(String imageProofUrl) {
        this.imageProofUrl = imageProofUrl;
    }
}
