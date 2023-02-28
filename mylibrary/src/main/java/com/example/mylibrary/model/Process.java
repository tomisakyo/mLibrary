package com.example.mylibrary.model;

import java.io.Serializable;

public class Process implements Serializable {
    private String recipeId;
    private int noOfRecipe;
    private int waste;
    private int result;
    private String stockResultId;

    public Process(String recipeId, int noOfRecipe, int waste, int result, String stockResultId) {
        this.recipeId = recipeId;
        this.noOfRecipe = noOfRecipe;
        this.waste = waste;
        this.result = result;
        this.stockResultId=stockResultId;
    }

    public Process() {
        this.recipeId = "";
        this.noOfRecipe = 0;
        this.waste = 0;
        this.result = 0;
        this.stockResultId="";
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public int getNoOfRecipe() {
        return noOfRecipe;
    }

    public void setNoOfRecipe(int noOfRecipe) {
        this.noOfRecipe = noOfRecipe;
    }

    public int getWaste() {
        return waste;
    }

    public void setWaste(int waste) {
        this.waste = waste;
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
