package com.example.mylibrary.firestore;

public class FirestorePath {
    public static String getCompaniesPath() {
        return "/Companies";
    }

    public static String getCompanyPath(String companyId) {
        return getCompaniesPath() + "/" + companyId;
    }

    //ONLINE ORDER
    public static String getOnlineOrderColPath() {
        return "/OnlineOrders";
    }

    //MasterData
    public static String getMasterDataPath(String companyId) {
        return getCompanyPath(companyId) + "/MasterData";
    }

    public static String getMasterDataStocksColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Stock/Stocks";
    }

    public static String getMasterDataStockCategoriesColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Stock/StockCategories";
    }

    public static String getMasterDataProductsColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Product/Products";
    }

    public static String getMasterDataProductCategoriesColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Product/ProductCategories";
    }

    public static String getMasterDataVariantsColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Variant/Variants";
    }

    public static String getMasterDataVariantCategoriesColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Variant/VariantCategories";
    }

    public static String getVariantItemPricingByIdVariantColPath(String companyId, String VariantsId) {
        return getMasterDataPath(companyId) + "/Variant/Variants" + VariantsId + "/variantItems/pricingList";
    }

    public static String getMasterDataRecipesColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Recipe/Recipes";
    }

    public static String getMasterDataRecipeCategoriesColPath(String companyId) {
        return getMasterDataPath(companyId) + "/Recipe/RecipeCategories";
    }

    public static String getMasterDataPrinterPath(String companyId) {
        return getMasterDataPath(companyId) + "/Printer/Printers";
    }

    public static String getMasterDataPaymentTypesPath(String companyId) {
        return getMasterDataPath(companyId) + "/PaymentType/PaymentTypes";
    }

    public static String getMasterDataOrderTypePath(String companyId) {
        return getMasterDataPath(companyId) + "/OrderType/OrderTypes";
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Outlet Setting Path~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String getSettingsPath(String outletId) {
        return getOutletPathById(outletId) + "/Settings";
    }
    public static String getSessionPath(String outletId){
        return getOutletPathById(outletId) + "/Sessions";
    }

    public static String getPaymentsPath(String outletId){
        return getOutletPathById(outletId) + "/Payments";
    }

    public static String getOutletDataReceiptPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/Receipt";
    }

    public static String getOutletDataPrinterPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/Printer";
    }

    public static String getOutletDataRecipePath(String outletId) {
        return getOutletDataDataPath(outletId) + "/Recipe";
    }
    public static String getOutletDataRecipeCategoriesPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/RecipeCategories";
    }

    public static String getOutletDataPaymentTypesPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/PaymentTypes";
    }

    public static String getOutletDataOrderTypePath(String outletId) {
        return getOutletDataDataPath(outletId) + "/OrderTypes";
    }

    public static String getOutletDataDataPath(String outletId) {
        return getSettingsPath(outletId) + "/Data";
    }

    public static String getOutletDataProductsPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/Products";
    }

    public static String getOutletDataProductCategoriesPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/ProductCategories";
    }

    public static String getOutletDataProductsPathById(String outletId, String productId) {
        return getOutletDataProductsPath(outletId) + "/" + productId;
    }

    public static String getOutletDataVariantsPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/Variants";
    }

    public static String getOutletDataVariantsCategoriesPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/VariantCategories";
    }

    public static String getOutletDataVariantPathById(String outletId, String variantId) {
        return getOutletDataVariantsPath(outletId) + "/" + variantId;
    }

    public static String getOutletDataStockPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/Stocks";
    }

    public static String getOutletDataStockCategoriesPath(String outletId) {
        return getOutletDataDataPath(outletId) + "/StockCategories";
    }


//    public static String getMasterDataAttendancesColPath(String companyId) {
//        return getMasterDataPath(companyId) + "/Attendances/Attendances";
//    }
//
//    public static String getMasterDataLeavesColPath(String companyId) {
//        return getMasterDataPath(companyId) + "/Leaves/Leaves";
//    }


//    public static String getStockPathById(String stockId) {
//        return getStocksPath() + "/" + stockId;
//    }

//    public static String getStockCategoriesPath() {
//        return getStockMasterDataPath() + "/StockCategories";
//    }
//
//    public static String getStockCategoryPathById(String stockCategoryId) {
//        return getStockCategoriesPath() + "/" + stockCategoryId;
//    }

    public static String getProductMasterDataPath() {
        return "/MasterData/Product";
    }

    public static String getProductCategoriesPath() {
        return getProductMasterDataPath() + "/ProductCategories";
    }

    public static String getProductCategoryPathById(String productCategoryId) {
        return getProductCategoriesPath() + "/" + productCategoryId;
    }

    public static String getProductsPath() {
        return getProductMasterDataPath() + "/Products";
    }

    public static String getProductPathById(String productId) {
        return getProductsPath() + "/" + productId;
    }

    public static String getVariantMasterDataPath() {
        return "/MasterData/Variant";
    }

    public static String getVariantCategoriesPath() {
        return getVariantMasterDataPath() + "/VariantCategories";
    }

    public static String getVariantCategoryPathById(String variantCategoryId) {
        return getVariantCategoriesPath() + "/" + variantCategoryId;
    }

    public static String getVariantsPath() {
        return getVariantMasterDataPath() + "/Variants";
    }

    public static String getVariantPathById(String variantId) {
        return getVariantsPath() + "/" + variantId;
    }

    public static String getWalletMasterDataPath() {
        return "/MasterData/Wallet";
    }

    public static String getWalletsPath() {
        return getWalletMasterDataPath() + "/Wallet";
    }

    public static String getWalletsPathById(String walletsId) {
        return getWalletsPath() + "/" + walletsId;
    }

    public static String getRecipesMasterDataPath() {
        return "/MasterData/Recipe";
    }

    public static String getRecipesCategoryPath() {
        return getRecipesMasterDataPath() + "/RecipeCategories";
    }

    public static String getRecipesCategoryPathById(String recipesCategoryId) {
        return getRecipesCategoryPath() + "/" + recipesCategoryId;
    }

    public static String getRecipesPath() {
        return getRecipesMasterDataPath() + "/Recipes";
    }

    public static String getVariantPath() {
        return  getVariantMasterDataPath() + "/Variant";
    }

    public static String getRecipesPathById(String recipesId) {
        return getRecipesPath() + "/" + recipesId;
    }

    public static String getStorageRecipesPath(String storageId) {
        return getStoragePathById(storageId) + "/Recipes";
    }

    public static String getStorageRecipePathById(String storageId, String recipeId) {
        return getStorageRecipesPath(storageId) + "/" + recipeId;
    }

    public static String getProductPath() {
        return getProductMasterDataPath() + "/Product";
    }

//    public static String getStock() {
//        return getStockMasterDataPath() + "Stock";
//    }

    public static String getKitchensPath() {
        return "/Kitchens";
    }

    public static String getKitchenPathById(String kitchenId) {
        return getKitchensPath() + "/" + kitchenId;
    }

    public static String getOutletsPath() {
        return "/Outlets";
    }

    public static String getOutletColPath(){
        return "Outlets";
    }

    public static String getOutletPathById(String outletId) {
        return getOutletsPath() + "/" + outletId;
    }

    public static String getOrdersPath(String outletId) {
        return getOutletPathById(outletId) + "/Orders";
    }

    public static String getSettlementsPath(String outletId) {
        return getOutletPathById(outletId) + "/Settlements";
    }
    public static String getReceiptDocPath(String outletId) {
        return getSettingPath(outletId) + "/Receipt";
    }
    public static String getPrintersColPath(String outletId) {
        return getSettingPath(outletId) + "/Data/Printers";
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~STORAGE PATH~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public static String getStoragesPath() {
        return "/Storages";
    }

    public static String getStoragePathById(String storageId) {
        return getStoragesPath() + "/" + storageId;
    }

    public static String getStorageTransactionsPath(String storageId) {
        return getStoragePathById(storageId) + "/Transactions";
    }

    public static String getStorageTransactionPathById(String storageId, String transactionId) {
        return getStorageTransactionsPath(storageId) + "/" + transactionId;
    }

    public static String getStorageStocksPath(String storageId) {
        return getStoragePathById(storageId) + "/Stocks";
    }

    public static String getStorageStocksPathById(String storageId, String stockId) {
        return getStorageStocksPath(storageId) + "/" + stockId;
    }

    public static String getUsersPath() {
        return "/Users";
    }

    public static String getUsersCompanyPath() {
        return "/UsersCompany";
//        return "Users";
    }

    public static String getSettingPath(String outletId) {
        return getOutletPathById(outletId) + "/Settings";
    }

    public static String getPrintersPath(String outletId) {
        return getSettingPath(outletId) + "/Printer";
    }

    public static String getOrderingPrintersPath(String outletId) {
        return getPrintersPath(outletId) + "/OrderingPrinters";
    }

    public static String getOrderCounterPath(String outletId) {
        return getSettingPath(outletId) + "/OrderCounter";
    }

    public static String getSettledStatus(String outletId) {
        return getSettingPath(outletId) + "/SettledStatus";
    }

    public static String getSettlementPath(String outletId) {
        return getSettingPath(outletId) + "/Settlements";
    }

    public static String getWalletListPath() {
        return "/Wallet";
    }

    public static String getWalletPath(String walletId) {
        return getWalletListPath() + "/" + walletId;
    }

    public static String getWalletTransactionListPath() {
        return "/WalletTransaction";
    }

    public static String getWalletTransactionPath(String walletTransactionId) {
        return getWalletTransactionListPath() + "/" + walletTransactionId;
    }

    public static String getImagePath(String outletId) {
        return  "/"+outletId+"/";
    }

    public static String getStockCategoriesPath() {
        return null;
    }

}
