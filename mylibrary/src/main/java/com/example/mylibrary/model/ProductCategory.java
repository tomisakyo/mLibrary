package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;
import java.util.UUID;

public class ProductCategory implements Serializable {
    private String productCategoryId;
    private Image image;
    private String categoryName;
    private String categoryDescription;
    private boolean isEnabled;
    private int priority;

    public ProductCategory(String productCategoryId, String categoryName, String categoryDescription, int priority) {
        this.productCategoryId = productCategoryId;
        this.image=new Image();
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.priority = priority;
    }

    public ProductCategory(String categoryName) {
        this.productCategoryId =  UUID.randomUUID().toString();
        this.image=new Image();
        this.categoryName = categoryName;
        this.categoryDescription = "";
        this.isEnabled = true;
        this.priority = 0;
    }

    public ProductCategory() {
        this.productCategoryId = "";
        this.categoryName = "";
        this.categoryDescription = "";
        this.priority = 0;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return getCategoryName();
    }

    @PropertyName(value="isEnabled")
    public boolean isEnabled() {
        return isEnabled;
    }

    public Image getImage() {
        return image;
    }

    @PropertyName(value = "isEnabled")
    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ProductCategory) {
            ProductCategory productCategory = (ProductCategory) obj;
            return getProductCategoryId().equalsIgnoreCase(productCategory.getProductCategoryId());
        }
        if (obj instanceof String) {
            String productCategoryId = (String) obj;
            return getProductCategoryId().equalsIgnoreCase(productCategoryId);
        }
        return false;
    }

    public int getNote() {
        return 0;
    }
}
