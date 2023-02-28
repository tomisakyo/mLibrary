package com.example.mylibrary.model;

import java.io.Serializable;

public class PaymentInvoice implements Serializable {

    private static final long serialVersionUID = 1L;

    private double subTotal;
    private double taxBeforeDiscount;
    private double discount;
    private double tax;
    private double total;

    public PaymentInvoice(double subTotal, double taxBeforeDiscount, double discount, double tax, double total) {
        this.subTotal = subTotal;
        this.taxBeforeDiscount = taxBeforeDiscount;
        this.discount = discount;
        this.tax = tax;
        this.total = total;
    }

    public PaymentInvoice() {
        this.subTotal = 0;
        this.taxBeforeDiscount = 0;
        this.discount= 0;
        this.tax = 0;
        this.total = 0;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxBeforeDiscount() {
        return taxBeforeDiscount;
    }

    public void setTaxBeforeDiscount(double taxBeforeDiscount) {
        this.taxBeforeDiscount = taxBeforeDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}