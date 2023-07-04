package com.example.mylibrary.model;

import com.example.mylibrary.model.inventory.Ingredient;

import java.io.Serializable;
import java.util.ArrayList;

public class VariantItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private String variantItemId;
    private String name;
    private ArrayList<Ingredient> ingredients;
    private String print;
    private boolean isEnable;
    private ArrayList<Pricing> pricingList;

    public VariantItem(String variantItemId, String name, ArrayList<Ingredient> ingredients, String print, boolean isEnable, ArrayList<Pricing> pricingList) {
        this.variantItemId = variantItemId;
        this.name = name;
        this.ingredients = ingredients;
        this.print = print;
        this.isEnable = isEnable;
        this.pricingList = pricingList;
    }

    public VariantItem() {
        this.variantItemId = "";
        this.name = "";
        this.ingredients = new ArrayList<>();
        this.print = "";
        this.isEnable = false;
        this.pricingList = new ArrayList<>();
    }

    public String getVariantItemId() {
        return variantItemId;
    }

    public void setVariantItemId(String variantItemId) {
        this.variantItemId = variantItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public ArrayList<Pricing> getPricingList() {
        return pricingList;
    }

    public void setPricingList(ArrayList<Pricing> pricingList) {
        this.pricingList = pricingList;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }
}
