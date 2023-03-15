package com.example.mylibrary.model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Storage implements Serializable {
    private String storageId;
    private String companyId;
    private String kitchenId;
    private String name;
    private String address;
    private String contact;
    private String lastTransactionId;
    private int storageType;
    private ArrayList<StockQuantityHolder> stockQuantityHolders;
    private ArrayList<String> recipesHolder; // String of Recipe Id

    public static int TYPE_COMPANY = 100;
    public static int TYPE_KITCHEN = 200;
    public static int TYPE_OUTLET = 300;

    public Storage(String storageId, String companyId, String kitchenId, String name, String address, String contact, String lastTransactionId, int storageType, ArrayList<StockQuantityHolder> stockQuantityHolders, ArrayList<String> recipesHolder) {
        this.storageId = storageId;
        this.companyId = companyId;
        this.kitchenId = kitchenId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.lastTransactionId = lastTransactionId;
        this.storageType = storageType;
        this.stockQuantityHolders = stockQuantityHolders;
        this.recipesHolder = recipesHolder;
    }

    public Storage() {
        this.storageId = UUID.randomUUID().toString();
        this.companyId = "";
        this.kitchenId = "";
        this.name = "";
        this.address = "";
        this.contact = "";
        this.lastTransactionId = "";
        this.storageType = -1;
        this.stockQuantityHolders = new ArrayList<>();
        this.recipesHolder = new ArrayList<>();
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getKitchenId() {
        return kitchenId;
    }

    public void setKitchenId(String kitchenId) {
        this.kitchenId = kitchenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLastTransactionId() {
        return lastTransactionId;
    }

    public void setLastTransactionId(String lastTransactionId) {
        this.lastTransactionId = lastTransactionId;
    }

    public ArrayList<String> getRecipesHolder() {
        return recipesHolder;
    }

    public void setRecipesHolder(ArrayList<String> recipesHolder) {
        this.recipesHolder = recipesHolder;
    }

    public int getStorageType() {
        return storageType;
    }

    public void setStorageType(int storageType) {
        this.storageType = storageType;
    }

    public ArrayList<StockQuantityHolder> getStockQuantityHolders() {
        return stockQuantityHolders;
    }

    public void setStockQuantityHolders(ArrayList<StockQuantityHolder> stockQuantityHolders) {
        this.stockQuantityHolders = stockQuantityHolders;
    }

    @Override
    public String toString() {
        if (getStorageId().length() > 8) {
            return getStorageId().substring(0, 7) + ":" + getName();
        } else {
            return getName();
        }
    }

    public boolean isHaveHasStock(Stock stock) {
        for (StockQuantityHolder stockQuantityHolder : stockQuantityHolders) {
            if (stockQuantityHolder.getStockId().equals(stock.getStockId())) return true;
        }
        return false;
    }

    public void removeStockInHolder(@NonNull Stock stock) {
        int pos = -1;
        for (StockQuantityHolder stockQuantityHolder : stockQuantityHolders) {
            pos++;
            if (stockQuantityHolder.getStockId().equals(stock.getStockId())) {
                stockQuantityHolders.remove(pos);
                break;
            }
        }
    }

    public void removeRecipeInHolder(Recipe recipe) {
        int pos = -1;
        for (String recipeId : recipesHolder) {
            pos++;
            if (recipeId.equals(recipe.getRecipeId())) {
                recipesHolder.remove(pos);
                break;
            }
        }
    }
}

