package com.example.mylibrary.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Recipe implements Serializable {
    private String recipeId;
    private String name;
    private String recipeCategoryId;
    private ArrayList<Ingredient> ingredientList;
    private String stockResultId;
    private double estimatedResultFrom;
    private double estimatedResultTo;
    private boolean isEnabled;
    private boolean isShowDetail;
    //private boolean isShowContributorList; //TODO : Later = User id + poin, used in process

    //    private Contributor c
    public Recipe(String recipeId, String name, String recipeCategoryId, ArrayList<Ingredient> ingredientList,
                  String stockResultId, double estimatedResultFrom, double estimatedResultTo, boolean isEnabled, boolean isShowDetail) {
        this.recipeId = recipeId;
        this.name = name;
        this.recipeCategoryId = recipeCategoryId;
        this.ingredientList = ingredientList;
        this.stockResultId = stockResultId;
        this.estimatedResultFrom = estimatedResultFrom;
        this.estimatedResultTo = estimatedResultTo;
        this.isEnabled = isEnabled;
        this.isShowDetail = isShowDetail;
    }

    public Recipe(String name) {
        this.recipeId = UUID.randomUUID().toString();
        this.name = name;
        this.recipeCategoryId = "";
        this.ingredientList = new ArrayList<>();
        this.stockResultId = "";
        this.estimatedResultFrom = 0.0;
        this.estimatedResultTo = 0.0;
        this.isEnabled = false;
        this.isShowDetail = false;
    }

    public Recipe() {
        this.recipeId = UUID.randomUUID().toString();
        this.name = "";
        this.recipeCategoryId = "";
        this.ingredientList = new ArrayList<>();
        this.stockResultId = "";
        this.estimatedResultFrom = 0.0;
        this.estimatedResultTo = 0.0;
        this.isEnabled = false;
        this.isShowDetail = false;
    }

    public String getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(String recipeId) {
        this.recipeId = recipeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(String recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(ArrayList<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public String getStockResultId() {
        return stockResultId;
    }

    public void setStockResultId(String stockResultId) {
        this.stockResultId = stockResultId;
    }

    public boolean isShowDetail() {
        return isShowDetail;
    }

    public void setShowDetail(boolean showDetail) {
        isShowDetail = showDetail;
    }

    public double getEstimatedResultFrom() {
        return estimatedResultFrom;
    }

    public void setEstimatedResultFrom(double estimatedResultFrom) {
        this.estimatedResultFrom = estimatedResultFrom;
    }

    public double getEstimatedResultTo() {
        return estimatedResultTo;
    }

    public void setEstimatedResultTo(double estimatedResultTo) {
        this.estimatedResultTo = estimatedResultTo;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }


    public String getIngredientStr() {
        String ingredientStr = "";
        boolean first = true;

        if (ingredientList != null) {
            for (Ingredient ingredient : ingredientList) {
                if (!first) {
                    ingredientStr += "\n";
                }
                ingredientStr += "*" + ingredient.getStockName() + "(" + ingredient.getQuantity() + ")";
                first = false;
            }
        }

        return ingredientStr;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof Recipe) {
            Recipe recipe = (Recipe) obj;
            return getRecipeId().equalsIgnoreCase(recipe.getRecipeId());
        }
        if(obj instanceof String){
            String id = (String) obj;
            return getRecipeId().equalsIgnoreCase(id);
        }
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
