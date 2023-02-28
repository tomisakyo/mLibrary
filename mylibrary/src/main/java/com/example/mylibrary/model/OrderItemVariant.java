package com.example.mylibrary.model;

import java.io.Serializable;

public class OrderItemVariant implements Serializable {
    private String variantId;
    private String variantName;
    private String variantItemId;
    private String variantItemName;
    private double variantItemPrice;

    public OrderItemVariant(String variantId, String variantName, String variantItemId,
                            String variantItemName, double variantItemPrice) {
        this.variantId = variantId;
        this.variantName = variantName;
        this.variantItemId = variantItemId;
        this.variantItemName = variantItemName;
        this.variantItemPrice = variantItemPrice;
    }

    public OrderItemVariant() {
        this.variantId = "";
        this.variantName = "";
        this.variantItemId = "";
        this.variantItemName = "";
        this.variantItemPrice = 0;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getVariantItemId() {
        return variantItemId;
    }

    public void setVariantItemId(String variantItemId) {
        this.variantItemId = variantItemId;
    }

    public String getVariantItemName() {
        return variantItemName;
    }

    public void setVariantItemName(String variantItemName) {
        this.variantItemName = variantItemName;
    }

    public double getVariantItemPrice() {
        return variantItemPrice;
    }

    public void setVariantItemPrice(double variantItemPrice) {
        this.variantItemPrice = variantItemPrice;
    }
}
