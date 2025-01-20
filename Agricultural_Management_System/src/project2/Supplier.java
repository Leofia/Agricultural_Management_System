/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

import java.util.ArrayList;



/**
 *
 * @author ANIL
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Supplier implements CropKeeper{
    private String name;
    private String ID;
    private double budget;
    private List<Crop> cropList;

    public Supplier(String name, String ID, double budget) {
        if (!ID.startsWith("1")) {
            throw new IllegalArgumentException("Supplier ID must start with digit 1.");
        }
        this.name = name;
        this.ID = ID;
        this.budget = budget;
        this.cropList = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getID() {
        return ID;
    }
    public double getBudget() {
        return budget;
    }
    public List<Crop> getCropList() {
      return cropList;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", budget=" + budget +
                ", cropList=" + cropList +
                '}';
    }
        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(ID, supplier.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public void buyCrop(Crop crop, Store store) {
         if(crop instanceof Fruit){
          Fruit f = (Fruit)crop;
         
           if (store.getFruitList().contains(f)) {
                if (budget >= (f.getPrice() * f.getWeight())) {
                    budget -= (f.getPrice() * f.getWeight());
                    cropList.add(crop);
                    store.exportCrop(f);
                } else {
                   throw new SupplierHasNotEnougMoneyException("Not enough money to buy this crop.");
                }
            } else {
                throw new FruitNotAvailableException("This fruit is not available in the store.");
            }
       } else{
             throw new CanNotBeStoredException("Only fruits can be bought");
         }
    }

    public void sellCrop(Crop crop, Store store) {
        boolean cropExists = false;
        for (Crop c : cropList) {
          if(c.equals(crop)){
              cropExists = true;
             if(crop instanceof Fruit){
                 Fruit f = (Fruit)crop;
                budget += (f.getPrice() * f.getWeight());
                 cropList.remove(crop);
                 store.importCrop(f);
             } else{
                 cropList.remove(crop);
                 }
              break;
            }
        }
        if (!cropExists) {
            throw new FruitNotFoundException("This crop does not exist in your list.");
        }
    }

    @Override
    public void howToStore() {
        System.out.println("Supplier keeps fruits in big refrigerators, vegetables in the field booths.");
    }
}