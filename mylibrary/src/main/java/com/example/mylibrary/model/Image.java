package com.example.mylibrary.model;

import java.io.Serializable;

public class Image implements Serializable {
    private String documentId;
    private String imageUrl;

    public Image(String documentId, String imageUrl) {
        this.documentId = documentId;
        this.imageUrl = imageUrl;
    }

    public Image() {
        this.documentId = "";
        this.imageUrl = "";
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
