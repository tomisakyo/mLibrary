package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int STATUS_CLEAR = 0; // Clear
    public static int STATUS_ONGOING = 10; // Orange
    public static int STATUS_CONFIRMED = 20; // Blue
    public static int STATUS_PAID = 30; //Green
    public static int STATUS_CANCELED = 40; // Red


    private String productId;
    private String productName;
    private String productCategoryName;
    private double productPrice;
    private int quantity;
    private String note;
    private double discount;
    private double eachItemPrice;
    private String attributes;
    private List<OrderItemVariant> variants;
    private int status;

//    private Map<String, VariantItem> selectedVariants; // variantTypeId, VariantItem

    public OrderItem(String productId, String productName, String productCategoryName, double productPrice,
                     int quantity, String note, double discount, double eachItemPrice, String attributes, List<OrderItemVariant> variants) {
        this.productId = productId;
        this.productName = productName;
        this.productCategoryName = productCategoryName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.note = note;
        this.discount = discount;
        this.eachItemPrice = eachItemPrice;
        this.attributes = attributes;
        this.variants = variants;
        this.status = STATUS_CLEAR;
    }

    public OrderItem(Product product, OrderType orderType) {
        this.productId = product.getProductId();
        this.productName=product.getName();
        this.variants = new ArrayList<>();
        this.quantity = 1;
        this.note = "";
        this.discount = 0;
        Pricing pricing = new Pricing();
        pricing.setOrderTypeId(orderType.getOrderTypeID());
        int i = product.getPriceList().indexOf(pricing);
        if(i>=0){
            pricing = product.getPriceList().get(i);
        }else{

        }
        this.productPrice = pricing.getPrice();
        this.eachItemPrice = getEachItemPrice();
        this.status = STATUS_CLEAR;
    }


    public OrderItem() {
        this.productId = "";
        this.productName = "";
        this.productCategoryName = "";
        this.productPrice = 0.0;
        this.quantity = 0;
        this.note = "";
        this.discount = 0;
        this.eachItemPrice = 0;
        this.attributes="";
        this.variants = new ArrayList<>();
        this.status = STATUS_CLEAR;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getEachItemPrice() {
        eachItemPrice = productPrice;
        for(OrderItemVariant orderItemVariant: variants){
            eachItemPrice+= orderItemVariant.getVariantItemPrice();
        }
        return eachItemPrice;
    }

//    public double getTotalOrderItemPrice(int orderTypeId) {
//        return getEachItemPrice(orderTypeId) * quantity;
//    }
//
//    public void setEachItemPrice(double eachItemPrice) {
//        this.eachItemPrice = eachItemPrice;
//    }

    public List<OrderItemVariant> getVariants() {
        return variants;
    }
    public void setVariants(List<OrderItemVariant> variants) {
        this.variants = variants;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

//    public String getVariantsString() {
//        StringBuilder result = new StringBuilder();
//        if (!selectedVariants.isEmpty()) {
//            ArrayList<VariantItem> listVariantSelected = new ArrayList<>();
//            for (Map.Entry<String, VariantItem> pair : selectedVariants.entrySet()) {
//                listVariantSelected.add(pair.getValue());
//            }
//            if (listVariantSelected.size() == 1) {
//                for (VariantItem variantItem : listVariantSelected) {
//                    result.append(variantItem.getName());
//                }
//            } else {
//                for (int i = 0; i < listVariantSelected.size(); i++) {
//                    if (i != listVariantSelected.size() - 1) {
//                        result.append(listVariantSelected.get(i).getName()).append(", ");
//                    } else {
//                        result.append(listVariantSelected.get(i).getName());
//                    }
//                }
//            }
//        }
//        return result.toString();
//    }
    public double getSubTotal(){
        return getEachItemPrice()*getQuantity();
    }

    public String getSelectedVariantStr(){
        String selectedVarStr="";
        boolean isFirst=true;
        if(getVariants().size()>0){
            for(int i = 0; i< getVariants().size(); i++){
                OrderItemVariant var = getVariants().get(i);
                String selectedVarPrintName = var.getVariantItemName();

                if(!selectedVarPrintName.equalsIgnoreCase("")){
                    if(!isFirst){
                        selectedVarStr +=", ";
                    }
                    selectedVarStr += selectedVarPrintName;
                    isFirst =false;
                }
            }
        }
        return selectedVarStr;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}
