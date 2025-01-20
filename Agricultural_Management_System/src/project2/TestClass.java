
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;
import java.io.IOException;
import java.util.*;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextFileHandler fileHandler = new TextFileHandler();
        List<Supplier> suppliers = new ArrayList<>();
        List<Store> stores = new ArrayList<>();
        List<Crop> crops = new ArrayList<>();

        try {
            suppliers = fileHandler.loadSuppliers("Suppliers.txt");//The relevant directory must be written in this field.
            stores = fileHandler.loadStores("Stores.txt");//The relevant directory must be written in this field.
            crops = fileHandler.loadCrops("Crops.txt",suppliers,stores);//The relevant directory must be written in this field.

            
        } catch (IOException e) {
            System.out.println("Error loading data from file: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("Press 1: Display all suppliers and their crop list.");
            System.out.println("Press 2: Display all stores and their fruit list.");
            System.out.println("Press 3: Buy a fruit crop for a Supplier.");
            System.out.println("Press 4: Sell a fruit crop of a Supplier.");
            System.out.println("Press 5: Remove a fruit from a store.");
            System.out.println("Press 6: Remove a crop from a supplier.");
            System.out.println("Press 7: Add crop.");
            System.out.println("Press 8: Show remaining budget of a supplier.");
            System.out.println("Press 9: Show remaining capacity of a given store.");
            System.out.println("Press 0: Quit.");

            System.out.print("Please make a choice (0 to 9): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    displayAllSuppliers(suppliers);
                    break;
                case 2:
                    displayAllStores(stores);
                    break;
                case 3:
                    buyCropForSupplier(scanner, suppliers, stores,crops);
                    break;
                case 4:
                   sellCropFromSupplier(scanner,suppliers,stores);
                   break;
                case 5:
                  removeFruitFromStore(scanner,stores);
                   break;
                case 6:
                   removeCropFromSupplier(scanner,suppliers);
                  break;
                case 7:
                   addCrop(scanner,suppliers,stores,crops);
                    break;
                case 8:
                   showSupplierBudget(scanner,suppliers);
                    break;
                case 9:
                    showStoreCapacity(scanner, stores);
                    break;
                case 0:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
   private static void displayAllSuppliers(List<Supplier> suppliers) {
        System.out.println("\n--- All Suppliers ---");
        for (Supplier supplier : suppliers) {
            System.out.println(supplier);
          System.out.println("How it stores:");
            supplier.howToStore();

        }
    }

    private static void displayAllStores(List<Store> stores) {
        System.out.println("\n--- All Stores ---");
        for (Store store : stores) {
            System.out.println(store);
            System.out.println("How it stores:");
            store.howToStore();
        }
    }

     private static void buyCropForSupplier(Scanner scanner, List<Supplier> suppliers, List<Store> stores, List<Crop> crops) {
        System.out.println("\n--- Buy Crop for a Supplier ---");
        System.out.print("Enter supplier ID: ");
        String supplierID = scanner.nextLine();
        Supplier supplier = findSupplier(suppliers, supplierID);
        if (supplier == null) {
            System.out.println("Supplier not found.");
            return;
        }
        System.out.print("Enter store ID: ");
        String storeID = scanner.nextLine();
        Store store = findStore(stores, storeID);
        if (store == null) {
           System.out.println("Store not found.");
            return;
        }
         System.out.print("Enter the name of the fruit to buy: ");
        String cropName = scanner.nextLine();
       
         Crop selectedCrop = null;
           for(Crop c: crops){
               if(c.getName().equals(cropName)){
                   selectedCrop = c;
                  break;
               }
           }
         if(selectedCrop== null) {
                System.out.println("Crop not found.");
                return;
        }
           try{
               supplier.buyCrop(selectedCrop, store);
               System.out.println(selectedCrop.getName() + " bought for supplier: " + supplier.getName());
           } catch (SupplierHasNotEnougMoneyException | FruitNotAvailableException | CanNotBeStoredException e){
               System.out.println("Error buying crop: " + e.getMessage());
           }
    }

     private static void sellCropFromSupplier(Scanner scanner, List<Supplier> suppliers, List<Store> stores) {
        System.out.println("\n--- Sell Crop of a Supplier ---");
        System.out.print("Enter supplier ID: ");
        String supplierID = scanner.nextLine();
        Supplier supplier = findSupplier(suppliers, supplierID);
        if (supplier == null) {
            System.out.println("Supplier not found.");
            return;
        }
          System.out.print("Enter store ID: ");
        String storeID = scanner.nextLine();
        Store store = findStore(stores, storeID);
        if (store == null) {
            System.out.println("Store not found.");
            return;
        }

         System.out.print("Enter the name of the fruit to sell: ");
        String cropName = scanner.nextLine();
        
        Crop selectedCrop = null;
         for(Crop c : supplier.getCropList()){
             if(c.getName().equals(cropName)){
                selectedCrop = c;
              break;
            }
         }
            if (selectedCrop == null) {
                System.out.println("Crop not found in supplier's list.");
                return;
            }
            try{
                supplier.sellCrop(selectedCrop,store);
                System.out.println(selectedCrop.getName() + " sold by supplier " + supplier.getName());
            } catch (FruitNotFoundException e){
                System.out.println("Error selling crop: " + e.getMessage());
            }
    }

    private static void removeFruitFromStore(Scanner scanner, List<Store> stores) {
        System.out.println("\n--- Remove Fruit from a Store ---");
         System.out.print("Enter store ID: ");
        String storeID = scanner.nextLine();
        Store store = findStore(stores, storeID);
        if (store == null) {
            System.out.println("Store not found.");
            return;
        }
          System.out.print("Enter the name of the fruit to remove: ");
        String cropName = scanner.nextLine();

           Crop selectedCrop = null;
          for (Fruit f: store.getFruitList()){
              if(f.getName().equals(cropName)){
                 selectedCrop = f;
                 break;
            }
         }
          if (selectedCrop == null) {
                System.out.println("Crop not found in the store's list.");
                return;
          }
             try {
                 store.exportCrop((Fruit)selectedCrop);
                 System.out.println(selectedCrop.getName() + " removed from the store " + store.getName());
            }
            catch (FruitNotFoundException e){
                System.out.println("Error removeing fruit: " + e.getMessage());
            }
    }
    
    private static void removeCropFromSupplier(Scanner scanner, List<Supplier> suppliers) {
        System.out.println("\n--- Remove Crop from a Supplier ---");
        System.out.print("Enter supplier ID: ");
        String supplierID = scanner.nextLine();
        Supplier supplier = findSupplier(suppliers, supplierID);
        if (supplier == null) {
            System.out.println("Supplier not found.");
            return;
        }
         System.out.print("Enter the name of the crop to remove: ");
        String cropName = scanner.nextLine();
        Crop selectedCrop = null;
         for (Crop c : supplier.getCropList()) {
            if(c.getName().equals(cropName)){
                selectedCrop = c;
              break;
            }
        }
           if (selectedCrop == null) {
                System.out.println("Crop not found in supplier's list.");
                return;
           }
         supplier.getCropList().remove(selectedCrop);
           System.out.println(selectedCrop.getName() + " removed from supplier " + supplier.getName());

    }
    
   private static void addCrop(Scanner scanner, List<Supplier> suppliers, List<Store> stores, List<Crop> crops) {
        System.out.println("\n--- Add Crop ---");
        System.out.print("Enter crop type (fruit or vegetable): ");
        String cropType = scanner.nextLine().toLowerCase();
        System.out.print("Enter crop name: ");
        String name = scanner.nextLine();
        System.out.print("Enter crop weight (kg): ");
        double weight = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter cultivated season: ");
        String season = scanner.nextLine();
         CropKeeper cropKeeper = null;
        if (cropType.equals("fruit")) {
            System.out.print("Enter taste: ");
            double taste = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter price: ");
            double price = Double.parseDouble(scanner.nextLine());
          System.out.print("Enter store or supplier ID to store crop: ");
           String id = scanner.nextLine();
           cropKeeper = findCropKeeper(suppliers,stores,id);
             if(cropKeeper == null) {
                System.out.println("CropKeeper not found.");
                return;
           }
            Fruit newFruit = new Fruit(name, weight, season, taste, price,cropKeeper);
               if(cropKeeper instanceof Store){
                   newFruit.storeIt();
               }
           crops.add(newFruit);
           System.out.println("Fruit added: " + newFruit);
        } else if (cropType.equals("vegetable")) {
            System.out.print("Enter cultivated region: ");
            String region = scanner.nextLine();
              System.out.print("Enter supplier ID to keep crop: ");
           String id = scanner.nextLine();
           cropKeeper = findCropKeeper(suppliers,stores,id);
            if(cropKeeper == null) {
                System.out.println("CropKeeper not found.");
                return;
            }
            Vegetable newVegetable = new Vegetable(name, weight, season, region, cropKeeper);
             crops.add(newVegetable);
               System.out.println("Vegetable added: " + newVegetable);
        } else {
            System.out.println("Invalid crop type.");
        }
    }
     private static void showSupplierBudget(Scanner scanner, List<Supplier> suppliers) {
        System.out.println("\n--- Show Remaining Budget of a Supplier ---");
        System.out.print("Enter supplier ID: ");
        String supplierID = scanner.nextLine();
        Supplier supplier = findSupplier(suppliers, supplierID);
        if (supplier == null) {
            System.out.println("Supplier not found.");
            return;
        }
         System.out.println("Remaining budget for supplier " + supplier.getName() + ": " + supplier.getBudget() + " TL");
    }

    private static void showStoreCapacity(Scanner scanner, List<Store> stores) {
        System.out.println("\n--- Show Remaining Capacity of a Store ---");
        System.out.print("Enter store ID: ");
        String storeID = scanner.nextLine();
        Store store = findStore(stores, storeID);
        if (store == null) {
            System.out.println("Store not found.");
            return;
        }
        System.out.println("Remaining capacity for store " + store.getName() + ": " + store.availableCapacity() + " m²");
    }


    private static Supplier findSupplier(List<Supplier> suppliers, String id) {
        for (Supplier supplier : suppliers) {
            if (supplier.getID().equals(id)) {
                return supplier;
            }
        }
        return null;
    }
     private static Store findStore(List<Store> stores, String id) {
        for (Store store : stores) {
            if (store.getID().equals(id)) {
                return store;
            }
        }
        return null;
    }
    private static CropKeeper findCropKeeper(List<Supplier> suppliers, List<Store> stores, String id) {
       CropKeeper cropKeeper = findSupplier(suppliers,id);
      if(cropKeeper == null){
          cropKeeper = findStore(stores,id);
       }
      return cropKeeper;
    }
}