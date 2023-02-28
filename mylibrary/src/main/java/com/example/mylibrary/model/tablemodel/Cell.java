package com.example.mylibrary.model.tablemodel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Cell {

    @NonNull
    private final String mId;
    @Nullable
    private final Object mData;

    public Cell(@NonNull String id, @Nullable Object data) {
        this.mId = id;
        this.mData = data;
    }

    @Nullable
    public Object getData() {
        return mData;
    }
}
