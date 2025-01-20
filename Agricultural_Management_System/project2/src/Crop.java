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
 abstract public class Crop {
    protected final String name;
    protected final int weight;
    protected final String cultivatedSeason;
     Crop(String name , int weight , String cultivatedSeason){
     this.name= name;
     this.weight= weight;
     this.cultivatedSeason= cultivatedSeason;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getCultivatedSeason() {
        return cultivatedSeason;
    }
    
     public abstract void consumeIt();
    
     public abstract void storeIt(Crop c) throws CanNotBeStoredException;
    
    @Override
     public abstract String toString(); 
}
