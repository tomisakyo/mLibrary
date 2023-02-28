package com.example.mylibrary.model;

public class WalletTransactionType {

    private int typeId;
    private String name;
    private boolean isCash;

    private String refId;

    public WalletTransactionType(){}

    public WalletTransactionType(int typeId, String name, boolean isCash, String refId) {
        this.typeId = typeId;
        this.name = name;
        this.isCash = isCash;
        this.refId = refId;
    }

    public String getRefId() {
        return refId;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getName() {
        return name;
    }

    public boolean isCash() {
        return isCash;
    }
}
