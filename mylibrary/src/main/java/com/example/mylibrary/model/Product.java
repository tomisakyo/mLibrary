package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.PropertyName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public class Product implements Serializable {
    private String productId;
    private String name;
    private Variant var;
    private double price;
    private int priority;
    private String productCategoryId;
    private String description;
    private String attributes;
    private List<String> variants; // String == variantId
    private List<String> printers;
    private ArrayList<Ingredient> ingredients;
    private boolean isAvailable;
    private boolean isShowing;
    private Image image;
    private ArrayList<Pricing> pricingList;
    private List<Pricing> priceList;

    public Product(String productId, String name, Variant var, double price,
                   int priority, String productCategoryId, String description,
                   String attributes, List<String> variants, List<String> printers,
                   ArrayList<Ingredient> ingredients, boolean isAvailable, boolean isShowing,
                   Image image, ArrayList<Pricing> pricingList, List<Pricing> priceList) {
        this.productId = productId;
        this.name = name;
        this.var = var;
        this.price = price;
        this.priority = priority;
        this.productCategoryId = productCategoryId;
        this.description = description;
        this.attributes = attributes;
        this.variants = variants;
        this.printers = printers;
        this.ingredients = ingredients;
        this.isAvailable = isAvailable;
        this.isShowing = isShowing;
        this.image = image;
        this.pricingList = pricingList;
        this.priceList = priceList;
    }

    public Product() {
        this.productId = UUID.randomUUID().toString();
        this.name = "";
        this.priority = 0;
        this.productCategoryId = "";
        this.description = "";
        this.attributes="";
        this.variants = new ArrayList<>();
        this.printers=new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.image = new Image();
        this.isAvailable = false;
        this.pricingList = new ArrayList<>();
        this.priceList = new ArrayList<>();
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

//    public String getVariantStr() {
//        String variantStr = "";
//        boolean first = true;
//
//        if (variants == null || variants.size() == 0) {
//            variantStr = "-";
//        } else {
//            for (Variant variant : variants) {
//                if (!first) {
//                    variantStr += "\n";
//                }
//                variantStr += "*" + variant.getName();
//                first = false;
//            }
//        }
//
//        return variantStr;
//    }

    public String getPricingStr() {
        StringBuilder pricingStr = new StringBuilder();
        for (Pricing pricing : getPricingList()) {
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_DINE_IN) {
//                pricingStr.append("Dine In : Rp. ").append(pricing.getPrice()).append("\n");
//            }
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_TAKE_AWAY) {
//                pricingStr.append("Take Away : Rp. ").append(pricing.getPrice()).append("\n");
//            }
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_GO_FOOD) {
//                pricingStr.append("Go-Food : Rp. ").append(pricing.getPrice()).append("\n");
//            }
//            if (pricing.getOrderTypeId() == OrderType.ORDER_TYPE_GRAB_FOOD) {
//                pricingStr.append("Grab-Food : Rp. ").append(pricing.getPrice());
//            }
        }
        return pricingStr.toString();
    }

    public String getProductId() {
        return productId;
    }

    public Variant getVar() {
        return var;
    }

    public void setVar(Variant var) {
        this.var = var;
    }

    //    public ArrayList<Pricing> getProductId() {
//        return productId;
//    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    @PropertyName(value="isShowing")
    public boolean isShowing() {
        return isShowing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public List<String> getSelectedVariant() {
        return variants;
    }

    public void setSelectedVariant(List<String> variants) {
        this.variants = variants;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public ArrayList<Pricing> getPricingList() {
        return pricingList;
    }

    public void setPricingList(ArrayList<Pricing> pricingList) {
        this.pricingList = pricingList;
    }

    @Nullable
    public List<String> getVariants() {
        return variants;
    }

    public Image getImage() {
        return image;
    }

    @PropertyName(value="isShowing")
    public void setShowing(boolean showing) {
        isShowing = showing;
    }

    public void setNameCode(String nameCode) {
        this.name = nameCode;
    }

    public List<String> getPrinters() {
        return printers;
    }

    public void setPrinters(List<String> printers) {
        this.printers = printers;
    }

    public List<Pricing> getPriceList() {
        return priceList;
    }

    public void setPriceList(List<Pricing> priceList) {
        this.priceList = priceList;
    }


    public void setVariants(@Nullable List<String> variants) {
        this.variants = variants;
    }

    public int getPrice() {
        return (int) price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getProductId() + ":" + getName();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Product) {
            Product product = (Product) obj;
            return getProductId().equalsIgnoreCase(product.getProductId());
        }
        if (obj instanceof String) {
            String productId = (String) obj;
            return getProductId().equalsIgnoreCase(productId);
        }
        return false;
    }

    public static Comparator<Product> priorityAscendingComparator = new Comparator<Product>() {
        @Override
        public int compare(Product o1, Product o2) {
            return (int) (o1.getPriority() - o2.getPriority());
        }
    };
}
