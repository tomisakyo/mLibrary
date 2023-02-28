package com.example.mylibrary.model;

import androidx.annotation.Nullable;

import com.example.mylibrary.utility.FunctionManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    public static int STATUS_NOT_CONFIRMED = 100;
    public static int STATUS_CONFIRMED = 110;
    public static int STATUS_PAID = 120;
    public static int STATUS_VOID = 130;
    public static int STATUS_COMPLETED = 140;

    private String orderId;
    private String sessionId;
    private long date;
    private String orderName;
    private List<OrderItem> orderItems;
    private PaymentInvoice paymentInvoice;
    private List<String> payments;
    private String orderNote;
    private int orderStatus;
    private String orderTypeId;

    public Order(String orderId, String sessionId, String orderName, long date, List<OrderItem> orderItems,
                 List<String> payments, String orderNote, int orderStatus, boolean settled, String orderTypeId) {
        this.orderId = orderId;
        this.sessionId = sessionId;
        this.date = date;
        this.orderName = orderName;
        this.orderItems = orderItems;
        this.payments = payments;
        this.orderNote = orderNote;
        this.orderStatus = orderStatus;
        this.orderTypeId = orderTypeId;
    }

    public Order(OrderType orderType, String sessionId) {
        this.orderId = FunctionManager.generateOrderID(orderType.getInit());
        this.sessionId = sessionId;
        this.date = System.currentTimeMillis();
        this.orderName = "";
        this.orderItems = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.orderNote = "";
        this.orderStatus = STATUS_NOT_CONFIRMED;
        this.orderTypeId = orderType.getOrderTypeID();
    }

    public Order(OrderType orderType) {
        this.orderId = FunctionManager.generateOrderID(orderType.getInit());
        this.sessionId = "";
        this.date = System.currentTimeMillis();
        this.orderName = "";
        this.orderItems = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.orderNote = "";
        this.orderStatus = STATUS_NOT_CONFIRMED;
        this.orderTypeId = orderType.getOrderTypeID();
    }

    public Order() {
        this.orderId = FunctionManager.generateOrderID("");
        this.sessionId = "";
        this.date = 0;
        this.orderName = "";
        this.orderItems = new ArrayList<>();
        this.payments = new ArrayList<>();
        this.orderNote = "";
        this.orderStatus = STATUS_NOT_CONFIRMED;
        this.orderTypeId = "";
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public List<String> getPayments() {
        return payments;
    }

    public void setPayments(List<String> payments) {
        this.payments = payments;
    }

    public PaymentInvoice getPaymentInvoice() {
        return paymentInvoice;
    }

    public void setPaymentInvoice(PaymentInvoice paymentInvoice) {
        this.paymentInvoice = paymentInvoice;
    }

    public String getOrderNote() {
        return orderNote;
    }

    public void setOrderNote(String orderNote) {
        this.orderNote = orderNote;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public static Comparator<Order> orderComparatorLastOrderDescending = (o1, o2) -> {
        return new Date(o2.getDate()).compareTo(new Date(o1.getDate()));
//            return (int) (o2.getLastOrder() - o1.getLastOrder());
    };

    public String getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(String orderTypeId) {
        this.orderTypeId = orderTypeId;
    }


    @Override
    public String toString() {
        return "";
    }

    public int getTotalProductQuantity() {
        int result = 0;
        if (orderItems != null) {
            for (OrderItem orderItem : orderItems) {
                result += orderItem.getQuantity();
            }
        }
        return result;
    }

//    public String getOrderItemStrVertical() {
//        StringBuilder result = new StringBuilder("Order Items (" + orderItems.size() + ") : \n");
//        if (!this.orderItems.isEmpty() && orderItems != null) {
//            for (int i = 0; i < orderItems.size(); i++) {
//                OrderItem orderitem = orderItems.get(i);
//                if (orderItems.size() - 1 == i) {
//                    result.append(i + 1).append(". ").append(orderitem.getProductName()).append("(").append(orderitem.getQuantity()).append(")");
//                } else {
//                    if (i + 1 == 3) {
//                        result.append(i + 1).append(". ").append(orderitem.getProductName());
//                    } else if (i + 1 == 4) {
//                        result.append("...");
//                        break;
//                    } else {
//                        result.append(i + 1).append(". ").append(orderitem.getProductName()).append("\n");
//                    }
//                }
//            }
//            if (orderStatus == STATUS_PAID || orderStatus == STATUS_VOID)
//                result.append("\nTotal : " + FunctionManager.currencyFormatter(payment.getTotal()));
//        } else {
//            result.append("No Order items Found");
//        }
//        return result.toString();
//    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(obj instanceof Order) {
            Order order = (Order) obj;
            return getOrderId().equalsIgnoreCase(order.orderId);
        }
        if(obj instanceof String){
            String orderId = (String) obj;
            return getOrderId().equalsIgnoreCase(orderId);
        }
        return false;
    }

    public static Comparator<Order> lastOrderDescendingComparator = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return new Date(o2.getDate()).compareTo(new Date(o1.getDate()));
//            return (int) (o2.getLastOrder() - o1.getLastOrder());
        }
    };
}