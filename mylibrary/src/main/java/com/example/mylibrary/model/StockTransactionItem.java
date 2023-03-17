package com.example.mylibrary.model;

import java.io.Serializable;

public class StockTransactionItem implements Serializable {
    private String stockId;
    private int quantityActual;
    private int quantitySystem;
    private String note;

    public StockTransactionItem(String stockId, int quantityActual, int quantitySystem, String note) {
        this.stockId = stockId;
        this.quantityActual = quantityActual;
        this.quantitySystem = quantitySystem;
        this.note = note;
    }

    public StockTransactionItem() {
        this.stockId = "";
        this.quantityActual = 0;
        this.quantitySystem = 0;
        this.note = "";
    }

    public StockTransactionItem(Ingredient ingredient, int portion) {
        this.stockId = ingredient.getStockId();
        this.quantityActual = 0;
        this.quantitySystem = ingredient.getQuantity()*portion;
        this.note = "";
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getQuantityActual() {
        return quantityActual;
    }

    public void setQuantityActual(int quantityActual) {
        this.quantityActual = quantityActual;
    }

    public int getQuantitySystem() {
        return quantitySystem;
    }

    public void setQuantitySystem(int quantitySystem) {
        this.quantitySystem = quantitySystem;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
