package com.example.mylibrary.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class Variant implements Serializable {
    private String name;
    private String variantId;
    private String variantCategoryId;
    private ArrayList<VariantItem> variantItems;
    private int defaultSelectedVariant;

    public Variant(String name, String variantId, String variantCategoryId, ArrayList<VariantItem> variantItems, int defaultSelectedVariant) {
        this.name = name;
        this.variantId = variantId;
        this.variantCategoryId = variantCategoryId;
        this.variantItems = variantItems;
        this.defaultSelectedVariant = defaultSelectedVariant;
    }

    public Variant() {
        this.name = "";
        this.variantId = UUID.randomUUID().toString();
        this.variantCategoryId = "";
        this.variantItems = new ArrayList<>();
        this.defaultSelectedVariant = -1;
    }

    public int getDefaultSelectedVariant() {
        return defaultSelectedVariant;
    }

    public void setDefaultSelectedVariant(int defaultSelectedVariant) {
        this.defaultSelectedVariant = defaultSelectedVariant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getVariantCategoryId() {
        return variantCategoryId;
    }

    public void setVariantCategoryId(String variantCategoryId) {
        this.variantCategoryId = variantCategoryId;
    }

    public ArrayList<VariantItem> getVariantItems() {
        return variantItems;
    }

    public void setVariantItems(ArrayList<VariantItem> variantItems) {
        this.variantItems = variantItems;
    }

    public void setVariantTypeId(String variantTypeId) {
        this.variantId = variantTypeId;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Variant) {
            Variant variant = (Variant) obj;
            return getVariantId().equalsIgnoreCase(variant.getVariantId());
        }
        if (obj instanceof String) {
            String productId = (String) obj;
            return getVariantId().equalsIgnoreCase(productId);
        }
        return false;
    }

}
