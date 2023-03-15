package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Session implements Serializable {
    public static int SESSION_OPEN = 100;
    public static int SESSION_CLOSE = 200;

    private String sessionId;
    private String openedBy;
    private long openingDate;
    private long closingDate;
    private int status;
    private List<Cash> cashFlow;
    private List<SettlementPayment> settlementPayments;
    private double different;
    private String sessionNote;

    public Session(String sessionId, String openedBy, long openingDate, long closingDate, int status, List<Cash> cashFlow, List<SettlementPayment> settlementPayments,
                   double different, String sessionNote) {
        this.sessionId = sessionId;
        this.openedBy = openedBy;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
        this.status = status;
        this.cashFlow = cashFlow;
        this.settlementPayments = settlementPayments;
        this.different = different;
        this.sessionNote = sessionNote;
    }

    public Session(long openingDate) {
        this.sessionId = UUID.randomUUID().toString();
        this.openedBy = "";
        this.openingDate = openingDate;
        this.closingDate = 0;
        this.status = SESSION_OPEN;
        this.cashFlow = new ArrayList<>();
        this.settlementPayments = new ArrayList<>();
        this.different = 0;
        this.sessionNote = "";
    }

    public Session() {
        this.sessionId = UUID.randomUUID().toString();
        this.openedBy = "";
        this.openingDate = 0;
        this.closingDate = 0;
        this.status = SESSION_OPEN;
        this.cashFlow = new ArrayList<>();
        this.settlementPayments = new ArrayList<>();
        this.different = 0;
        this.sessionNote = "";
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(String openedBy) {
        this.openedBy = openedBy;
    }

    public long getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(long openingDate) {
        this.openingDate = openingDate;
    }

    public long getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(long closingDate) {
        this.closingDate = closingDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Cash> getCashFlow() {
        return cashFlow;
    }

    public void setCashFlow(List<Cash> cashFlow) {
        this.cashFlow = cashFlow;
    }

    public List<SettlementPayment> getSettlementPayments() {
        return settlementPayments;
    }

    public void setSettlementPayments(List<SettlementPayment> settlementPayments) {
        this.settlementPayments = settlementPayments;
    }

    public double getDifferent() {
        return different;
    }

    public void setDifferent(double different) {
        this.different = different;
    }

    public String getSessionNote() {
        return sessionNote;
    }

    public void setSessionNote(String sessionNote) {
        this.sessionNote = sessionNote;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Session) {
            Session session = (Session) obj;
            return getSessionId().equalsIgnoreCase(session.getSessionId());
        }
        if (obj instanceof String) {
            String sessionId = (String) obj;
            return getSessionId().equalsIgnoreCase(sessionId);
        }
        return false;
    }
}
