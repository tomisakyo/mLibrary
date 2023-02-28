package com.example.mylibrary.model.printing;//package com.menusantara.library.model.printing;
//
//import android.app.Activity;
//import android.bluetooth.BluetoothAdapter;
//import android.bluetooth.BluetoothDevice;
//import android.bluetooth.BluetoothSocket;
//import android.widget.Toast;
//
//import com.menusantara.library.model.Order;
//import com.menusantara.library.model.OrderItem;
//import com.menusantara.library.model.Outlet;
//import com.menusantara.library.model.PrinterHolder;
//import com.menusantara.library.utility.FunctionManager;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.UUID;
//
//
//public class BluetoothPrintManager {
//
//    private static int CHAR_LENGTH_58 = 32;
//
//    private String PRINT_AND_FEED_PAPER = " ESC J 100 ";
//    private String errorMessage = "";
//
//    private static final UUID SPP_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
//    //    private static final UUID SPP_UUID = UUID.randomUUID();
//    OutputStream mOutputStream = null;
//
//    private String cashierTitleName = "Cashier";
//    private String waiterTitleName = "By: ";
//
//    private BluetoothAdapter mBluetoothAdapter = null;
//    private BluetoothDevice mBluetoothDevice = null;
//    private BluetoothSocket mBluetoothSocket = null;
//    private String printerBluetooth;
//    private boolean isConnected;
//    private boolean isPrinting;
//    private Activity activity;
//
//    public BluetoothPrintManager(Activity activity) {
//        this.activity = activity;
//        this.mOutputStream = null;
//        this.mBluetoothAdapter = null;
//        this.mBluetoothDevice = null;
//        this.mBluetoothSocket = null;
//
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
////        mBluetoothDevice = mBluetoothAdapter.getRemoteDevice("DC:0D:30:28:29:FF");
////        mBluetoothDevice = mBluetoothAdapter.getRemoteDevice("DC:0D:30:28:29:4E");
////
////        mBluetoothDevice = mBluetoothAdapter.getRemoteDevice("0F:02:17:A2:1A:99");
//
////        System.out.println("mBluetoothDeviceName: " + mBluetoothDevice.getName());
//
//
//        if (!mBluetoothAdapter.isEnabled()) {
//            errorMessage = runToastThread("Please enable your bluetooth");
//
//        }
////        else {
////            if (mBluetoothDevice.getName() == null) {
////                Toast.makeText(ResourceManager.CURRENT_ACTIVITY, "Printer Bluetooth not found", Toast.LENGTH_LONG).show();
////            }
////        }
//    }
//
////        try {
////        mOutputStream.close();
////        mBluetoothSocket.close();
//
//
//    public BluetoothPrintManager(OutputStream mOutputStream, BluetoothAdapter mBluetoothAdapter, BluetoothDevice mBluetoothDevice, BluetoothSocket mBluetoothSocket) {
//        this.mOutputStream = mOutputStream;
//        this.mBluetoothAdapter = mBluetoothAdapter;
//        this.mBluetoothDevice = mBluetoothDevice;
//        this.mBluetoothSocket = mBluetoothSocket;
//    }
//
//    public String getErrorMessage() {
//        return errorMessage;
//    }
//
//    public void setErrorMessage(String errorMessage) {
//        this.errorMessage = errorMessage;
//    }
//
//    public boolean connect(String printer) {
//        if (!isConnected) {
//            try {
////                System.out.println("getBondState: " + mBluetoothDevice.getBondState());
//                if (mBluetoothSocket == null) {
//                    mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(printer);
//                }
//
//                mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(SPP_UUID);
//                System.out.println("mBluetoothSocket: " + mBluetoothSocket);
//                System.out.println("mBluetoothSocket isConnected: " + mBluetoothSocket.isConnected());
//
//                mBluetoothSocket.connect();
//                System.out.println("mBluetoothSocket: " + mBluetoothSocket);
//                System.out.println("mBluetoothSocket isConnected: " + mBluetoothSocket.isConnected());
//                mOutputStream = mBluetoothSocket.getOutputStream();
//
//                if (mBluetoothSocket.isConnected()) {
//                    isConnected = true;
//                    return true;
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                errorMessage = runToastThread("Connect Failed: " + e.toString());
//                return false;
//            }
//        } else {
//            isConnected = true;
//        }
//        return true;
//    }
//
//    public void destroy() {
//        try {
//            if (mBluetoothSocket != null) {
//                if (mBluetoothSocket.isConnected()) {
//                    mBluetoothSocket.close();
//                    mOutputStream.close();
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public boolean isConnected() {
//        return isConnected;
//    }
//
//    public void setConnected(boolean connected) {
//        isConnected = connected;
//    }
//
//    public boolean isPrinting() {
//        return isPrinting;
//    }
//
//    public void setPrinting(boolean printing) {
//        isPrinting = printing;
//    }
//
//    public String runToastThread(final String content) {
//        activity.runOnUiThread(new Runnable() {
//            public void run() {
//                // runs on UI thread
//                Toast.makeText(activity, content, Toast.LENGTH_SHORT).show();
//            }
//        });
//        return content;
//    }
//
//    public boolean print(String content, String printer) {
//        isPrinting = true;
//        if (!isConnected) {
//            runToastThread("Connecting to printer bluetooth");
//            if (!connect(printer)) {
//                isPrinting = false;
//                return false;
//            }
//        }
//        try {
//            if (!mBluetoothAdapter.isEnabled()) {
//                errorMessage = runToastThread("Print Failed: Please enable your bluetooth");
//                isPrinting = false;
//                return false;
//            }
////            if(mBluetoothDevice==null){
////                mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(printer);
////                if (mBluetoothSocket != null) {
////                    if (mBluetoothSocket.isConnected()) {
////                        mBluetoothSocket.close();
////                        mOutputStream.close();
////                    }
////                }
////            }
////            else {
//            if (!mBluetoothDevice.getAddress().equalsIgnoreCase(printer)) {
//                mBluetoothDevice = mBluetoothAdapter.getRemoteDevice(printer);
//                if (mBluetoothSocket != null) {
//                    if (mBluetoothSocket.isConnected()) {
//                        mBluetoothSocket.close();
//                        mOutputStream.close();
//                    }
//                }
//            }
////            }
//
//            if (mBluetoothDevice.getName() == null) {
//                errorMessage = runToastThread("Print Failed: Printer Bluetooth not found");
//                isPrinting = false;
//                return false;
//            }
//
//            if (mBluetoothDevice.getBondState() == BluetoothDevice.BOND_NONE) {
//                errorMessage = runToastThread("Print Failed: Printer Not Paired");
//                isPrinting = false;
//                return false;
//            } else if (mBluetoothDevice.getBondState() == BluetoothDevice.BOND_BONDED) {
//                if (!mBluetoothSocket.isConnected()) {
//                    mBluetoothSocket = mBluetoothDevice.createRfcommSocketToServiceRecord(SPP_UUID);
//                    mBluetoothSocket.connect();
//                }
//
//                mOutputStream = mBluetoothSocket.getOutputStream();
//                mOutputStream.write(content.getBytes("GBK"));
//                mOutputStream.flush();
//                isPrinting = false;
//                Thread.sleep(1000);
//                return true;
//            }
//
//
//        } catch (Exception e) {
//            System.out.println("Print Failed: " + e.toString());
//            errorMessage = runToastThread("Print Failed: " + e.toString());
//            isPrinting = false;
//
//        }
//        isPrinting = false;
//        return false;
//    }
//
//    private static String generateLine(int length, char sign) {
//        String str = "";
//        for (int i = 0; i < length; i++) {
//            str += sign;
//        }
//        return str;
//    }
//
//
//    public boolean printReceipt(String printer, Order order, String cashier, Outlet outlet, boolean isRePrint) {
//        String content = "";
//        int length = CHAR_LENGTH_58;
//        Date date = new Date();
//        String dateStr;
//        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
//
//
//        String orderId = order.getOrderId();
//        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
//
//        //Header
//        if (isRePrint) {
//            content += util.format("REPRINT RECEIPT");
//        }
//        content += String.format("%s%" + (length - dateStr.length()) + "s", dateStr, orderId);
//        content += util.format(outlet.getName());
//        content += util.format(outlet.getAddress());
//        if (!order.getOrderName().trim().equalsIgnoreCase("")) {
//            content += ("Name: " + order.getOrderName() + "\n");
//        }
//
//        //Content
//        content += ("Cashier: " + cashier + "\n");
//        if (!order.getOrderNote().trim().equalsIgnoreCase("")) {
//            content += ("Note: " + order.getOrderNote() + "\n");
//        }
//
//        //--------------------------------
//        content += String.format(generateLine(length, '-'));
//
//        for (OrderItem orderItem : order.getOrderItems()) {
////            content += String.format("+%2d %s (%s)\n", orderItem.getQuantity(), orderItem.getProductName(), orderItem.getVariantsString());
////
////            //Feed line for 1.76cm (n x0.176mm);
////
////            if (!orderItem.getNote().equalsIgnoreCase("")) {
////                content += "   (" + orderItem.getNote() + ")\n";
////            }
//
//            String printedItem = orderItem.getProductName();
//            if (!orderItem.getVariantsString().equalsIgnoreCase("")) {
//                printedItem += " (" + orderItem.getVariantsString() + ")";
//            }
////            printedItem += " @" + FunctionManager.currencyFormatter(orderItem.getEachItemPrice(order.getOrderType().getOrderTypeID()));
////            if (printMenu.getDiscount() > 0) {
////                printedItem += " | Disc. ";
////                if (!printMenu.getDiscountStr().equalsIgnoreCase("")) {
////                    printedItem += "(" + printMenu.getDiscountStr() + ") ";
////                }
////                printedItem += ResourceManager.currencyFormatter(printMenu.getDiscount());
////
////            }
//
////            System.out.println(printedItem);
//            //Split Items content by length;
//
//            ArrayList<String> printedItems = new ArrayList<>();
//            int lengthContent = length - 3 - 10;
//
//            String chuckedItems[] = printedItem.split(" ");
//
//            int lineIndex = 0;
//            for (String chuckStr : chuckedItems) {
//                if (printedItems.size() == 0) {
//                    printedItems.add(chuckStr);
//                } else {
//                    if ((printedItems.get(lineIndex).length() + chuckStr.length() + 1) <= lengthContent) {
//                        printedItems.set(lineIndex, printedItems.get(lineIndex) + " " + chuckStr);
//                    } else {
//                        lineIndex++;
//                        printedItems.add(chuckStr);
//                    }
//                }
//            }
////
//////                for (int i = 0; i < printedItem.length(); i += length) {
//////                    System.out.println(printedItem.substring(i, Math.min(i+length, printedItem.length())));
//////                    printedItems.add(printedItem.substring(i, Math.min(i+length, printedItem.length())));
//////                }
////
////            content += String.format("%2d %-" + (lengthContent) + "s%10s\n", orderItem.getQuantity(), printedItems.get(0), FunctionManager.currencyFormatter(orderItem.getTotalOrderItemPrice(order.getOrderType().getOrderTypeID())));
//            if (printedItems.size() > 1) {
//                System.out.println("Size: " + printedItems.size());
//                for (int i = 1; i < printedItems.size(); i++) {
//                    System.out.println(i + " line: " + "   " + printedItems.get(i));
//                    content += ("   " + printedItems.get(i) + "\n");
//                }
//            }
//
//        }
//
//        //--------------------------------
//        content += String.format(generateLine(length, '-')) + "\n";
//        String printStr = "SUB-TOTAL:";
//        content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr,  "Rp " + FunctionManager.currencyFormatter(order.getPayment().getSubTotal()));
//
////        if (order.getPayment().getTaxBeforeAmount() != 0) {
////            printStr = payment.getTaxBeforeName() + "(" + payment.getTaxBeforePercent() + "%):";
////            content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr, "+" + ResourceManager.currencyFormatter(payment.getTaxBeforeAmount()));
////        }
//        if (order.getPayment().getTaxBeforeDiscount() != 0) {
//            printStr = "Total Discount:";
//            content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr, "-" + FunctionManager.currencyFormatter(order.getPayment().getDiscount()));
//        }
//        if (order.getPayment().getTax() != 0) {
//            printStr = "Tax";
//            content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr, "+" + FunctionManager.currencyFormatter(order.getPayment().getTax()));
//        }
//        if (order.getPayment().getPaymentType().getFee() != 0) {
//            printStr = "Transaction Fee";
//            content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr, "+" + FunctionManager.currencyFormatter(order.getPayment().getPaymentType().getFee()));
//        }
//        if (order.getPayment().getRounding() != 0) {
//            printStr = "Rounding:";
//
//            String roundingSign = "";
//            if (order.getPayment().getRounding() > 0) {
//                roundingSign = "+";
//            }
//            content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr, roundingSign + FunctionManager.currencyFormatter(order.getPayment().getRounding()));
//        }
//
//        //--------------------------------
//        content += String.format(generateLine(length, '-')) + "\n";
//        printStr = "TOTAL:";
//        content += String.format("%s%" + (length - printStr.length()) + "s\n", printStr, "Rp " + FunctionManager.currencyFormatter(order.getPayment().getTotal()));
//
//        content += "\n" + util.format("Thank You!");
//        content += util.format("Supported by MENUSANTARA");
//////            mPrinter.addFeedUnit(10);
//////            mPrinter.addText("Follow us @pinktempong (instagram)\n");
//        content += "\n\n\n";
//
//
//        return print(content, printer);
//    }
//
//    public boolean printOrder(PrinterHolder printerHolder, Order order, String waiter) {
//        String content = "";
//        int length = CHAR_LENGTH_58;
//        Date date = new Date();
//        String dateStr;
//        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
//
//
//        String orderId = order.getOrderId();
//        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
//
//        //Header
//        content += String.format("%s%" + (length - dateStr.length()) + "s", dateStr, orderId + "#" + order.getOrderItems().size() + "+");
//
//        if (!order.getOrderName().equalsIgnoreCase("")) {
//            content += util.format(order.getOrderName());
//        }
//
//        String orderType = "";
////        if(order.getOrderType().getOrderTypeID()== OrderType.ORDER_TYPE_DINE_IN){
////            orderType = "DINE-IN";
////        }else if(order.getOrderType().getOrderTypeID()== OrderType.ORDER_TYPE_TAKE_AWAY){
////            orderType = "TAKE-AWAY";
////        }else if(order.getOrderType().getOrderTypeID()== OrderType.ORDER_TYPE_GO_FOOD){
////            orderType = "GO-FOOD";
////        }else if(order.getOrderType().getOrderTypeID()== OrderType.ORDER_TYPE_GRAB_FOOD){
////            orderType = "GRAB-FOOD";
////        }
//        //Content
//        //Header
//        //Waiter
//        String waiterStr = ("Waiter: " + waiter);
//
//        //Merge Order Type with Waiter
//        content += String.format("%s%" + (length - waiterStr.length()) + "s\n", waiterStr, orderType);
//
//        if (!order.getOrderNote().trim().equalsIgnoreCase("")) {
//            content += ("Note: " + order.getOrderNote() + "\n");
//        }
//        //--------------------------------
//        content += String.format(generateLine(length, '-'));
//
//        for (OrderItem orderItem : order.getOrderItems()) {
////            System.out.println("eMenu.getOrderingPrinter(): " + eMenu.getOrderingPrinter());
////            if (orderingPrinter.getUID().equalsIgnoreCase(orPrinter.getUID())) {
//            if(orderItem.getAttributes().toLowerCase().contains(printerHolder.getName().toLowerCase())) {
//                content += String.format("+%2d %s\n", orderItem.getQuantity(), orderItem.getProductName());
//                if(!orderItem.getSelectedVariantStr().equalsIgnoreCase("")){
//                    content +="   *"+orderItem.getSelectedVariantStr()+"\n";
//                }
//
//            }
//
//            //Feed line for 1.76cm (n x0.176mm);
//
//            if (!orderItem.getNote().equalsIgnoreCase("")) {
//                content += "   (" + orderItem.getNote() + ")\n";
//            }
////            }
//
//        }
//
//
//        content += "\n\n\n";
//
//
//        return print(content, printerHolder.getConnection());
//    }
//
//    public int printTransfer(String printer, String orderId, String heading, String user, String note, String items, String footerStr) {
//        String content = "";
//        Date date = new Date();
//        String dateStr;
//        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
//        int length = CHAR_LENGTH_58;
//
//        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
//
//        //Header
//        content += String.format("%s%" + (length - dateStr.length()) + "s\n", dateStr, orderId);
//        content += util.format("TRANSFER RECEIPT");
//        content += util.format(heading);
//
//        //Content
//        content += ("By" + ": " + user + "\n");
////        if (!note.trim().equalsIgnoreCase("")) {
////            content += ("Note: " + note + "\n");
////        }
//        //--------------------------------
//        content += String.format(generateLine(length, '-'));
//
//        content += items;
//
//        content += "\n";
//
//        //Print Footer
//        String footers[] = footerStr.split("\n");
//        for (String footer : footers) {
//            content += (util.format(footer));
//        }
//
//        content += "\n\n\n";
//
//        print(content, printer);
//        return -1;
//    }
//
////    public boolean printDailySummary(String printer, DailySummary dailySummary) {
//////        public static void printReport(Printer mPrinter, int mode) {
////        String content = "";
////        Date date = new Date();
////        String dateStr;
////        String startTime;
////        String endTime;
////        String timeStr = new SimpleDateFormat("dd-MMM / KK:mm:ss a").format(date);
////        int length = CHAR_LENGTH_58;
////        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
////
////        // dateStr = new SimpleDateFormat("dd MMM").format(dailySummary.getReportFrom());
////
////        dateStr = new SimpleDateFormat("dd MMM yy").format(dailySummary.getReportFrom());
//////            dateStr = dateInt + new SimpleDateFormat("MMM yy").format(date);
////
////
////        startTime = new SimpleDateFormat("KK:mm(ddMMM)").format(dailySummary.getReportFrom());
////        endTime = new SimpleDateFormat("KK:mm(ddMMM)").format(dailySummary.getReportTo());
////
////
////        //Header
////
////        content += util.format("Report " + dateStr);
////        content += util.format("'" + startTime + "-" + endTime + "'");
////
////        content += "Printed by: " + UserManager.LOGGED_USER.getUserName() + "\n";
////
////        Date generateDate = new Date();
////        generateDate.setTime(dailySummary.getReportGenerateDate());
////        String generateDateStr = new SimpleDateFormat("dd MMM yy|kk:mm:ss").format(generateDate);
////        content += "Generated at: " + generateDateStr + "\n";
////        //--------------------------------
////        content += String.format(generateLine(length, '-'));
////
////
////        ArrayList<EMenu> printedMenu = new ArrayList<>();
////
////        String orderTypeStr = "";
////
////        //Load Sales Report
////        for (SalesSummary salesSummary : dailySummary.getSalesSummaryArrayList()) {
////            if (salesSummary.getGrandTotal() != 0 || salesSummary.getNoOfItems() != 0) {
////                String orderType = salesSummary.getOrderType();
////                if (orderType.equalsIgnoreCase("Custom")) {
////                    orderTypeStr = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM1);
////                } else if (orderType.equalsIgnoreCase("Custom2")) {
////                    orderTypeStr = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM2);
////                } else if (orderType.equalsIgnoreCase("Custom3")) {
////                    orderTypeStr = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM3);
////                } else if (orderType.equalsIgnoreCase("Custom4")) {
////                    orderTypeStr = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM4);
////                } else if (orderType.equalsIgnoreCase("Custom5")) {
////                    orderTypeStr = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM5);
////                } else {
////                    orderTypeStr = orderType;
////                }
////
////                content += "SALES SUMMARY | " + orderTypeStr + "\n";
////
////                //Consolidate Content
////                String contentStr = "";
////                contentStr += "*Net Total(Profit): " + ResourceManager.currencyFormatter(salesSummary.getNetTotal());
////                contentStr += "\n*Commission: " + ResourceManager.currencyFormatter(salesSummary.getCommission());
////                contentStr += "\n*Grand Total: " + ResourceManager.currencyFormatter(salesSummary.getGrandTotal());
////                contentStr += "\n*Rounding: " + ResourceManager.currencyFormatter(salesSummary.getRounding());
////                contentStr += "\n*Transaction Fee: " + ResourceManager.currencyFormatter(salesSummary.getTransactionFee());
////                contentStr += "\n*Tax: " + ResourceManager.currencyFormatter(salesSummary.getTax());
////                contentStr += "\n*Discount: " + ResourceManager.currencyFormatter(salesSummary.getDiscount());
////                contentStr += "\n*Tax Before: " + ResourceManager.currencyFormatter(salesSummary.getTaxBefore());
////                contentStr += "\n*Sub Total: " + ResourceManager.currencyFormatter(salesSummary.getSubTotal());
////                contentStr += "\n*No Of Order: " + salesSummary.getNoOfOrders();
////                contentStr += "\n*No Of Items: " + salesSummary.getNoOfItems();
////                contentStr += "\n*No Of Cancelled Order: " + salesSummary.getNoOfCancelledOrders();
////                contentStr += "\n*No Of Cancelled Items: " + salesSummary.getNoOfCancelledItems();
////                contentStr += "\n";
////                content += contentStr;
////                //--------------------------------
////                content += String.format(generateLine(length, '-'));
////
////            }
////        }
////
////        //Load Cashier Report
////        for (CashierReport cashierReport : dailySummary.getCashierReportArrayList()) {
////            content += "CASHIER SUMMARY | " + cashierReport.getCashierName() + "\n";
////
////            ArrayList<PaymentOrderType> paymentOrderTypeArrayList = FunctionManager.
////                    convertPaymentOrderTypeListFromString(cashierReport.getPaymentOrderTypeList());
////
////            String contentStr = "";
////            boolean first = true;
////            String orderType = "";
////            for (PaymentOrderType paymentOrderType : paymentOrderTypeArrayList) {
////                if (paymentOrderType.getTotalAmount() > 0) {
////                    if (!first) {
////                        contentStr += "\n\n";
////                    }
////                    if (paymentOrderType.getOrderType().equalsIgnoreCase("Custom")) {
////                        orderType = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM1);
////                    } else if (paymentOrderType.getOrderType().equalsIgnoreCase("Custom2")) {
////                        orderType = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM2);
////                    } else if (paymentOrderType.getOrderType().equalsIgnoreCase("Custom3")) {
////                        orderType = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM3);
////                    } else if (paymentOrderType.getOrderType().equalsIgnoreCase("Custom4")) {
////                        orderType = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM4);
////                    } else if (paymentOrderType.getOrderType().equalsIgnoreCase("Custom5")) {
////                        orderType = OrderTypesHolder.getOrderTypeNameByID(OrderType.TYPE_CUSTOM5);
////                    } else {
////                        orderType = paymentOrderType.getOrderType();
////                    }
//////                System.out.println("OrderType1: "+paymentOrderType.getOrderType());
//////                System.out.println("OrderType2: "+orderType);
////
////                    contentStr += orderType.toUpperCase();
////                    for (PaymentReport paymentReport : paymentOrderType.getPaymentReportArrayList()) {
////                        contentStr += "\n*" + paymentReport.getPaymentName() + "[" + paymentReport.getNoOfOrder() + " Orders] "
////                                + ResourceManager.currencyFormatter(paymentReport.getTotalAmount());
////                    }
////                    first = false;
////                }
////
////            }
////            contentStr += "\n";
////            content += contentStr;
////            //--------------------------------
////            content += String.format(generateLine(length, '-'));
////        }
////
////        //Load Sales Top 5
////        //Ongoing
////
////        //Load Order By User
////        for (WaiterOrder waiterOrder : dailySummary.getWaiterOrderArrayList()) {
////            content += "ORDER BY USER | " + waiterOrder.getWaiterName() + "\n";
////
////            String contentStr = "";
////            contentStr += "*No Of Ordering: " + waiterOrder.getNoOfOrdering();
////            contentStr += "\n*No Of Items: " + waiterOrder.getNoOfItems();
////            contentStr += "\n";
////            content += contentStr;
////            //--------------------------------
////            content += String.format(generateLine(length, '-'));
////        }
////
////        String contentStr;
////        boolean first;
////        //Load Cancelled Order
////        if (dailySummary.getCancelledOrderArrayList().size() > 0) {
////            content += "CANCELLED ORDER | " + dailySummary.getCancelledOrderArrayList().size() + " Orders" + "\n";
////
////            contentStr = "";
////            first = true;
////            for (CancelledOrder cancelledOrder : dailySummary.getCancelledOrderArrayList()) {
////                if (!first) {
////                    contentStr += "\n";
////                }
////                contentStr += "*" + cancelledOrder.getOrderID() + " [" + cancelledOrder.getNoOfItems() + " Items]";
////                first = false;
////                contentStr += "\n";
////            }
////            content += contentStr;
////            //--------------------------------
////            content += String.format(generateLine(length, '-'));
////        }
////
////
////        //Load Partial Cancelled Order
////        if (dailySummary.getPartialCancelledOrderArrayList().size() > 0) {
////            content += "PARTIAL CANCELLED ORDER | " + dailySummary.getPartialCancelledOrderArrayList().size() + " Orders" + "\n";
////
////            contentStr = "";
////            first = true;
////            for (PartialCancelledOrder partialCancelledOrder : dailySummary.getPartialCancelledOrderArrayList()) {
////                if (!first) {
////                    contentStr += "\n";
////                }
////                contentStr += "*" + partialCancelledOrder.getOrderID() + " [" + partialCancelledOrder.getCancelledItems()
////                        + " of " + partialCancelledOrder.getTotalItems() + " Items]";
////                first = false;
////                contentStr += "\n";
////            }
//////            contentStr += "\n";
////            content += contentStr;
////        }
////        content += "\n\n\n";
////
//////            mPrinter.addCut(Printer.CUT_FEED);
////        return print(content, printer);
////
////    }
////
////    public int printConfirmation(String printer, Order order, String tableName, Integer[] selectedOrdering, int task) {
////        String content = "";
////        Date date = new Date();
////        String dateStr;
////        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
////        int length = CHAR_LENGTH_58;
////
////        String orderId = order.getOrderId();
////        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
////
////        //Header
////        content += String.format("%s%" + (length - dateStr.length()) + "s\n", dateStr, orderId + "#" + order.getOrderings().size() + "+");
////
////        String heading = "";
////        if (task == ResourceManager.TASK_ORDER_STATION) {
////            heading = tableName;
////        } else {
////            if (!order.getTableNote().equalsIgnoreCase("")) {
////                heading = order.getTableNote() + " / " + tableName + order.getOrderId().substring(4, 7);
////            } else {
////                heading = tableName + order.getOrderId().substring(4, 7);
////            }
////        }
////
////        content += util.format(heading);
////
////        //Content
////        content += (waiterTitleName + ": " + UserManager.LOGGED_USER.getUserName() + "\n");
////        if (!order.getTableNote().trim().equalsIgnoreCase("")) {
////            content += ("Note: " + order.getTableNote() + "\n");
////        }
////        //--------------------------------
////        content += String.format(generateLine(length, '-'));
////
////
////        for (Integer prt : selectedOrdering) {
////            Ordering ordering = order.getOrderings().get(prt);
////            for (EMenu eMenu : ordering.getOrderItems()) {
////                if (eMenu.getStatus() != Table.STATUS_CANCELED) {
////                    content += String.format("+%2d %s %s\n", eMenu.getQuantity(), eMenu.getName(), eMenu.getSelectedVariantStr());
////                    if (!eMenu.getOrderNoteSumStr().equalsIgnoreCase("")) {
////                        content += ("   (" + eMenu.getOrderNoteSumStr() + ")\n");
////
////                    }
////                }
////
////            }
////        }
////        content += "\n";
////
////        //Print Footer
////        String footers[] = ResourceManager.PRINTER.getConfirmationPrinterFooter().split("\n");
////        for (String footer : footers) {
////            content += (util.format(footer));
////        }
////
////        content += "\n\n\n";
////
////        print(content, printer);
////        return -1;
////    }
////
////
////    public boolean printMoveOrder(String printer, Order order, String tableName, String newTableName) {
////        String content = "";
////        Date date = new Date();
////        String dateStr;
////        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
////
////        int length = CHAR_LENGTH_58;
////        String orderId = order.getOrderId();
////        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
////
////        //Header
////        content += String.format("%s%" + (length - dateStr.length()) + "s\n", dateStr, orderId);
////
////        //Table & Queue Number
////        content += util.format(("(Move table)"));
////        content += (util.format(tableName.toUpperCase() + " -> " + newTableName.toUpperCase()) + "\n");
////
////        content += ("Printed by: " + UserManager.LOGGED_USER.getUserName() + "\n\n\n\n");
////
////        return print(content, printer);
////    }
////
////    public boolean printInventoryStock(String printer, ArrayList<Inventory> inventories, String filter) {
////        String content = "";
////        int length = CHAR_LENGTH_58;
////        Date date = new Date();
////        String dateStr;
////        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
////
////        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
////
////        //Header
////        content += (dateStr + "\n");
////        String heading = "";
////
////        //Table & Queue Number
////        content += util.format("Inventory Stock");
////        content += ("Printed by: " + UserManager.LOGGED_USER.getUserName() + "\n");
////        if (!filter.equalsIgnoreCase("")) {
////            content += (filter + "\n");
////        }
////
////
////        //--------------------------------
////        content += String.format(generateLine(length, '-'));
////
////        for (Inventory inventory : inventories) {
////            content += "_____" + inventory.getName() + "(" + inventory.getTotalBalance() + ")\n\n";
////
////        }
////
////        content += "\n\n\n";
////
////
////        return print(content, printer);
////    }
////
////    public boolean printTransactions(String printer, ArrayList<Order> orders) {
////        String content = "";
////        int length = CHAR_LENGTH_58;
////        Date date = new Date();
////        String dateStr;
////        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
////
////        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
////
////        //Header
////        content += (dateStr + "\n");
////        String heading = "";
////
////        //Table & Queue Number
////        content += util.format("Transactions");
//////        content += String.format("%s%" + (length - dateStr.length()) + "s\n", dateStr, orderId);
////        content += ("Printed by: " + UserManager.LOGGED_USER.getUserName() + "\n");
////
////
////        //--------------------------------
////        content += String.format(generateLine(length, '-'));
////
////        for (Order order : orders) {
//////            content+="_____"+inventory.getName()+"("+inventory.getTotalBalance()+")\n\n";
////            content += "[" + order.getNoOfItems() + "]" + order.getOrderId() + " | " + order.getTableNote() + "\n";
////
////            String orderType = "";
////            if (order.getOrderType().equalsIgnoreCase("OrderStation")) {
////                orderType = order.getOrderType();
////            } else {
////                orderType = OrderTypesHolder.getOrderTypeByDataName(order.getOrderType()).getName();
////            }
////            dateStr = new SimpleDateFormat("dd-MMM/KK:mm:ss a").format(order.getLastOrder());
////
////            content += String.format("%s%" + (length - dateStr.length()) + "s\n", dateStr, orderType);
////
////            //Order Items
////            //Content Items
////            //Paid Orders
////            ArrayList<EMenu> itemsList = new ArrayList<>();
////            for (Ordering ordering : order.getOrderings()) {
////                for (EMenu eMenu : ordering.getOrderItems()) {
////                    if (eMenu.getStatus() != Table.STATUS_CANCELED) {
////                        if (itemsList.contains(eMenu)) {
////                            itemsList.get(itemsList.indexOf(eMenu)).setQuantity(itemsList.get(itemsList.indexOf(eMenu)).getQuantity() + eMenu.getQuantity());
////                        } else {
////                            itemsList.add((EMenu) FunctionManager.deepClone(eMenu));
////                        }
////                    }
////                }
////            }
////
////            //Cancelled Orders
////            for (Ordering ordering : order.getOrderings()) {
////                for (EMenu eMenu : ordering.getOrderItems()) {
////                    if (eMenu.getStatus() == Table.STATUS_CANCELED) {
////                        if (itemsList.contains(eMenu)) {
////                            itemsList.get(itemsList.indexOf(eMenu)).setQuantity(itemsList.get(itemsList.indexOf(eMenu)).getQuantity() + eMenu.getQuantity());
////                        } else {
////                            itemsList.add((EMenu) FunctionManager.deepClone(eMenu));
////                        }
////                    }
////                }
////            }
////
////            if (itemsList.size() > 0) {
////                String itemsListStr = "";
////                if (itemsList.get(0).getStatus() != Table.STATUS_CANCELED) {
////                    itemsListStr += "(" + itemsList.get(0).getSumQuantity() + ")" + itemsList.get(0).getName() + " " + itemsList.get(0).getSelectedVariantStr();
////                } else {
////                    itemsListStr += "(*)" + itemsList.get(0).getName() + " " + itemsList.get(0).getSelectedVariantStr();
////                }
////
////                for (int i = 1; i < itemsList.size(); i++) {
////                    if (itemsList.get(i).getStatus() != Table.STATUS_CANCELED) {
////                        itemsListStr += ", (" + itemsList.get(i).getSumQuantity() + ")" + itemsList.get(i).getName() + " " + itemsList.get(i).getSelectedVariantStr();
////                    } else {
////                        itemsListStr += ", (*)" + itemsList.get(i).getName() + " " + itemsList.get(i).getSelectedVariantStr();
////                    }
////
////                }
////                content += itemsListStr + "\n";
////            }
////            String paidStr = ResourceManager.currencyFormatter(order.getPayment().getPaidAmount());
////            String user = UserManager.LOGGED_USER.getUserName();
////
////            content += String.format("%s%" + (length - user.length()) + "s\n", user,
////                    order.getPayment().getSelectedPaymentType() + "[" + paidStr + "]");
////
////            //--------------------------------
////            content += String.format(generateLine(length, '-'));
////        }
////
////        content += "\n\n\n";
////
////
////        return print(content, printer);
////    }
////
////    public boolean printCancelOrder(String printer, Order order, ArrayList<EMenu> eMenuArrayList, String tableName, int task) {
////        String content = "";
////        int length = CHAR_LENGTH_58;
////        Date date = new Date();
////        String dateStr;
////        dateStr = new SimpleDateFormat("dd-MMM/KK:mm a").format(date);
////
////        String orderId = order.getOrderId();
////        StringAlignUtils util = new StringAlignUtils(length, StringAlignUtils.Alignment.CENTER);
////
////        //Header
////        content += String.format("%s%" + (length - dateStr.length()) + "s\n", dateStr, orderId);
////        String heading = "";
////        if (task == ResourceManager.TASK_ORDER_STATION) {
////            heading = tableName;
////        } else {
////            if (!order.getTableNote().equalsIgnoreCase("")) {
////                heading = order.getTableNote() + " / " + tableName + order.getOrderId().substring(4, 7);
////            } else {
////                heading = tableName + order.getOrderId().substring(4, 7);
////            }
////        }
////
////        //Table & Queue Number
////        content += util.format(heading + " (Cancelled)");
////        content += ("Cancelled by: " + UserManager.LOGGED_USER.getUserName() + "\n");
////
////        //--------------------------------
////        content += String.format(generateLine(length, '-'));
////
////        content += ("Cancelled Order: ") + "\n";
////
////        for (EMenu eMenu : eMenuArrayList) {
////            OrderingPrinter orderingPrinter = ResourceManager.ORDERING_PRINTERS.
////                    get(FunctionManager.getOrderingPrinterIndexByUID(ResourceManager.ORDERING_PRINTERS, eMenu.getOrderingPrinter()));
////            if (orderingPrinter.getUID().equalsIgnoreCase(eMenu.getOrderingPrinter())) {
////                content += String.format("*%2d %s %s\n", eMenu.getQuantity(), eMenu.getName(), eMenu.getSelectedVariantStr() + " (" + eMenu.getOrderNoteSumStr() + ")");
////
//////                    mPrinter.addText();
////
////            }
////
////        }
////
////        content += "\n\n\n";
////
////
////        return print(content, printer);
////    }
////
////
////
////    public int printBill(String printer, Order order, String tableName, Payment payment, Boolean isPaid, int task) {
////        String content = "";
////        ArrayList<EMenu> printedMenu = new ArrayList<>();
////        int length1 = CHAR_LENGTH_58;
////        StringAlignUtils util = new StringAlignUtils(length1, StringAlignUtils.Alignment.CENTER);
//////        try {
////        //Print Header
////        //Print Logo
//////            if (ResourceManager.RECEIPT.isPrintLogo()) {
//////                Bitmap logo = null;
//////
//////                if (ResourceManager.RECEIPT.getImagePath().equalsIgnoreCase("")) {
//////                    logo = BitmapFactory.decodeResource(activity.getResources(), R.drawable.restobuddies);
//////                    logo = FunctionManager.resize(logo, 400, 400);
//////                    System.out.println("Width: "+logo.getWidth()+": Height: "+logo.getHeight());
//////                } else {
//////                    File file = Environment.getExternalStoragePublicDirectory(
//////                            "RestoBuddies");
//////                    Image image = FunctionManager.getImageByUID(ResourceManager.RECEIPT.getImagePath());
//////                    File newFile = new File(file.getAbsolutePath() + "/" + image.getLocalFileName());
//////                    if (newFile.exists()) {
//////                        System.out.println("file exist "+ newFile.getAbsolutePath());
//////
//////                        logo = BitmapFactory.decodeFile(newFile.getAbsolutePath());
////////                        Uri imageUri = Uri.parse(newFile.getAbsolutePath());
////////                        logo = MediaStore.Images.Media.getBitmap(activity.getContentResolver(), imageUri);
//////                        logo = FunctionManager.resize(logo, 400, 400);
//////                        System.out.println("Width: "+logo.getWidth()+": Height: "+logo.getHeight());
////////                        Uri savedImageURI = Uri.parse(newFile.getAbsolutePath());
////////                        menuIV.setImageURI(savedImageURI);
//////                    }else{
//////                        logo = BitmapFactory.decodeResource(activity.getResources(), R.drawable.restobuddies);
//////                        logo = FunctionManager.resize(logo, 400, 400);
//////                        System.out.println("Width: "+logo.getWidth()+": Height: "+logo.getHeight());
//////                    }
//////                }
////
//////                if (logo != null) {
//////                    if (mode == PRINT_50MM_NORMAL) {
//////
//////                    } else {
//////                        mPrinter.addImage(logo, 0, 0, logo.getWidth(), logo.getHeight(), Printer.PARAM_DEFAULT,
//////                                Printer.PARAM_DEFAULT, Printer.PARAM_DEFAULT, Printer.PARAM_DEFAULT, Printer.PARAM_DEFAULT);
//////                    }
//////                }
//////                mPrinter.addFeedUnit(5);
//////            }
////        //Print Header Title
////        if (!UpdateManager.getReceiptSetting().getHeaderTitle().equalsIgnoreCase("")) {
////            String titles[] = UpdateManager.getReceiptSetting().getHeaderTitle().split("\n");
////            for (String title : titles) {
////                content += (util.format(title));
////            }
////        }
////
////        String titlesContent[] = UpdateManager.getReceiptSetting().getHeaderContent().split("\n");
////        for (String titleContent : titlesContent) {
////            content += (util.format(titleContent));
////        }
////
//////        if (!ResourceManager.RECEIPT.getHeaderTitle().equalsIgnoreCase("")) {
//////            String titles[] = ResourceManager.RECEIPT.getHeaderTitle().split("\n");
//////            for (String title : titles) {
//////                content += (util.format(title));
//////            }
//////        }
//////
//////        String titlesContent[] = ResourceManager.RECEIPT.getHeaderContent().split("\n");
//////        for (String titleContent : titlesContent) {
//////            content += (util.format(titleContent));
//////        }
////        //--------------------------------
////        content += String.format(generateLine(length1, '-')) + "\n";
//////            mPrinter.addText(String.format(generateLine(length1, '-')) + "\n");
////
////        Date date = new Date();
////        String dateStr = new SimpleDateFormat("dd-MMM-yy KK:mm:ss a").format(date);
////
////        content += "Date     : " + dateStr + "\n";
////        content += "Order ID : " + order.getOrderId() + "\n";
////
////        if (task == ResourceManager.TASK_ORDER_STATION) {
////            content += "Table/Pax: " + tableName + " / " + order.getNoOfPax() + "\n";
////        } else {
////            content += "Queue/Name: " + tableName + order.getOrderId().substring(4, 7) + " / " + order.getTableNote() + "\n";
////        }
////        content += cashierTitleName + " : " + UserManager.LOGGED_USER.getUserName() + "\n";
////        //--------------------------------
////        content += generateLine(length1, '-') + "\n";
////
////        for (Ordering ordering : order.getOrderings()) {
////            for (EMenu eMenu : ordering.getOrderItems()) {
////                if (eMenu.getStatus() == Table.STATUS_CONFIRMED || eMenu.getStatus() == Table.STATUS_PAID) {
////                    if (printedMenu.contains(eMenu)) {
////                        printedMenu.get(printedMenu.indexOf(eMenu)).setQuantity(printedMenu.get(printedMenu.indexOf(eMenu)).getQuantity() + eMenu.getQuantity());
////                    } else {
////                        printedMenu.add((EMenu) FunctionManager.deepClone(eMenu));
////                    }
////                }
////            }
////        }
////
////
////        for (EMenu printMenu : printedMenu) {
////            String printedItem = printMenu.getName();
////            if (!printMenu.getSelectedVariantStr().equalsIgnoreCase("")) {
////                printedItem += " (" + printMenu.getSelectedVariantStr() + ")";
////            }
////            printedItem += " @" + ResourceManager.currencyFormatter(printMenu.getEachItemPrice());
////            if (printMenu.getDiscount() > 0) {
////                printedItem += " | Disc. ";
////                if (!printMenu.getDiscountStr().equalsIgnoreCase("")) {
////                    printedItem += "(" + printMenu.getDiscountStr() + ") ";
////                }
////                printedItem += ResourceManager.currencyFormatter(printMenu.getDiscount());
////
////            }
////
////            System.out.println(printedItem);
////            //Split Items content by length;
////
////
////            ArrayList<String> printedItems = new ArrayList<>();
////            int length = length1 - 3 - 10;
////
////            String chuckedItems[] = printedItem.split(" ");
////
////            int lineIndex = 0;
////            for (String chuckStr : chuckedItems) {
////                if (printedItems.size() == 0) {
////                    printedItems.add(chuckStr);
////                } else {
////                    if ((printedItems.get(lineIndex).length() + chuckStr.length() + 1) <= length) {
////                        printedItems.set(lineIndex, printedItems.get(lineIndex) + " " + chuckStr);
////                    } else {
////                        lineIndex++;
////                        printedItems.add(chuckStr);
////                    }
////                }
////            }
////
//////                for (int i = 0; i < printedItem.length(); i += length) {
//////                    System.out.println(printedItem.substring(i, Math.min(i+length, printedItem.length())));
//////                    printedItems.add(printedItem.substring(i, Math.min(i+length, printedItem.length())));
//////                }
////
////            System.out.println("1st line: " + String.format("%2d %-" + (length1 - 3 - 10) + "s%10s\n", printMenu.getQuantity(), printedItems.get(0), ResourceManager.currencyFormatter(printMenu.getSubTotalPrice())));
////            content += String.format("%2d %-" + (length) + "s%10s\n", printMenu.getQuantity(), printedItems.get(0), ResourceManager.currencyFormatter(printMenu.getSubTotalPrice()));
////            if (printedItems.size() > 1) {
////                System.out.println("Size: " + printedItems.size());
////                for (int i = 1; i < printedItems.size(); i++) {
////                    System.out.println(i + " line: " + "   " + printedItems.get(i));
////                    content += ("   " + printedItems.get(i) + "\n");
////                }
////            }
////        }
////
////        //--------------------------------
////        content += String.format(generateLine(length1, '-')) + "\n";
////        String printStr = "SUB-TOTAL:";
////        content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, ResourceManager.CURRENCY_SYMBOL + " " + ResourceManager.currencyFormatter(payment.getSubtotal()));
////
////        if (payment.getTaxBeforeAmount() != 0) {
////            printStr = payment.getTaxBeforeName() + "(" + payment.getTaxBeforePercent() + "%):";
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, "+" + ResourceManager.currencyFormatter(payment.getTaxBeforeAmount()));
////        }
////        if (payment.getDiscountAmount() != 0) {
////            printStr = "Total Discount:";
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, "-" + ResourceManager.currencyFormatter(payment.getDiscountAmount()));
////        }
////        if (payment.getTaxAmount() != 0) {
////            printStr = payment.getTaxName() + "(" + payment.getTaxPercent() + "%):";
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, "+" + ResourceManager.currencyFormatter(payment.getTaxAmount()));
////        }
////        if (payment.getSelectedPaymentFeeAmount() != 0) {
////            printStr = "Transaction Fee(" + payment.getSelectedPaymentFeePercent() + "%)";
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, "+" + ResourceManager.currencyFormatter(payment.getSelectedPaymentFeeAmount()));
////        }
////        if (payment.getRoundingAmount() != 0) {
////            printStr = "Rounding:";
////
////            String roundingSign = "";
////            if (payment.getRoundingAmount() > 0) {
////                roundingSign = "+";
////            }
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, roundingSign + ResourceManager.currencyFormatter(payment.getRoundingAmount()));
////        }
////
////        //--------------------------------
////        content += String.format(generateLine(length1, '-')) + "\n";
////        printStr = "TOTAL:";
////        content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, ResourceManager.CURRENCY_SYMBOL + " " + ResourceManager.currencyFormatter(payment.getTotal()));
////
////        if (isPaid) {
////            //--------------------------------
////            content += String.format(generateLine(length1, '-')) + "\n";
////            printStr = "PAID:";
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n", printStr, ResourceManager.CURRENCY_SYMBOL + " " + ResourceManager.currencyFormatter(payment.getPaidAmount()));
////
////            //--------------------------------
////            content += String.format(generateLine(length1, '-')) + "\n";
////            printStr = "CHANGE:";
////            content += String.format("%s%" + (length1 - printStr.length()) + "s\n\n", printStr, ResourceManager.CURRENCY_SYMBOL + " " + ResourceManager.currencyFormatter(payment.getChange()));
////
////            content += payment.getSelectedPaymentPrintFooter() + "\n";
////
////            if (!payment.getPaymentNote().equalsIgnoreCase("")) {
////                //--------------------------------
////                content += String.format(generateLine(length1, '-')) + "\n";
////                content += payment.getPaymentNote() + "\n\n";
////            }
////
////        }
////
////
////        //Print Footer
////        String footers[] = UpdateManager.getReceiptSetting().getFooter().split("\n");
//////        String footers[] = ResourceManager.RECEIPT.getFooter().split("\n");
////
////        for (String footer : footers) {
////            content += (util.format(footer));
////        }
////        content += "Powered by: RestoBuddies.com\n";
////
////        content += "\n\n\n";
////
////        print(content, printer);
//////            mPrinter.addText("Thank You\n");
//////            mPrinter.addFeedUnit(10);
//////            mPrinter.addText("Follow us @pinktempong (instagram)\n");
////
////        //Branding Restobuddies
//////            mPrinter.addTextAlign(Printer.ALIGN_RIGHT);
//////            Bitmap branding = BitmapFactory.decodeResource(activity.getResources(), R.drawable.poweredby1);
//////            branding = FunctionManager.resize(branding, 500, 500);
//////            mPrinter.addImage(branding, 0, 0, branding.getWidth(), branding.getHeight(), Printer.PARAM_DEFAULT,
//////                    Printer.PARAM_DEFAULT, Printer.PARAM_DEFAULT, Printer.PARAM_DEFAULT, Printer.PARAM_DEFAULT);
//////
//////            mPrinter.addCut(Printer.CUT_FEED);
//////        } catch (Epos2Exception e) {
//////            e.printStackTrace();
//////            Toast.makeText(ResourceManager.CURRENT_ACTIVITY, "Failed to Print: " + PrinterFunctions.getEposExceptionText(e.getErrorStatus()), Toast.LENGTH_LONG).show();
//////            System.out.println("Error Status: " + PrinterFunctions.getEposExceptionText(e.getErrorStatus()));
//////            System.out.println("Message: " + e.getMessage());
//////            System.out.println("Message 2: " + e.getLocalizedMessage());
//////            System.out.println("Cause: "+e.getCause().toString());
//////            return e.getErrorStatus();
//////        }
////        return -1;
////    }
//}
//
