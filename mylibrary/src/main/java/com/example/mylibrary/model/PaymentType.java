package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class PaymentType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String paymentTypeId; //auto generate
    private String paymentName;
    private double fee;
    private boolean isFixFee;
    private boolean isCharged;
    private boolean isCash;
    private String walletId; // nullable (choose from dialog)

    public static int PAYMENT_TYPE_CASH = 91;
    public static int PAYMENT_TYPE_QRIS = 92;
    public static int PAYMENT_TYPE_GOPAY = 100;
    public static int PAYMENT_TYPE_OVO = 200; // grab

    public PaymentType(String paymentName, double fee, boolean isFixFee, boolean isCharged, boolean isCash, String walletId) {
        this.paymentTypeId = UUID.randomUUID().toString();
        this.paymentName = paymentName;
        this.fee = fee;
        this.isFixFee= isFixFee;
        this.isCharged = isCharged;
        this.isCash = isCash;
        this.walletId = walletId;
    }
    public PaymentType(String paymentName, double fee, boolean isFixFee, boolean isCharged, boolean isCash) {
        this.paymentTypeId = UUID.randomUUID().toString();
        this.paymentName = paymentName;
        this.fee = fee;
        this.isFixFee = isFixFee;
        this.isCharged = isCharged;
        this.isCash = isCash;
        this.walletId = "";
    }

    public PaymentType(String paymentName) {
        this.paymentTypeId = UUID.randomUUID().toString();
        this.paymentName = paymentName;
        this.fee = 0;
        this.isFixFee = false;
        this.isCharged = false;
        this.isCash = false;
        this.walletId = "";
    }

    public PaymentType() {
        this.paymentTypeId = UUID.randomUUID().toString();
        this.paymentName = "";
        this.fee = 0;
        this.isFixFee = false;
        this.isCharged = false;
        this.isCash = false;
        this.walletId = "";
    }



    public void setPaymentType(PaymentType paymentType) {
        this.paymentName = paymentType.getPaymentName();
        this.fee = paymentType.getFee();
        this.isFixFee = paymentType.isFixFee();
        this.isCharged = paymentType.isCharged();
        this.isCash = paymentType.isCash();
        this.walletId = paymentType.getWalletId();
    }

    public void setPaymentType(String paymentName, double fee, boolean isFixFee,  boolean isCharged, boolean isCash) {
        this.paymentName = paymentName;
        this.fee = fee;
        this.isFixFee = isFixFee;
        this.isCharged = isCharged;
        this.isCash = isCash;
        this.walletId = "";
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double feePercent) {
        this.fee = feePercent;
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

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof PaymentType) {
            PaymentType paymentType = (PaymentType) obj;
            return getPaymentTypeId().equalsIgnoreCase(paymentType.getPaymentTypeId());
        }
        if(obj instanceof String){
            String paymentTypeId = (String) obj;
            return getPaymentTypeId().equalsIgnoreCase(paymentTypeId);
        }
        return false;
    }

    @Override
    public String toString() {
        return paymentName;
    }
}
