package com.example.mylibrary.firestore;

import static com.example.mylibrary.firestore.FirestorePath.getCompaniesPath;
import static com.example.mylibrary.firestore.FirestorePath.getCompanyPath;
import static com.example.mylibrary.firestore.FirestorePath.getKitchenPathById;
import static com.example.mylibrary.firestore.FirestorePath.getKitchensPath;
import static com.example.mylibrary.firestore.FirestorePath.getOutletPathById;
import static com.example.mylibrary.firestore.FirestorePath.getOutletsPath;
import static com.example.mylibrary.firestore.FirestorePath.getRecipesCategoryPath;
import static com.example.mylibrary.firestore.FirestorePath.getRecipesPath;
import static com.example.mylibrary.firestore.FirestorePath.getStoragePathById;
import static com.example.mylibrary.firestore.FirestorePath.getStorageRecipePathById;
import static com.example.mylibrary.firestore.FirestorePath.getStorageRecipesPath;
import static com.example.mylibrary.firestore.FirestorePath.getStorageTransactionsPath;
import static com.example.mylibrary.firestore.FirestorePath.getStoragesPath;
import static com.example.mylibrary.firestore.FirestorePath.getUsersCompanyPath;
import static com.example.mylibrary.firestore.FirestorePath.getUsersPath;
import static com.example.mylibrary.firestore.FirestorePath.getWalletListPath;
import static com.example.mylibrary.firestore.FirestorePath.getWalletPath;
import static com.example.mylibrary.firestore.FirestorePath.getWalletTransactionListPath;
import static com.example.mylibrary.firestore.FirestorePath.getWalletTransactionPath;

import com.example.mylibrary.model.Company;
import com.example.mylibrary.model.Outlet;
import com.example.mylibrary.model.Product;
import com.example.mylibrary.model.ProductCategory;
import com.example.mylibrary.model.Recipe;
import com.example.mylibrary.model.RecipeCategory;
import com.example.mylibrary.model.Stock;
import com.example.mylibrary.model.StockCategory;
import com.example.mylibrary.model.StockQuantityHolder;
import com.example.mylibrary.model.StockTransaction;
import com.example.mylibrary.model.Storage;
import com.example.mylibrary.model.User;
import com.example.mylibrary.model.UserCompany;
import com.example.mylibrary.model.Variant;
import com.example.mylibrary.model.VariantCategory;
import com.example.mylibrary.model.Wallet;
import com.example.mylibrary.model.WalletTransaction;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

public class FirestoreManager {

//    public static Task<DocumentSnapshot> getStockById(final String stockId, FirebaseFirestore instance) {
//        return instance.document(
//                PathManager.getStockPathById(stockId)).get();
//    }
//
//    public static Task<DocumentSnapshot> getStockCategoryById(final String stockCategoryId, FirebaseFirestore instance) {
//        return instance.document(
//                PathManager.getStockCategoryPathById(stockCategoryId)).get();
//    }
//
//    public static Task<Void> saveStockCategory(final StockCategory stockCategory, FirebaseFirestore instance) {
//        return instance.document(
//                PathManager.getStockCategoryPathById(stockCategory.getStockCategoryId())).set(stockCategory);
//    }
//
//    public static Task<Void> saveStock(final Stock stock, FirebaseFirestore instance) {
//        return instance.document(
//                PathManager.getStockPathById(stock.getStockId())).set(stock);
//    }

    public static Task<Void> saveProductCategory(final ProductCategory productCategory, FirebaseFirestore instance) {
        return instance.document(FirestorePath.getProductCategoryPathById(productCategory.getProductCategoryId())).set(productCategory);
    }

    public static Task<Void> saveProduct(final Product product, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getProductPathById(product.getProductId())).set(product);
    }

    public static Task<Void> saveVariantCategory(final VariantCategory variantCategory, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getVariantCategoryPathById(variantCategory.getVariantCategoryId())).set(variantCategory);
    }

    public static Task<Void> saveVariant(final Variant variant, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getVariantPathById(variant.getVariantId())).set(variant);
    }

    public static CollectionReference getVariant(FirebaseFirestore instance) {
        return instance.collection(getVariantPath());
    }

    private static String getVariantPath() {
        return null;
    }

    public static Task<Void> saveWallet(final Wallet Wallet, FirebaseFirestore instance) {
        return instance.document(
                getWalletPath(Wallet.getWalletId())).set(Wallet);
    }

    public static Task<Void> saveWalletTransaction(final WalletTransaction walletTransaction, FirebaseFirestore instance) {
        return instance.document(getWalletTransactionPath(walletTransaction.getWalletTransactionId())).set(walletTransaction);
    }

    public static Task<Void> saveOutletProduct(final Outlet outlet, final Product product, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getOutletDataProductsPathById(outlet.getOutletId(), product.getProductId())).set(product);
    }

    public static Task<Void> removeOutletProduct(final Outlet outlet, final Product product, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getOutletDataProductsPathById(outlet.getOutletId(), product.getProductId())).delete();
    }

    public static Task<Void> saveOutletVariant(final Outlet outlet, final Variant variant, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getOutletDataVariantPathById(outlet.getOutletId(), variant.getVariantId())).set(variant);
    }

    public static Task<Void> removeOutletVariant(final Outlet outlet, final Variant variant, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getOutletDataVariantPathById(outlet.getOutletId(), variant.getVariantId())).delete();
    }

    public static Task<Void> saveCompany(Company company, FirebaseFirestore instance) {
        return instance.collection(getCompaniesPath()).document(company.getCompanyId()).set(company);
    }

    public static CollectionReference getCompanies(FirebaseFirestore instance) {
        return instance.collection(getCompaniesPath());
    }

    public static Task<DocumentSnapshot> getCompanyById(String companyId, FirebaseFirestore instance) {
        return instance.document(getCompanyPath(companyId)).get();
    }

    public static Task<Void> saveOutlet(Outlet outlet, FirebaseFirestore instance) {
        return instance.document(getOutletPathById(outlet.getOutletId())).set(outlet);
    }

    public static Task<QuerySnapshot> getKitchens(String companyId, FirebaseFirestore instance) {
        return instance.collection(getKitchensPath()).whereEqualTo("companyId", companyId).get();
    }


    public static CollectionReference getRecipeCategories(FirebaseFirestore instance) {
        return instance.collection(getRecipesCategoryPath());
    }

    public static Task<Void> saveRecipeCategory(RecipeCategory recipeCategory, FirebaseFirestore instance) {
        return instance.collection(getRecipesCategoryPath()).document(recipeCategory.getRecipeCategoryId()).set(recipeCategory);
    }

    public static CollectionReference getRecipes(FirebaseFirestore instance) {
        return instance.collection(getRecipesPath());
    }

    public static Task<DocumentSnapshot> getRecipeById(String recipeId, FirebaseFirestore instance) {
        return instance.collection(getRecipesPath()).document(recipeId).get();
    }

    public static Task<Void> saveRecipe(Recipe recipe, FirebaseFirestore instance) {
        return instance.collection(getRecipesPath()).document(recipe.getRecipeId()).set(recipe);
    }

    public static Task<QuerySnapshot> getKitchenStorages(String kitchenId, FirebaseFirestore instance) {
        return instance.collection(getStoragesPath())
                .orderBy("companyId", Query.Direction.ASCENDING)
                .whereEqualTo("kitchenId", kitchenId).get();
    }

    public static Task<QuerySnapshot> getStorages(String companyId, FirebaseFirestore instance) {
        return instance.collection(getStoragesPath()).whereEqualTo("companyId", companyId).get();
    }

    public static Task<DocumentSnapshot> getStorageById(String StorageId, FirebaseFirestore instance) {
        return instance.document(getStoragePathById(StorageId)).get();
    }

    public static DocumentReference getStorageByIdDocRef(String StorageId, FirebaseFirestore instance) {
        return instance.document(getStoragePathById(StorageId));
    }

    public static Task<Void> saveStorage(Storage storage, FirebaseFirestore instance) {
        return instance.document(getStoragePathById(storage.getStorageId())).set(storage);
    }

    public static Task<QuerySnapshot> getStorageStocks(final Storage storage, FirebaseFirestore instance) {
        return instance.collection(FirestorePath.getStorageStocksPath(storage.getStorageId())).get();
    }

    public static Task<DocumentSnapshot> getStorageStocksById(final Storage storage, String stockId, FirebaseFirestore instance) {
        return instance.document(FirestorePath.getStorageStocksPathById(storage.getStorageId(), stockId)).get();
    }

    public static Task<Void> saveStorageStock(final Storage storage, final Stock stock, FirebaseFirestore instance) {
        int pos = -1;
        for (StockQuantityHolder stockQuantityHolder : storage.getStockQuantityHolders()) {
            if (stock.getStockId().equals(stockQuantityHolder.getStockId())) {
                pos = storage.getStockQuantityHolders().indexOf(stockQuantityHolder);
                storage.getStockQuantityHolders().get(pos).setMinimumStockLevel(stock.getMinimumStockLevel());
            }
        }

        StockQuantityHolder stockQuantityHolder = new StockQuantityHolder();
        stockQuantityHolder.setMinimumStockLevel(stock.getMinimumStockLevel());
        stockQuantityHolder.setStockId(stock.getStockId());
//        stockQuantityHolder.setQuantity(stock.getQuantity());

        if (pos == -1) {
            storage.getStockQuantityHolders().add(stockQuantityHolder);
        } else {
            storage.getStockQuantityHolders().set(pos, stockQuantityHolder);
        }

        return instance.document(getStoragePathById(storage.getStorageId())).set(storage);
    }

    public static Task<Void> saveStorageStockMinimumStock(final Storage storage, final Stock stock, FirebaseFirestore instance) {
        int pos = -1;
        for (StockQuantityHolder stockQuantityHolder : storage.getStockQuantityHolders()) {
            if (stock.getStockId().equals(stockQuantityHolder.getStockId())) {
                pos = storage.getStockQuantityHolders().indexOf(stockQuantityHolder);
                storage.getStockQuantityHolders().get(pos).setMinimumStockLevel(stock.getMinimumStockLevel());
            }
        }

        if (pos == -1) {
            throw new NullPointerException("Stock not found in stock quantity holder");
        }
        return instance.document(getStoragePathById(storage.getStorageId())).set(storage);
    }

    public static Task<Void> removeStorageStock(final Storage storage, final Stock stock, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getStorageStocksPathById(storage.getStorageId(), stock.getStockId())).delete();
    }

    public static Task<QuerySnapshot> getStorageRecipes(final Storage storage, FirebaseFirestore instance) {
        return instance.collection(getStorageRecipesPath(storage.getStorageId())).get();
    }

    public static Task<Void> saveStockTransaction(final Storage storage, final StockTransaction stockTransaction, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getStorageTransactionPathById(storage.getStorageId(), stockTransaction.getTransactionId())).set(stockTransaction);
    }

    public static Task<Void> saveStockTransaction2(final String storageId, final StockTransaction stockTransaction, FirebaseFirestore instance) {
        return instance.document(
                FirestorePath.getStorageTransactionPathById(storageId, stockTransaction.getTransactionId())).set(stockTransaction);
    }

    public static Task<QuerySnapshot> getStorageTransactions(final Storage storage, FirebaseFirestore instance) {
        return instance.collection(getStorageTransactionsPath(storage.getStorageId())).get();
    }

    public static Task<QuerySnapshot> getUnsettleStockTransactions(final Storage storage, FirebaseFirestore instance) {
        return instance.collection(getStorageTransactionsPath(storage.getStorageId())).whereEqualTo("settled", false).get();
    }

    public static CollectionReference getStorageRecipes(String storageId, FirebaseFirestore instance) {
        return instance.collection(getStorageRecipesPath(storageId));
    }

    public static Task<DocumentSnapshot> getStorageRecipeById(String storageId, String recipeId, FirebaseFirestore instance) {
        return instance.document(getStorageRecipePathById(storageId, recipeId)).get();
    }

    public static DocumentReference getRecipesDocRef(String storageId, Recipe recipe, FirebaseFirestore instance) {
        return instance.document(getStorageRecipePathById(storageId, recipe.getRecipeId()));
    }

    public static Task<Void> saveRecipe(String storageId, Recipe recipe, FirebaseFirestore instance) {
        return getRecipesDocRef(storageId, recipe, instance).set(recipe);
    }

    public static Task<Void> removeRecipe(String storageId, Recipe recipe, FirebaseFirestore instance) {
        return getRecipesDocRef(storageId, recipe, instance).delete();
    }

    public static CollectionReference getStockTransactions(String storageId, FirebaseFirestore instance) {
        return instance.collection(getStorageTransactionsPath(storageId));
    }

    public static Task<DocumentSnapshot> getStockTransactionById(String storageId, String transactionId, FirebaseFirestore instance) {
        return instance.document(FirestorePath.getStorageTransactionPathById(storageId, transactionId)).get();
    }

    public static Task<QuerySnapshot> getOutlets(String companyId, FirebaseFirestore instance) {
        return instance.collection(getOutletsPath()).whereEqualTo("companyId", companyId).get();
    }

    public static Task<DocumentSnapshot> getOutletById(String outletId, FirebaseFirestore instance) {
        return instance.collection(getOutletsPath()).document(outletId).get();
    }

    public static CollectionReference getSettlements(String outletId, FirebaseFirestore instance) {
        return instance.collection(getOutletsPath()).document(outletId).collection("Settlements");
    }

    public static Task<Void> saveUser(User user, FirebaseFirestore instance) {
        return instance.collection(getUsersPath()).document(user.getUserUID()).set(user);
    }

    public static CollectionReference getUsers(FirebaseFirestore instance) {
        return instance.collection(getUsersPath());
    }

    public static CollectionReference getUsersCompany(FirebaseFirestore instance) {
        return instance.collection(getUsersCompanyPath());
    }

    public static Task<DocumentSnapshot> getUsersCompanyByUid(String Uid, FirebaseFirestore instance) {
        return instance.collection(getUsersCompanyPath()).document(Uid).get();
    }

    public static Task<DocumentSnapshot> getUserWithUid(String uid, FirebaseFirestore instance) {
        return instance.collection(getUsersPath()).document(uid).get();
    }

    public static Task<DocumentSnapshot> getKitchenById(String selectedKitchenIds, FirebaseFirestore instance) {
        return instance.collection(getKitchensPath()).document(selectedKitchenIds).get();
    }

//    public static Task<DocumentSnapshot> getMasterDataStock(String stockId, FirebaseFirestore instance) {
//        return instance.document(getStockMasterDataPath() + "/Stocks/" + stockId).get();
//    }
//
//    public static CollectionReference getMasterDataStocks(FirebaseFirestore instance) {
//        return instance.collection(getStockMasterDataPath());
//    }

    public static Task<Void> saveUserCompany(UserCompany user, FirebaseFirestore instance) {
        return instance.collection(getUsersCompanyPath()).document(user.getUserId()).set(user);
    }

    public static Task<QuerySnapshot> getWallets(FirebaseFirestore instance) {
        return instance.collection(getWalletListPath()).get();
    }

    public static DocumentReference getWallet(String walletId, FirebaseFirestore instance) {
        return instance.collection(getWalletListPath()).document(walletId);
    }

    public static Query getWalletByReferenceId(String referenceId, FirebaseFirestore instance) {
        return instance.collection(getWalletListPath()).whereEqualTo("referenceId", referenceId);
    }

    public static Query getWalletCompany(String companyId, FirebaseFirestore instance) {
        return instance.collection(getWalletListPath()).whereEqualTo("companyId", companyId);
    }

    public static DocumentReference getWalletTransactionById(String lastTransactionId, FirebaseFirestore instance) {
        return instance.document(getWalletTransactionPath(lastTransactionId));
    }

    public static Query getWalletTransactions(String walletId, FirebaseFirestore instance) {
        return instance.collection(getWalletTransactionListPath()).whereEqualTo("walletId", walletId);
    }

    public static void saveStockCategory(StockCategory stockCategory, FirebaseFirestore instance) {

    }
}
