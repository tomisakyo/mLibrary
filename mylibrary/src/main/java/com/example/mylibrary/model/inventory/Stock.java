package com.example.mylibrary.model.inventory;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class Stock implements Serializable {
    private String stockId;
    private int minimumStockLevel;
    private String name;
    private String categoryId;
    private int priority;
    private String unit1;
    private int unit1ValueOverUnit2;
    private String unit2;
    private int unit2ValueOverUnit3;
    private String unit3;
    private boolean isEnabled;

    private String tags;

    public Stock(String stockId, int minimumStockLevel, String name,
                 String categoryId, int priority, String unit1, int unit1ValueOverUnit2, String unit2,
                 int unit2ValueOverUnit3, String unit3, boolean isEnabled, String tags) {
        this.stockId = stockId;
        this.minimumStockLevel = minimumStockLevel;
        this.name = name;
        this.categoryId = categoryId;
        this.priority = priority;
        this.unit1 = unit1;
        this.unit1ValueOverUnit2 = unit1ValueOverUnit2;
        this.unit2 = unit2;
        this.unit2ValueOverUnit3 = unit2ValueOverUnit3;
        this.unit3 = unit3;
        this.isEnabled = isEnabled;
        this.tags=tags;
    }

    public Stock(String name) {
        this.stockId = UUID.randomUUID().toString();
        this.minimumStockLevel = -1;
        this.name = name;
        this.categoryId = "";
        this.priority = 0;
        this.isEnabled = true;
        this.unit1 = "";
        this.unit2 = "";
        this.unit3 = "";
        this.unit1ValueOverUnit2 = 0;
        this.unit2ValueOverUnit3 = 0;
        this.tags ="";
    }

    public Stock() {
        this.stockId = UUID.randomUUID().toString();
        this.minimumStockLevel = -1;
        this.name = "";
        this.categoryId = "";
        this.priority = 0;
        this.isEnabled = true;
        this.unit1 = "";
        this.unit2 = "";
        this.unit3 = "";
        this.unit1ValueOverUnit2 = 0;
        this.unit2ValueOverUnit3 = 0;
        this.tags ="";
    }

    public Boolean isHasUnit2(){
        if (!getUnit1().trim().equalsIgnoreCase("") && !getUnit2().trim().equalsIgnoreCase("") &&
                getUnit1ValueOverUnit2() != 0) {
            return true;
        }
        return false;
    }

    public Boolean isHasUnit3(){
        if (!getUnit2().trim().equalsIgnoreCase("") && !getUnit3().trim().equalsIgnoreCase("") &&
                getUnit2ValueOverUnit3() != 0) {
            return true;
        }
        return false;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public int getMinimumStockLevel() {
        return minimumStockLevel;
    }

    public void setMinimumStockLevel(int minimumStockLevel) {
        this.minimumStockLevel = minimumStockLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public int getUnit1ValueOverUnit2() {
        return unit1ValueOverUnit2;
    }

    public void setUnit1ValueOverUnit2(int unit1ValueOverUnit2) {
        this.unit1ValueOverUnit2 = unit1ValueOverUnit2;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    public int getUnit2ValueOverUnit3() {
        return unit2ValueOverUnit3;
    }

    public void setUnit2ValueOverUnit3(int unit2ValueOverUnit3) {
        this.unit2ValueOverUnit3 = unit2ValueOverUnit3;
    }

    public String getUnit3() {
        return unit3;
    }

    public void setUnit3(String unit3) {
        this.unit3 = unit3;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    //    @Override
//    public String toString() {
//        return getStockId() + ":" + getName();
//    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof Stock) {
            Stock stock = (Stock) obj;
            return getStockId().equalsIgnoreCase(stock.getStockId());
        }
        if(obj instanceof String){
            String id = (String) obj;
            return getStockId().equalsIgnoreCase(id);
        }
        return false;
    }
}
