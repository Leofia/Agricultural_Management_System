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
import java.util.Objects;

public class Fruit extends Crop implements Comparable<Crop> {
    private double taste;
    private double price;
    private CropKeeper cropKeeper;

    public Fruit(String name, double weight, String cultivatedSeason, double taste, double price, CropKeeper cropKeeper) {
        super(name, weight, cultivatedSeason);
        this.taste = taste;
        this.price = price;
        this.cropKeeper = cropKeeper;
    }
    public double getTaste() {
        return taste;
    }
    public double getPrice() {
        return price;
    }
    public CropKeeper getCropKeeper() {
        return cropKeeper;
    }

    public void setCropKeeper(CropKeeper cropKeeper) {
        this.cropKeeper = cropKeeper;
    }
    
    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", cultivatedSeason='" + getCultivatedSeason() + '\'' +
                ", taste=" + taste +
                ", price=" + price +
                ", cropKeeper=" + cropKeeper.getClass().getSimpleName() +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      if (!super.equals(o)) return false;
        Fruit fruit = (Fruit) o;
        return Objects.equals(getName(), fruit.getName()) && Objects.equals(taste, fruit.taste);
    }

     @Override
    public int hashCode() {
        return Objects.hash(getName(), taste);
    }

    @Override
    public void consumeIt() {
        System.out.println("Fruits are consumed raw");
    }

    @Override
    public void storeIt() {
        if(cropKeeper instanceof Store){
            ((Store) cropKeeper).importCrop(this);
        } else {
             throw new CanNotBeStoredException("Fruits can be stored in store only");
        }
    }
     @Override
    public int compareTo(Crop o) {
        if (o instanceof Fruit){
            if (this.equals(o)){
                return 0;
            }
        }
        return Double.compare(this.getWeight(), o.getWeight());
    }
}


    
    

