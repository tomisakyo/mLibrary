package com.example.mylibrary.model;

import com.google.gson.annotations.Expose;

/**
 * Created by tomis on 11/6/2017.
 */

public class ReceiptPrinterHolder {

    @Expose
    private PrinterHolder receiptPrinter;
    @Expose
    private PrinterHolder reportPrinter;
    @Expose
    private PrinterHolder confirmationPrinter;
    @Expose
    private String confirmationPrinterFooter;
    private boolean autoPrintCancelledOrder;
    private boolean autoPrintTransferredOrder;
    private boolean autoPrintToPrepareStation;

    public ReceiptPrinterHolder(PrinterHolder receiptPrinter, PrinterHolder reportPrinter,
                                PrinterHolder confirmationPrinter, String confirmationPrinterFooter,
                                boolean autoPrintCancelledOrder, boolean autoPrintTransferredOrder) {
        this.receiptPrinter = receiptPrinter;
        this.reportPrinter = reportPrinter;
        this.confirmationPrinter = confirmationPrinter;
        this.confirmationPrinterFooter = confirmationPrinterFooter;
        this.autoPrintCancelledOrder = autoPrintCancelledOrder;
        this.autoPrintTransferredOrder = autoPrintTransferredOrder;
    }

    public ReceiptPrinterHolder() {
        this.receiptPrinter = null;
        this.reportPrinter = null;
        this.confirmationPrinter = null;
        this.confirmationPrinterFooter = "";
        this.autoPrintCancelledOrder = true;
        this.autoPrintTransferredOrder = true;
        this.autoPrintToPrepareStation = true;
    }

    public PrinterHolder getReceiptPrinter() {
        return receiptPrinter;
    }

    public void setReceiptPrinter(PrinterHolder receiptPrinter) {
        this.receiptPrinter = receiptPrinter;
    }

    public PrinterHolder getReportPrinter() {
        return reportPrinter;
    }

    public void setReportPrinter(PrinterHolder reportPrinter) {
        this.reportPrinter = reportPrinter;
    }

    public PrinterHolder getConfirmationPrinter() {
        return confirmationPrinter;
    }

    public void setConfirmationPrinter(PrinterHolder confirmationPrinter) {
        this.confirmationPrinter = confirmationPrinter;
    }

    public String getConfirmationPrinterFooter() {
        return confirmationPrinterFooter;
    }

    public void setConfirmationPrinterFooter(String confirmationPrinterFooter) {
        this.confirmationPrinterFooter = confirmationPrinterFooter;
    }

    public boolean isAutoPrintCancelledOrder() {
        return autoPrintCancelledOrder;
    }

    public void setAutoPrintCancelledOrder(boolean autoPrintCancelledOrder) {
        this.autoPrintCancelledOrder = autoPrintCancelledOrder;
    }

    public boolean isAutoPrintTransferredOrder() {
        return autoPrintTransferredOrder;
    }

    public void setAutoPrintTransferredOrder(boolean autoPrintTransferredOrder) {
        this.autoPrintTransferredOrder = autoPrintTransferredOrder;
    }

    public boolean isAutoPrintToPrepareStation() {
        return autoPrintToPrepareStation;
    }

    public void setAutoPrintToPrepareStation(boolean autoPrintToPrepareStation) {
        this.autoPrintToPrepareStation = autoPrintToPrepareStation;
    }
}
