package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class StockQuantityHolder implements Serializable {
    private String stockId;
    private String stockName;
    private int quantity;
    private int minimumStockLevel;
    private boolean isLocked;

    public StockQuantityHolder(String stockId, String stockName, int quantity, int minimumStockLevel, boolean isLocked) {
        this.stockId = stockId;
        this.stockName = stockName;
        this.quantity = quantity;
        this.minimumStockLevel = minimumStockLevel;
        this.isLocked = isLocked;
    }

    public StockQuantityHolder() {
        this.stockId = "";
        this.stockName = "";
        this.quantity = -1;
        this.minimumStockLevel = -1;
        this.isLocked = false;
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

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
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
