package com.example.mylibrary.model;

import java.io.Serializable;

/**
 * Created by tomis on 11/10/2017.
 */

public class ReceiptSetting implements Serializable {
    private static final long serialVersionUID = 1L;


    private Image image;
    private boolean printLogo;
    private String headerTitle;
    private String headerContent;
    private String footer;

    private String printerId;

    public ReceiptSetting(Image image, boolean printLogo, String headerTitle, String headerContent,
                          String footer, String printerId) {
        this.image = image;
        this.printLogo = printLogo;
        this.headerTitle = headerTitle;
        this.headerContent = headerContent;
        this.footer = footer;
        this.printerId=printerId;
    }

    public ReceiptSetting() {
        this.image = new Image();
        this.printLogo = false;
        this.headerTitle = "";
        this.headerContent = "";
        this.footer = "";
        this.printerId="";
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean isPrintLogo() {
        return printLogo;
    }

    public void setPrintLogo(boolean printLogo) {
        this.printLogo = printLogo;
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public String getHeaderContent() {
        return headerContent;
    }

    public void setHeaderContent(String headerContent) {
        this.headerContent = headerContent;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getPrinterId() {
        return printerId;
    }

    public void setPrinterId(String printerId) {
        this.printerId = printerId;
    }

    @Override
    public String toString() {
        return "ReceiptSetting{" +
                "image=" + image +
                ", printLogo=" + printLogo +
                ", headerTitle='" + headerTitle + '\'' +
                ", headerContent='" + headerContent + '\'' +
                ", footer='" + footer + '\'' +
                ", printerId='" + printerId + '\'' +
                '}';
    }
}
