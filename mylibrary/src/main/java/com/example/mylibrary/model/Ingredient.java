package com.example.mylibrary.model;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1L;

    private String stockId;
    private String stockName;
    private int quantity;

    public Ingredient(String stockId, String stockName, int quantity) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.quantity = quantity;
    }

    public Ingredient() {
        this.stockId = "";
        this.stockName = "";
        this.quantity = 0;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
