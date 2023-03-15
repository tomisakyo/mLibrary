package com.example.mylibrary.utility;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.mylibrary.model.Ingredient;
import com.example.mylibrary.model.Order;
import com.example.mylibrary.model.OrderItem;
import com.example.mylibrary.model.OrderItemVariant;
import com.example.mylibrary.model.OrderType;
import com.example.mylibrary.model.Outlet;
import com.example.mylibrary.model.PaymentType;
import com.example.mylibrary.model.Pricing;
import com.example.mylibrary.model.Printer;
import com.example.mylibrary.model.PrinterHolder;
import com.example.mylibrary.model.Product;
import com.example.mylibrary.model.ProductCategory;
import com.example.mylibrary.model.Recipe;
import com.example.mylibrary.model.Settlement;
import com.example.mylibrary.model.Stock;
import com.example.mylibrary.model.StockCategory;
import com.example.mylibrary.model.StockQuantityHolder;
import com.example.mylibrary.model.StockTransaction;
import com.example.mylibrary.model.StockTransactionItem;
import com.example.mylibrary.model.Storage;
import com.example.mylibrary.model.StorageStockHolder;
import com.example.mylibrary.model.User;
import com.example.mylibrary.model.UserCompany;
import com.example.mylibrary.model.Variant;
import com.example.mylibrary.model.VariantCategory;
import com.example.mylibrary.model.Wallet;
import com.example.mylibrary.model.WalletTransaction;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class FunctionManager {

    public static String currencyFormatter(double val) {
        NumberFormat kursRupiah = (NumberFormat) NumberFormat.getInstance();
        kursRupiah.setMaximumFractionDigits(0);

        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setGroupingSeparator('.');

        return kursRupiah.format(val);
    }

    public static <T> Collection<T> filter(Collection<T> target, IPredicate<T> predicate) {
        Collection<T> result = new ArrayList<T>();
        for (T element : target) {
            if (predicate.apply(element)) {
                result.add(element);
            }
        }
        return result;
    }

    //Receipt Printer Functions
    public static PrinterHolder convertPrinterFromString(String objStr) {
        Gson gson = new GsonBuilder().create();
        PrinterHolder obj = gson.fromJson(objStr, new TypeToken<PrinterHolder>() {
        }.getType());
        return obj;
    }

    public static String convertPrinterToString(PrinterHolder obj) {
        Gson gson = new GsonBuilder().create();
        String objStr = gson.toJson(obj);
        return objStr;
    }

    //Ordering Printer Functions
    public static ArrayList<PrinterHolder> convertPrintersFromString(String objStr) {
        Gson gson = new GsonBuilder().create();
        ArrayList<PrinterHolder> obj = gson.fromJson(objStr, new TypeToken<ArrayList<PrinterHolder>>() {
        }.getType());
        return obj;
    }

    public static String getPrinterNameById(List<Printer> list, String id) {
        for(Printer printer : list){
            if (printer.getName().equalsIgnoreCase(id))
                return printer.getName();
        }
        return null;
    }

    public static String convertPrintersToString(ArrayList<PrinterHolder> obj) {
        Gson gson = new GsonBuilder().create();
        String objStr = gson.toJson(obj);
        return objStr;
    }

    public static Printer getPrinterObjectById(List<Printer> printers, String printerId){
        for(int i =0;i<printers.size();i++){
            if (printers.get(i).getUID().equalsIgnoreCase(printerId))
                return printers.get(i);
        }
        return null;
    }


    public static StockQuantityHolder convertQuantityHolderFromStock(Stock stockQuantityHolder) {
        StockQuantityHolder result = new StockQuantityHolder();
        result.setQuantity(stockQuantityHolder.getQuantity());
        result.setMinimumStockLevel(stockQuantityHolder.getMinimumStockLevel());
        result.setStockName(stockQuantityHolder.getName());
        result.setStockId(stockQuantityHolder.getStockId());
        return result;
    }

    public static String getTotalIngredientPreviewStr(Recipe recipe, int portion, ArrayList<Stock> stockArrayList) {
        String ingredientPreviewStr = "";
        ingredientPreviewStr += portion + " Portion=";
        for (Ingredient ingredient : recipe.getIngredientList()) {
            int indexStock = FunctionManager.getStockIndexByID(stockArrayList, ingredient.getStockId());
            if (indexStock == -1) {
                throw new IllegalArgumentException("Your Storage Doesn't have " + ingredient.getStockName() + " As Ingredient for this Recipe");
            } else {
                Stock stock = stockArrayList.get(indexStock);
                ingredientPreviewStr += "\n*" + stock.getName() + " " + getFormattedStockQuantityHorizontal(stock, ingredient.getQuantity() * portion);
            }
        }

        return ingredientPreviewStr;
    }

    public static String getFormattedStockQuantityVertical(Stock stock, int quantity) {
        String str = "";
        int unit1Value = quantity;
        int unit2Value = 0;
        int unit3Value = 0;

        if (stock.isHasUnit2()) {
            unit1Value = quantity % stock.getUnit1ValueOverUnit2();
            unit2Value = (quantity - unit1Value) / stock.getUnit1ValueOverUnit2();
        }
        if (stock.isHasUnit3()) {
            int tempUnit2Value = unit2Value;
            unit2Value = tempUnit2Value % stock.getUnit2ValueOverUnit3();
            unit3Value = (tempUnit2Value - unit2Value) / stock.getUnit2ValueOverUnit3();
        }

        if (unit3Value > 0) {
            str += unit3Value + " " + stock.getUnit3();
        }
        if (unit2Value > 0) {
            if (str.trim().length() > 0) {
                str += "\n";
            }
            str += unit2Value + " " + stock.getUnit2();
        }
        if (unit1Value > 0) {
            if (str.trim().length() > 0) {
                str += "\n";
            }
            str += unit1Value + " " + stock.getUnit1();
        }

        if (str.trim().equalsIgnoreCase("")) {
            str += quantity + " " + stock.getUnit1();
        }

        return str;
    }

    public static String getFormattedStockQuantityHorizontal(Stock stock, int quantity) {
        String str = "";
        int unit1Value = quantity;
        int unit2Value = 0;
        int unit3Value = 0;

        if (stock.isHasUnit2()) {
            unit1Value = quantity % stock.getUnit1ValueOverUnit2();
            unit2Value = (quantity - unit1Value) / stock.getUnit1ValueOverUnit2();
        }
        if (stock.isHasUnit3()) {
            int tempUnit2Value = unit2Value;
            unit2Value = tempUnit2Value % stock.getUnit2ValueOverUnit3();
            unit3Value = (tempUnit2Value - unit2Value) / stock.getUnit2ValueOverUnit3();
        }

        if (unit3Value > 0) {
            str += unit3Value + stock.getUnit3();
        }
        if (unit2Value > 0) {
            if (str.trim().length() > 0) {
                str += ", ";
            }
            str += unit2Value + stock.getUnit2();
        }
        if (unit1Value > 0) {
            if (str.trim().length() > 0) {
                str += ", ";
            }
            str += unit1Value + stock.getUnit1();
        }

        if (str.trim().equalsIgnoreCase("")) {
            str += quantity;
        }

        return str;
    }

    public static int getOutletIndexByID(ArrayList<Outlet> list, String outletID) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOutletId().equalsIgnoreCase(outletID)) {
                return i;
            }
        }
        return -1;
    }

    public static int getStockCategoryIndexByID(ArrayList<StockCategory> list, String stockCategoryId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStockCategoryId().equalsIgnoreCase(stockCategoryId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getStockIndexByID(List<Stock> list, String stockId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStockId().equalsIgnoreCase(stockId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getVariantIndexByID(ArrayList<Variant> list, String variantId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVariantId().equalsIgnoreCase(variantId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getVariantCategoryIndexByID(ArrayList<VariantCategory> list, String variantCategoryId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVariantCategoryId().equalsIgnoreCase(variantCategoryId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getProductCategoryIndexByID(ArrayList<ProductCategory> list, String productCategoryId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductCategoryId().equalsIgnoreCase(productCategoryId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getProductIndexByID(ArrayList<Product> list, String productId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductId().equalsIgnoreCase(productId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getRecipeIndexByID(ArrayList<Recipe> storageRecipeList, String recipeId) {
        for (int i = 0; i < storageRecipeList.size(); i++) {
            if (storageRecipeList.get(i).getRecipeId().equalsIgnoreCase(recipeId)) {
                return i;
            }
        }
        return -1;
    }

    public static PaymentType getPaymentTypeObjectById(List<PaymentType> paymentTypes, String id) {
        for(PaymentType paymentType:paymentTypes){
            if (paymentType.getPaymentTypeId().equalsIgnoreCase(id))
                return paymentType;
        }
        return null;
    }

    public static String getPaymentTypeNameById(List<PaymentType> list, String id) {
        for(PaymentType paymentType : list){
            if (paymentType.getPaymentName().equalsIgnoreCase(id))
                return paymentType.getPaymentName();
        }
        return null;
    }


    public static int getStockTransactionIndexByID(ArrayList<StockTransaction> stockTransactions, String stockTransactionId) {
        for (int i = 0; i < stockTransactions.size(); i++) {
            if (stockTransactions.get(i).getTransactionId().equalsIgnoreCase(stockTransactionId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getUserIndexByID(ArrayList<User> users, String userUID) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserUID().equalsIgnoreCase(userUID)) {
                return i;
            }
        }
        return -1;
    }


    public static int getUserCompanyIndexByID(ArrayList<UserCompany> users, String userUID) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserId().equalsIgnoreCase(userUID)) {
                return i;
            }
        }
        return -1;
    }

    public static StockTransactionItem getStockTransactionItemByID(ArrayList<StockTransactionItem> stockTransactionItems, String stockTransactionId) {
        for (int i = 0; i < stockTransactionItems.size(); i++) {
            if (stockTransactionItems.get(i).getStockId().equalsIgnoreCase(stockTransactionId)) {
                return stockTransactionItems.get(i);
            }
        }
        return null;
    }

    public static StorageStockHolder getStorageStockHolderObjectById(ArrayList<StorageStockHolder> storageStockHolders, String storageId) {
        for (int i = 0; i < storageStockHolders.size(); i++) {
            if (storageStockHolders.get(i).getStorage().getStorageId().equalsIgnoreCase(storageId)) {
                return storageStockHolders.get(i);
            }
        }
        return null;
    }

    public static int getStorageById(ArrayList<Storage> storage, String storageId) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getStorageId().equalsIgnoreCase(storageId)) {
                return i;
            }
        }
        return -1;
    }

    public static StockQuantityHolder getStockQuantityHolderObjectById(ArrayList<StockQuantityHolder> stockQuantityHolders, String stockId) {
        for (int i = 0; i < stockQuantityHolders.size(); i++) {
            if (stockQuantityHolders.get(i).getStockId().equalsIgnoreCase(stockId)) {
                return stockQuantityHolders.get(i);
            }
        }
        return null;
    }

    public static boolean hasUnconfirmedTransaction(ArrayList<StockTransaction> stockTransactions) {
        for (StockTransaction stockTransaction : stockTransactions) {
            if (stockTransaction.getTransactionType() == StockTransaction.TRANSACTION_TRANSFER_IN && !stockTransaction.isConfirmed()) {
                return true;
            }
        }
        return false;
    }

    public static int getSettlementIndexByID(ArrayList<Settlement> settlementArrayList, String settlementId) {
        for (int i = 0; i < settlementArrayList.size(); i++) {
            if (settlementArrayList.get(i).getSettlementId().equalsIgnoreCase(settlementId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getWalletIndexByID(ArrayList<Wallet> list, String walletId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWalletId().equalsIgnoreCase(walletId)) {
                return i;
            }
        }
        return -1;
    }

    public static int getWalletTransactionIndexByID(ArrayList<WalletTransaction> list, String walletTransactionId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWalletTransactionId().equalsIgnoreCase(walletTransactionId)) {
                return i;
            }
        }
        return -1;
    }

    public static Pricing getPricingObjectByOrderTypeId(List<Pricing> pricings, String id) {
        for(Pricing pricing:pricings){
            if (pricing.getOrderTypeId().equalsIgnoreCase(id))
                return pricing;
        }
        return null;
    }

    public static OrderType getOrderTypeById(List<OrderType> list, String id) {
        for(OrderType orderType:list){
            if (orderType.getOrderTypeID().equalsIgnoreCase(id))
                return orderType;
        }
        return null;
    }
    public static void closeKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);

        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();

        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) view = new View(activity);

        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    //ORDER FUNCTIONS
    public static String getVariantsName(OrderItem orderItem){
        String variantsName ="";
        boolean first =true;
        for(OrderItemVariant orderItemVariant: orderItem.getVariants()){
            if(!first){
                variantsName+=" | ";
            }
            variantsName+=orderItemVariant.getVariantItemName();
            first=false;
        }
        return variantsName;
    }

    public static double getSubtotal(Order order){
        double subtotal =0;
        for(OrderItem orderItem:order.getOrderItems()){
            subtotal+= (orderItem.getEachItemPrice()*orderItem.getQuantity());
        }
        return subtotal;
    }

    public static double getTotal(Order order,OrderType orderType){
        double subtotal =0;
        for(OrderItem orderItem:order.getOrderItems()){
            subtotal+= (orderItem.getEachItemPrice()*orderItem.getQuantity());
        }
//        if(orderType.isTaxBeforeEnabled()) {
//            double taxBefore = orderType.getTaxBeforePercent()/100*subtotal;
//            subtotal += taxBefore;
//        }
//        if(orderType.isTaxEnabled()) {
//            double tax = orderType.getTaxPercent()/100*subtotal;
//            subtotal += tax;
//        }
        return subtotal;
    }

    public static int getTotalProductQuantity(Order order) {
        int result = 0;
        if (order.getOrderItems() != null) {
            for (OrderItem orderItem : order.getOrderItems()) {
                result += orderItem.getQuantity();
            }
        }
        return result;
    }

    public static String generateOrderID(String init) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int hourStamp = calendar.get(Calendar.HOUR_OF_DAY);
        int minutesStamp = calendar.get(Calendar.MINUTE);
        int timeStamp = (((hourStamp * 60) + minutesStamp) * 99) / 1440;

        String orderID = String.format("%ty%tm%td%02d%s%s",date, date, date, timeStamp, UUID.randomUUID().toString().substring(0,2), init);
        return orderID;
    }

    public static String formatIdr(double amount){
        return String.format(Locale.getDefault(), "Rp %,d", (int)amount);
    }

    public static String formatMoney(double amount){
        return String.format(Locale.getDefault(), "%,d", (int)amount);
    }

    public static OrderItemVariant getOrderItemVariantObjectById(List<OrderItemVariant> list, String id) {
        for(OrderItemVariant orderItemVariant:list){
            if (orderItemVariant.getVariantId().equalsIgnoreCase(id))
                return orderItemVariant;
        }
        return null;
    }

    public static String getProductCategoryIdByName(List<ProductCategory> list, String name) {
        for(ProductCategory productCategory:list){
            if (productCategory.getCategoryName().equalsIgnoreCase(name))
                return productCategory.getProductCategoryId();
        }
        return null;
    }

    public static PaymentType getPaymentTypeById(List<PaymentType> list, String id) {
        for(PaymentType paymentType:list){
            if (paymentType.getPaymentTypeId().equalsIgnoreCase(id))
                return paymentType;
        }
        return null;
    }

//    public static int getPaymentTypeIndexById(List<PaymentType> list, String id) {
//        for(int i =0;i<list.size();i++){
//            if (list.get(i).getPaymentTypeId().equalsIgnoreCase(id))
//                return i;
//        }
//        return -1;
//    }

    public static Variant getVariantById(List<Variant> variants, String id) {
        for(Variant variant:variants){
            if (variant.getVariantId().equalsIgnoreCase(id))
                return variant;
        }
        return null;
    }

    public static Product getProductById(List<Product> products, String productId){
        for(Product product: products){
            if (product.getProductId().equalsIgnoreCase(productId)){
                return product;
            }
        }
        return null;
    }

    public static User convertUserFromString(String userStr) {
        return null;
    }
}
