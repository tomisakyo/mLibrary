package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class OrderType implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderTypeID;
    private String orderTypeName;
    private String Init;
    private Boolean isEnabled;
    private int priority;
    private ArrayList<String> paymentType;
    private ArrayList<PlatformFee> platformFees;


    public OrderType(String orderTypeID, int priority, String orderTypeName, ArrayList<PlatformFee> platformFees, String init, Boolean isEnabled, ArrayList<String> paymentType) {
        this.orderTypeID = orderTypeID;
        this.priority = priority;
        this.orderTypeName = orderTypeName;
        this.isEnabled = isEnabled;
        this.platformFees = platformFees;
        this.Init = init;
        this.paymentType = paymentType;
    }

    public OrderType(String name) {
        this.orderTypeID = UUID.randomUUID().toString();
        this.Init = "";
        this.priority=0;
        this.orderTypeName = name;
        this.isEnabled = true;
        this.platformFees = new ArrayList<>();
        this.paymentType = new ArrayList<>();
    }

    public OrderType() {
        this.orderTypeID = UUID.randomUUID().toString();
        this.Init = "";
        this.priority=0;
        this.orderTypeName = "";
        this.isEnabled = true;
        this.platformFees = new ArrayList<>();
        this.paymentType = new ArrayList<>();
    }

    public ArrayList<String> getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(ArrayList<String> paymentType) {
        this.paymentType = paymentType;
    }

    public void setInit(String init) {
        Init = init;
    }

    public ArrayList<PlatformFee> getPlatformFees() {
        return platformFees;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getOrderTypeID() {
        return orderTypeID;
    }

    public void setOrderTypeID(String orderTypeID) {
        this.orderTypeID = orderTypeID;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public String getInit() {
        return Init;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    @Override
    public String toString() {
        return orderTypeName;
    }

    public OrderType get(int position) {
        return null;
    }

    public int size() {
        return 0;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof OrderType) {
            OrderType orderType = (OrderType) obj;
            return getOrderTypeID().equalsIgnoreCase(orderType.getOrderTypeID());
        }
        if (obj instanceof String) {
            String orderTypeId = (String) obj;
            return getOrderTypeID().equalsIgnoreCase(orderTypeId);
        }
        return false;
    }
}
