package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class Stock implements Serializable {
    private String stockId;
    private int minimumStockLevel;
    private String minimumStockUnit1;
    private String minimumStockUnit2;
    private String minimumStockUnit3;
    private String name;
    private String categoryId;
    private int priority;
    private int quantity;
    private String unit1;
    private int unit1ValueOverUnit2;
    private String unit2;
    private int unit2ValueOverUnit3;
    private String unit3;
    private boolean isLocked;
    private boolean isAutoWasted;
    private boolean isEnabled;

    public Stock(String stockId, int minimumStockLevel, String minimumStockUnit1, String minimumStockUnit2, String minimumStockUnit3, String name,
                 String categoryId, int priority, int quantity, String unit1, int unit1ValueOverUnit2, String unit2,
                 int unit2ValueOverUnit3, String unit3, boolean isLocked, boolean isAutoWasted, boolean isEnabled) {
        this.stockId = stockId;
        this.minimumStockLevel = minimumStockLevel;
        this.minimumStockUnit1 = minimumStockUnit1;
        this.minimumStockUnit2 = minimumStockUnit2;
        this.minimumStockUnit3 = minimumStockUnit3;
        this.name = name;
        this.categoryId = categoryId;
        this.priority = priority;
        this.quantity = quantity;
        this.unit1 = unit1;
        this.unit1ValueOverUnit2 = unit1ValueOverUnit2;
        this.unit2 = unit2;
        this.unit2ValueOverUnit3 = unit2ValueOverUnit3;
        this.unit3 = unit3;
        this.isLocked = isLocked;
        this.isAutoWasted = isAutoWasted;
        this.isEnabled = isEnabled;
    }

    public Stock(String name) {
        this.stockId = UUID.randomUUID().toString();
        this.minimumStockLevel = -1;
        this.minimumStockUnit1 = "";
        this.minimumStockUnit2 = "";
        this.minimumStockUnit3 = "";
        this.name = name;
        this.categoryId = "";
        this.priority = 0;
        this.quantity = 0;
        this.isLocked = true;
        this.isAutoWasted = false;
        this.isEnabled = true;
        this.unit1 = "";
        this.unit2 = "";
        this.unit3 = "";
        this.unit1ValueOverUnit2 = 0;
        this.unit2ValueOverUnit3 = 0;
    }

    public Stock() {
        this.stockId = UUID.randomUUID().toString();
        this.minimumStockLevel = -1;
        this.minimumStockUnit1 = "";
        this.minimumStockUnit2 = "";
        this.minimumStockUnit3 = "";
        this.name = "";
        this.categoryId = "";
        this.priority = 0;
        this.quantity = 0;
        this.isLocked = true;
        this.isAutoWasted = false;
        this.isEnabled = true;
        this.unit1 = "";
        this.unit2 = "";
        this.unit3 = "";
        this.unit1ValueOverUnit2 = 0;
        this.unit2ValueOverUnit3 = 0;
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

    public String getMinimumStockUnit1() {
        return minimumStockUnit1;
    }

    public void setMinimumStockUnit1(String minimumStockUnit1) {
        this.minimumStockUnit1 = minimumStockUnit1;
    }

    public String getMinimumStockUnit2() {
        return minimumStockUnit2;
    }

    public void setMinimumStockUnit2(String minimumStockUnit2) {
        this.minimumStockUnit2 = minimumStockUnit2;
    }

    public String getMinimumStockUnit3() {
        return minimumStockUnit3;
    }

    public void setMinimumStockUnit3(String minimumStockUnit3) {
        this.minimumStockUnit3 = minimumStockUnit3;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isAutoWasted() {
        return isAutoWasted;
    }

    public void setAutoWasted(boolean autoWasted) {
        isAutoWasted = autoWasted;
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
