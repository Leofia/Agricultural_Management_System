/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author ANIL
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileHandler {
    public List<Supplier> loadSuppliers(String fileName) throws IOException {
        List<Supplier> suppliers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 3) {
                    String name = parts[0];
                    String ID = parts[1];
                    double budget = Double.parseDouble(parts[2]);
                    suppliers.add(new Supplier(name, ID, budget));
                }
            }
        }
        return suppliers;
    }

    public List<Store> loadStores(String fileName) throws IOException {
        List<Store> stores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String name = parts[0];
                    String ID = parts[1];
                    double maxCapacityArea = Double.parseDouble(parts[2]);
                    stores.add(new Store(ID, name, maxCapacityArea));
                }
            }
        }
        return stores;
    }

    public List<Crop> loadCrops(String fileName, List<Supplier> suppliers, List<Store> stores) throws IOException {
        List<Crop> crops = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(", ");
                if (parts.length > 4) {
                    String name = parts[0];
                    String type = parts[1];
                    double weight = Double.parseDouble(parts[2]);
                    String season = parts[3];

                    if (type.equals("fruit") && parts.length == 7) {
                       
                        String taste = parts[4]; // Tad bilgisi String olarak saklanıyor
                        double price = Double.parseDouble(parts[5]);
                        String cropKeeperID = parts[6];
                        CropKeeper cropKeeper = findCropKeeper(suppliers, stores, cropKeeperID);
                        if (cropKeeper == null) {
                            System.out.println("Error: CropKeeper not found for crop: " + name);
                            continue;
                        }
                        Fruit fruit = new Fruit(name, weight, season, 0, price, cropKeeper);
                        if (cropKeeper instanceof Store) {
                            ((Store) cropKeeper).importCrop(fruit);
                        }
                        crops.add(fruit);
                    } else if (type.equals("vegetable") && parts.length == 5) {
                        String region = parts[4];
                        String cropKeeperID = parts[4];
                         CropKeeper cropKeeper = findCropKeeper(suppliers, stores, cropKeeperID);
                           if (cropKeeper == null) {
                            System.out.println("Error: CropKeeper not found for crop: " + name);
                            continue;
                           }
                        Vegetable vegetable = new Vegetable(name, weight, season, region, cropKeeper);
                        crops.add(vegetable);
                    } else {
                        System.out.println("Error: invalid crop record for " + name);
                    }
                }
            }
        }
        return crops;
    }
    private CropKeeper findCropKeeper(List<Supplier> suppliers, List<Store> stores, String id) {
        CropKeeper cropKeeper = findSupplier(suppliers,id);
        if(cropKeeper == null){
            cropKeeper = findStore(stores,id);
        }
        return cropKeeper;
    }
    private Supplier findSupplier(List<Supplier> suppliers, String id) {
        for (Supplier supplier : suppliers) {
            if (supplier.getID().equals(id)) {
                return supplier;
            }
        }
        return null;
    }
    private Store findStore(List<Store> stores, String id) {
        for (Store store : stores) {
            if (store.getID().equals(id)) {
                return store;
            }
        }
        return null;
    }
}