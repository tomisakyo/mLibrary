package com.example.mylibrary.model;

import androidx.annotation.Nullable;

public class SettlementPayment {
    private String paymentTypeId;
    private double systemAmount;
    private double actualAmount;
    private String imageProofUrl;

    public SettlementPayment(String paymentTypeId, double systemAmount, double actualAmount, String imageProofUrl) {
        this.paymentTypeId = paymentTypeId;
        this.systemAmount = systemAmount;
        this.actualAmount = actualAmount;
        this.imageProofUrl = imageProofUrl;
    }

    public SettlementPayment() {
        this.paymentTypeId = "";
        this.systemAmount = 0;
        this.actualAmount = 0;
        this.imageProofUrl = "";
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
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

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof SettlementPayment) {
            SettlementPayment settlementPayment = (SettlementPayment) obj;
            return getPaymentTypeId().equalsIgnoreCase(settlementPayment.getPaymentTypeId());
        }
        if (obj instanceof String) {
            String paymentTypeId = (String) obj;
            return getPaymentTypeId().equalsIgnoreCase(paymentTypeId);
        }
        return false;
    }
}
