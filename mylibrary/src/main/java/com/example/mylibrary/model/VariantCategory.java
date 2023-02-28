package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.UUID;

public class VariantCategory implements Serializable {

    private String variantCategoryId;
    private String variantCategoryName;
    private String variantCategoryDescription;

    public VariantCategory(String variantCategoryId, String variantCategoryName, String variantCategoryDescription) {
        this.variantCategoryId = variantCategoryId;
        this.variantCategoryName = variantCategoryName;
        this.variantCategoryDescription = variantCategoryDescription;
    }

    public VariantCategory(String variantCategoryName) {
        this.variantCategoryId = UUID.randomUUID().toString();
        this.variantCategoryName = variantCategoryName;
        this.variantCategoryDescription = "";
    }

    public VariantCategory() {
        this.variantCategoryId = UUID.randomUUID().toString();
        this.variantCategoryName = "";
        this.variantCategoryDescription = "";
    }

    public String getVariantCategoryId() {
        return variantCategoryId;
    }

    public void setVariantCategoryId(String variantCategoryId) {
        this.variantCategoryId = variantCategoryId;
    }

    public String getVariantCategoryName() {
        return variantCategoryName;
    }

    public void setVariantCategoryName(String variantCategoryName) {
        this.variantCategoryName = variantCategoryName;
    }

    public String getVariantCategoryDescription() {
        return variantCategoryDescription;
    }

    public void setVariantCategoryDescription(String variantCategoryDescription) {
        this.variantCategoryDescription = variantCategoryDescription;
    }

    @Override
    public String toString() {
        return getVariantCategoryName();
    }

    public void setVariantCategory(String toString, String toString1) {

    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof VariantCategory) {
            VariantCategory variantCategory = (VariantCategory) obj;
            return getVariantCategoryId().equalsIgnoreCase(variantCategory.getVariantCategoryId());
        }
        if (obj instanceof String) {
            String variantCategoryId = (String) obj;
            return getVariantCategoryId().equalsIgnoreCase(variantCategoryId);
        }
        return false;
    }
}
