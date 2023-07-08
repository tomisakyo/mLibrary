const functions = require("firebase-functions");

const {initializeApp} = require("firebase-admin/app");
const {getFirestore} = require("firebase-admin/firestore");
initializeApp();
const db = getFirestore();

exports.hiWorld = functions.https.onCall((data, context) => {
  console.log(data);
  return "Hello " + data.name + " from hiWorld";
});

// Buat dan edit storage
exports.addStorage = functions.https.onCall(async (storage, context) => {
  const res = await db.collection("Storages")
      .doc(storage.storageId).set({
        storageId: storage.storageId,
        companyId: storage.companyId,
        name: storage.name,
        address: storage.address,
        contact: storage.contact,
        lastTransactionId: storage.lastTransactionId,
        stockQuantityHolder: storage.stockQuantityHolder,
      });
  console.log("Added document with ID: ", res.id);
  return "Added document with ID: " + res.id;
});

// Tambah dan edit Barang
exports.addStock = functions.https.onCall(async (stock, context) => {
  const res = await db.collection("Companies")
      .doc(stock.companyId)
      .collection("MasterData")
      .doc("Stock")
      .collection("Stocks")
      .doc(stock.stockId).set({
        stockId: stock.stockId,
        minimumStockLevel: stock.minimumStockLevel,
        name: stock.name,
        categoryId: stock.categoryId,
        priority: stock.priority,
        unit1: stock.unit1,
        unit1ValueOverUnit2: stock.unit1ValueOverUnit2,
        unit2: stock.unit2,
        unit2ValueOverUnit3: stock.unit2ValueOverUnit3,
        unit3: stock.unit3,
        isEnabled: stock.isEnabled,
        tags: stock.tags,
      });
  console.log("Added document with ID: ", res.id);
  return "Added document with ID: " + res.id;
});

// Tambah stock quantity
exports.addStockQuantity = functions.https.onCall(async (value, context) => {
  const trans = await db.collection("Storages")
      .doc(value.storageId)
      .collection("Transactions")
      .doc(value.transactionId)
      .set({
        transactionId: value.transactionId,
        date: value.date,
        transactionType: value.transactionType,
        referenceId: value.referenceId,
        note: value.note,
        transactionStockItems: value.stockItems,
      });
  const o = await db.collection("Storages")
      .doc(value.storageId)
      .collection("Data")
      .doc("StockQuantityHolders")
      .get();
  for (let i = 0; i < value.stockItems.length; i++) {
    for (let j = 0; j < o.data().stock.length; j++) {
      if (value.stockItems[i].stockId == o.data().stock[j].stockId) {
        for (const key of Object.keys(o)) {
          if (db.collection("Storages")
              .doc(value.storageId)
              .collection("Data")
              .doc(key).exists()) {
            db.collection("Storages")
                .doc(value.storageId)
                .collection("Data")
                .doc(key)
                .set(o[key]);
          } else {
            db.collection("Storages")
                .doc(value.storageId)
                .collection("Data")
                .doc(key)
                .add(o[key]);
          }
        }
      }
    }
  }
  // for (let i = 0; i < trans.data().transactionStockItems.length; i++) {
  //   const stockId = trans.data().transactionStockItems.stockId;
  //   const stockQuantity = trans.data().transactionStockItems.quantitySystem;

  //   const itemIndex = res.data().stock.indexOf(stockId);
  //   const lastQuantity = res.data().stock[itemIndex].quantity;
  //   const newQuantity = stockQuantity + lastQuantity;
  //   const minStock = res.data().stock[itemIndex].minimumStockLevel;
  //   await db.collection("Storages")
  //       .doc(value.storageId)
  //       .collection("Data")
  //       .doc("StockQuantityHolders")
  //       .set({
  //         stock: [
  //           {
  //             stockId: stockId,
  //             quantity: newQuantity,
  //             minimumStockLevel: minStock,
  //           },
  //         ],
  //       });
  // }
  return "Added document with ID : " + trans.id;
});

// mengurangi stock quantity
exports.stockSales = functions.https.onCall(async (data, context) => {
  const o = await db.collection("Outlets")
      .doc(data.outletId)
      .collection("Orders")
      .doc(data.orderId)
      .get();
  const s = await db.collection("Storages")
      .doc(data.storageId)
      .collection("Data")
      .doc("StockQuantityHolders")
      .get();

  for (let i = 0; i < o.data().ingredientsSummary.length; i++) {
    for (let j = 0; i < s.data().stock.length; j++) {
      if (o.data().ingredientsSummary[i].stockId ==s.data().stock[j].stockId) {
        const quantity1 = o.data().ingredientsSummary[i].quantity;
        const quantity2 = s.data().stock[j].quantity;
        const decresedQuantity = quantity2 - quantity1;
        const save = await db.collection("Storages")
            .doc(data.storageId)
            .collection("Data")
            .doc("StockQuantityHolders")
            .set({
              stock: [
                {
                  stockId: s.data().stock[j].stockId,
                  quantity: decresedQuantity,
                  minimumStockLevel: s.data().stock[j].minimumStockLevel,
                },
              ],
            });
        await db.collection("Storages")
            .doc(data.storageId)
            .collection("Data")
            .doc("OngoingStocks")
            .delete();
        return "Added document with ID : " + save.id;
      }
    }
  }
});

// alert stock
exports.alertMinStock = functions.firestore
    .document("Storages/{storageId}/Data/StockQuantityHolders")
    .onUpdate((change, context) => {
      const newValue = change.after.data();
      if (newValue.quantity < newValue.minimumStockLevel) {
        return "Stock quantity is less than minimum";
      } else {
        return "Stock quantity is above or equal to minimum";
      }
    });

exports.transferStock = functions.https.onCall(async (data, context) => {
  const startStorage = await db.collection("Storages")
      .doc(data.startStorageId)
      .collection("Data")
      .doc("StockQuantityHolders")
      .get();
  const destinationStorage = await db.collection("Storages")
      .doc(data.destinationStorageId)
      .collection("Data")
      .doc("StockQuantityHolders")
      .get();
  if (startStorage.data().stockId == destinationStorage.data().stockId) {
    const saveDest = await db.collection("Storages")
        .doc(data.destinationStorageId)
        .collection("Data")
        .doc("StockQuantityHolders")
        .set({
          stockId: destinationStorage.data().stockId,
          quantity: data.transQuantity,
          minimumStockLevel: destinationStorage.data().minimumStockLevel,
        });
    const newQuan = startStorage.data().quantity - parseInt(data.transQuantity);
    const saveStart = await db.collection("Storages")
        .doc(data.startStorageId)
        .collection("Data")
        .doc("StockQuantityHolders")
        .set({
          stockId: startStorage.data().stockId,
          quantity: newQuan,
          minimumStockLevel: startStorage.data().minimumStockLevel,
        });
    return "Transfer Complete for " + saveDest.id + " and " + saveStart.id;
  } else {
    return "There is no similar stockId in startStorage and destinationStorage";
  }
});

// Buat Transaksi
exports.addTransaction = functions.https.onCall((data, context) => {
  return "Transaction Added";
});

// Transfer Barang
exports.transferStock = functions.https.onCall((data, context) => {
  return "Stock Transfered";
});

// Opname Barang
exports.opnameBarang = functions.https.onCall((data, context) => {
  return "Stock Opnamed";
});

// Keluar Barang/Sales
exports.soldStock = functions.https.onCall((data, context) => {
  return "Stock Sold";
});
