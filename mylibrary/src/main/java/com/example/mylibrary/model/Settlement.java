package com.example.mylibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Settlement implements Serializable {
    private String settlementId;
    //    ToDo : check, is this id or not
    private String reportedBy;
    private long dateFrom;
    private long dateTo;
    private List<Cash> cashFlow; //Merged
    private double totalCashBySystem;
    private List<PaymentNonCash> paymentNonCashes; //Merged
    private double totalCashActual;
    private double difference;
    //    ToDo : check, is this list of order id?
    private List<String> stockTransactionId;
    private boolean isSettled;
    private String note;
    private List<String> orderList;
//    update date on confirm
//            add stock transaction id on event : opname, confirm, sales


    public Settlement(String settlementId, String reportedBy, long dateFrom, long dateTo, List<Cash> cashFlow, double totalCashBySystem, List<PaymentNonCash> paymentNonCashes, double totalCashActual, double difference, List<String> stockTransactionId, boolean isSettled, String note, List<String> orderList) {
        this.settlementId = settlementId;
        this.reportedBy = reportedBy;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.cashFlow = cashFlow;
        this.totalCashBySystem = totalCashBySystem;
        this.paymentNonCashes = paymentNonCashes;
        this.totalCashActual = totalCashActual;
        this.difference = difference;
        this.stockTransactionId = stockTransactionId;
        this.isSettled = isSettled;
        this.note = note;
        this.orderList = orderList;
    }

    public Settlement() {
        this.settlementId = UUID.randomUUID().toString();
        this.reportedBy = "";
        this.dateFrom = 0L;
        this.dateTo = 0L;
        this.cashFlow = new ArrayList<>();
        this.totalCashBySystem = 0.0;
        this.paymentNonCashes = new ArrayList<>();
        this.totalCashActual = 0.0;
        this.difference = 0.0;
        this.stockTransactionId = new ArrayList<>();
        this.isSettled = false;
        this.note = "";
        this.orderList = new ArrayList<>();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSettlementId() {
        return settlementId;
    }

    public void setSettlementId(String settlementId) {
        this.settlementId = settlementId;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(String reportedBy) {
        this.reportedBy = reportedBy;
    }

    public long getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(long dateFrom) {
        this.dateFrom = dateFrom;
    }

    public long getDateTo() {
        return dateTo;
    }

    public void setDateTo(long dateTo) {
        this.dateTo = dateTo;
    }

    public List<Cash> getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(List<Cash> cashFlow) {
        this.cashFlow = cashFlow;
    }

    public double getTotalCashBySystem() {
        return totalCashBySystem;
    }

    public void setTotalCashBySystem(double totalCashBySystem) {
        this.totalCashBySystem = totalCashBySystem;
    }

    public List<PaymentNonCash> getPaymentNonCashes() {
        return paymentNonCashes;
    }

    public void setPaymentNonCashes(List<PaymentNonCash> paymentNonCashes) {
        this.paymentNonCashes = paymentNonCashes;
    }

    public double getTotalCashActual() {
        return totalCashActual;
    }

    public void setTotalCashActual(double totalCashActual) {
        this.totalCashActual = totalCashActual;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public List<String> getStockTransactionId() {
        return stockTransactionId;
    }

    public void setStockTransactionId(List<String> stockTransactionId) {
        this.stockTransactionId = stockTransactionId;
    }

    public boolean isSettled() {
        return isSettled;
    }

    public void setSettled(boolean settled) {
        isSettled = settled;
    }


    public List<String> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<String> orderList) {
        this.orderList = orderList;
    }
}
