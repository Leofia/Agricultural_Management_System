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
  import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Store implements CropKeeper {
    private String ID;
    private String name;
    private double maxCapacityArea;
    private double usedCapacityArea;
    private final double KGperSquareMeter = 10;
    private List<Fruit> fruitList;

    public Store(String ID, String name, double maxCapacityArea) {
        if (!ID.startsWith("5")) {
            throw new IllegalArgumentException("Store ID must start with digit 5.");
        }
        this.ID = ID;
        this.name = name;
        this.maxCapacityArea = maxCapacityArea;
        this.usedCapacityArea = 0;
        this.fruitList = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public double getMaxCapacityArea() {
        return maxCapacityArea;
    }
    public double getUsedCapacityArea() {
        return usedCapacityArea;
    }
        public List<Fruit> getFruitList() {
        return fruitList;
    }
    
    @Override
    public String toString() {
        return "Store{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", maxCapacityArea=" + maxCapacityArea +
                ", usedCapacityArea=" + usedCapacityArea +
                 ", fruitList=" + fruitList +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(ID, store.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }

    public double availableCapacity() {
        return maxCapacityArea - usedCapacityArea;
    }

    public boolean canBeStored(Fruit f) {
      if(availableCapacity() >= f.getWeight() / KGperSquareMeter){
          return true;
      }
      return false;
    }

     public void importCrop(Fruit f) {
        if (canBeStored(f)) {
            boolean fruitExists = false;
            for (Fruit fruit : fruitList) {
                if (fruit.equals(f)) {
                  fruitExists = true;
                    usedCapacityArea += f.getWeight() / KGperSquareMeter;
                    
                  
                    break;
                }
            }
           if(!fruitExists){
               fruitList.add(f);
               usedCapacityArea += f.getWeight()/KGperSquareMeter;
           }


        } else {
            throw new CapacityNotEnoughException("Not enough capacity to store this fruit.");
        }
    }

    public void exportCrop(Fruit f) {
      boolean fruitExists = false;
        for (Fruit fruit : fruitList) {
            if(fruit.equals(f)){
              fruitExists = true;
              fruitList.remove(f);
              usedCapacityArea -= f.getWeight() / KGperSquareMeter;
                break;
            }
        }
        if (!fruitExists) {
            throw new FruitNotFoundException("This fruit does not exist in the store.");
        }
    }
    
        @Override
    public void howToStore() {
        System.out.println("Stores keeps fruits in large refrigerated cooler rooms, vegetables in sheds, not listed");
    }
}
