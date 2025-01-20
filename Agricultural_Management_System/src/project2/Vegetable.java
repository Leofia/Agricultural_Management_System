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

public class Vegetable extends Crop implements Comparable<Crop> {
    private String cultivatedRegion;
    private CropKeeper cropKeeper;

    public Vegetable(String name, double weight, String cultivatedSeason, String cultivatedRegion, CropKeeper cropKeeper) {
        super(name, weight, cultivatedSeason);
        this.cultivatedRegion = cultivatedRegion;
        this.cropKeeper = cropKeeper;
    }

    public String getCultivatedRegion() {
        return cultivatedRegion;
    }
        public CropKeeper getCropKeeper() {
        return cropKeeper;
    }
        public void setCropKeeper(CropKeeper cropKeeper) {
        this.cropKeeper = cropKeeper;
    }


    @Override
    public String toString() {
        return "Vegetable{" +
                "name='" + getName() + '\'' +
                ", weight=" + getWeight() +
                ", cultivatedSeason='" + getCultivatedSeason() + '\'' +
                ", cultivatedRegion='" + cultivatedRegion + '\'' +
                ", cropKeeper=" + cropKeeper.getClass().getSimpleName() +
                '}';
    }
    @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Vegetable vegetable = (Vegetable) o;
        return Objects.equals(getName(), vegetable.getName());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
    @Override
    public void consumeIt() {
        System.out.println("Vegetables are cooked");
    }
    @Override
    public void storeIt() throws CanNotBeStoredException {
         throw new CanNotBeStoredException("Vegetables can't be stored");
    }
    
     @Override
    public int compareTo(Crop o) {
        if (o instanceof Vegetable){
           if(this.equals(o)){
             return 0;
            }
        }
        return Double.compare(this.getWeight(), o.getWeight());
    }
}

