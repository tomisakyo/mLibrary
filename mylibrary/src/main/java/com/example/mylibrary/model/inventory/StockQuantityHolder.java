package com.example.mylibrary.model.inventory;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class StockQuantityHolder implements Serializable {
    private String stockId;
    private int quantity;
    private int minimumStockLevel;

    private boolean hasBeenAlerted;

    public StockQuantityHolder(String stockId, int quantity, int minimumStockLevel) {
        this.stockId = stockId;
        this.quantity = quantity;
        this.minimumStockLevel = minimumStockLevel;
        this.hasBeenAlerted = false;
    }

    public StockQuantityHolder() {
        this.stockId = "";
        this.quantity = -1;
        this.minimumStockLevel = -1;
        this.hasBeenAlerted = false;
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

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public boolean isHasBeenAlerted() {
        return hasBeenAlerted;
    }

    public void setHasBeenAlerted(boolean hasBeenAlerted) {
        this.hasBeenAlerted = hasBeenAlerted;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof String) {
            return stockId.equalsIgnoreCase((String) obj);
        } else if (obj instanceof StockQuantityHolder) {
            StockQuantityHolder stockQuantityHolder = (StockQuantityHolder) obj;
            return stockId.equalsIgnoreCase(stockQuantityHolder.stockId);
        } else {
            return false;
        }
    }
}
