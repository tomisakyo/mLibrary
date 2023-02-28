package com.example.mylibrary.model;

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

    public String getIngredientStr() {
        String ingredientStr = "";
        boolean first = true;

        if (ingredients != null) {
            for (Ingredient ingredient : ingredients) {
                if (!first) {
                    ingredientStr += "\n";
                }
                ingredientStr += "*" + ingredient.getStockName() + "(" + ingredient.getQuantity() + ")";
                first = false;
            }
        }

        return ingredientStr;
    }

    public String getPricingStr() {
        StringBuilder pricingStr = new StringBuilder();
        for (Pricing pricing : getPricingList()) {
            pricingStr.append("*");
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_DINE_IN) {
//                pricingStr.append("Dine In Rp ").append(pricing.getPrice());
//            }
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_TAKE_AWAY) {
//                pricingStr.append("Take Away Rp ").append(pricing.getPrice());
//            }
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_GO_FOOD) {
//                pricingStr.append("Go-Food Rp ").append(pricing.getPrice());
//            }
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_GRAB_FOOD) {
//                pricingStr.append("Grab-Food Rp ").append(pricing.getPrice());
//            }
        }
        return pricingStr.toString();
    }

    public double getPriceByOrderType(int orderTypeId) {
        for (Pricing pricing : pricingList) {
//            if (pricing.getOrderTypeId() == orderTypeId) {
//                return pricing.getPrice();
//            }
        }
        throw new IllegalArgumentException("Pricing List is EMPTY");
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
