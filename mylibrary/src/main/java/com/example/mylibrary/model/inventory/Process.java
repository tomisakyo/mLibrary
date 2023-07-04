package com.example.mylibrary.model.inventory;

import java.io.Serializable;

public class Process implements Serializable {
    private String recipeId;
    private int result;
    private String stockResultId;

    public Process(String recipeId, int result, String stockResultId) {
        this.recipeId = recipeId;
        this.result = result;
        this.stockResultId = stockResultId;
    }

    public Process() {
        this.recipeId = "";
        this.result = 0;
        this.stockResultId = "";
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getStockResultId() {
        return stockResultId;
    }

    public void setStockResultId(String stockResultId) {
        this.stockResultId = stockResultId;
    }
}
