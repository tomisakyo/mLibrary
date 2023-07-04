package com.example.mylibrary.model.inventory;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class RecipeCategory implements Serializable {
    private String recipeCategoryId;
    private String name;
    private String description;

    public RecipeCategory(String recipeCategoryId, String name, String description) {
        this.recipeCategoryId = recipeCategoryId;
        this.name = name;
        this.description = description;
    }

    public RecipeCategory(String name) {
        this.recipeCategoryId = UUID.randomUUID().toString();
        this.name = name;
        this.description = "";
    }

    public RecipeCategory() {
        this.recipeCategoryId = "";
        this.name = "";
        this.description = "";
    }

    public String getRecipeCategoryId() {
        return recipeCategoryId;
    }

    public void setRecipeCategoryId(String recipeCategoryId) {
        this.recipeCategoryId = recipeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof RecipeCategory) {
            RecipeCategory recipeCategory = (RecipeCategory) obj;
            return getRecipeCategoryId().equalsIgnoreCase(recipeCategory.getRecipeCategoryId());
        }
        if(obj instanceof String){
            String id = (String) obj;
            return getRecipeCategoryId().equalsIgnoreCase(id);
        }
        return false;
    }
    @Override
    public String toString() {
        return getName();
    }
}
