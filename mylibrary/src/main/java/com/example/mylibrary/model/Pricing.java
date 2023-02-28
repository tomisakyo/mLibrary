package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Pricing implements Serializable {
    private String orderTypeId;
    private double price;

    public Pricing(String orderTypeId, double price) {
        this.orderTypeId = orderTypeId;
        this.price = price;
    }

    public Pricing() {
        this.orderTypeId = "";
        this.price = 0;
    }

    public String getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Pricing) {
            Pricing pricing = (Pricing) obj;
            return getOrderTypeId().equalsIgnoreCase(pricing.getOrderTypeId());
        }
        if (obj instanceof String) {
            String pricingId = (String) obj;
            return getOrderTypeId().equalsIgnoreCase(pricingId);
        }
        return false;
    }
}
