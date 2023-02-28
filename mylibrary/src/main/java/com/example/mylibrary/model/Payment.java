package com.example.mylibrary.model;

import com.example.mylibrary.utility.FunctionManager;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String paymentId;
    private String sessionId;
    private String orderId;
    private String paymentTypeId;
    private double rounding;
    private double paidAmount;
    private String cashierId;

    public Payment(String paymentId, String sessionId, String orderId, String paymentTypeId, double rounding, double paidAmount, String cashierId) {
        this.paymentId = paymentId;
        this.sessionId = sessionId;
        this.orderId = orderId;
        this.paymentTypeId = paymentTypeId;
        this.rounding = rounding;
        this.paidAmount = paidAmount;
        this.cashierId = cashierId;
    }

    public Payment(Order order) {
        this.paymentId = FunctionManager.generateOrderID(order.getOrderId().substring(0,4));
        this.sessionId = "";
        this.orderId = order.getOrderId();
        this.paymentTypeId = "";
        this.rounding = 0;
        this.paidAmount = 0;
        this.cashierId = "";
    }

    public Payment() {
        this.paymentId = "";
        this.sessionId = "";
        this.orderId = "";
        this.paymentTypeId = "";
        this.rounding = 0;
        this.paidAmount = 0;
        this.cashierId = "";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(String paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public double getRounding() {
        return rounding;
    }

    public void setRounding(double rounding) {
        this.rounding = rounding;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public String getCashierId() {
        return cashierId;
    }

    public void setCashierId(String cashierId) {
        this.cashierId = cashierId;
    }
}