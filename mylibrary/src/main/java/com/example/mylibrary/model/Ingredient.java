package com.example.mylibrary.model;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;

    private String stockId;
    private int quantity;

    public Ingredient(String stockId, int quantity) {
        this.stockId = stockId;
        this.quantity = quantity;
    }

    public Ingredient() {
        this.stockId = "";
        this.quantity = 0;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
