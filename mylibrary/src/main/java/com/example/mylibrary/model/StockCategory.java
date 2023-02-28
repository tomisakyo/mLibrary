package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class StockCategory implements Serializable {
    private String stockCategoryId;
    private String Name;
    private String Description;

    public StockCategory(String stockCategoryId, String name, String description) {
        this.stockCategoryId = stockCategoryId;
        Name = name;
        Description = description;
    }

    public StockCategory(String name) {
        this.stockCategoryId = UUID.randomUUID().toString();
        Name = name;
        Description = "";
    }

    public StockCategory() {
        this.stockCategoryId = UUID.randomUUID().toString();
        Name = "";
        Description = "";
    }

    public String getStockCategoryId() {
        return stockCategoryId;
    }

    public void setStockCategoryId(String stockCategoryId) {
        this.stockCategoryId = stockCategoryId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof StockCategory) {
            StockCategory stockCategory = (StockCategory) obj;
            return getStockCategoryId().equalsIgnoreCase(stockCategory.getStockCategoryId());
        }
        if(obj instanceof String){
            String id = (String) obj;
            return getStockCategoryId().equalsIgnoreCase(id);
        }
        return false;
    }

    @Override
    public String toString() {
        return getName();
    }
}
