package com.example.mylibrary.model;

import com.google.firebase.firestore.ListenerRegistration;

import java.util.ArrayList;

public class StorageStockHolder {
    private Storage storage;
    private ArrayList<Stock> stocks;
    private ListenerRegistration stockListener;

    public StorageStockHolder(Storage storage, ArrayList<Stock> stocks, ListenerRegistration stockListener) {
        this.storage = storage;
        this.stocks = stocks;
        this.stockListener = stockListener;
    }

    public StorageStockHolder() {
        this.storage = null;
        this.stocks = new ArrayList<>();
        this.stockListener = null;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public ListenerRegistration getStockListener() {
        return stockListener;
    }

    public void setStockListener(ListenerRegistration stockListener) {
        this.stockListener = stockListener;
    }
}
