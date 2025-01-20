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
public class Vegetable extends Crop implements Comparable{
    private final String cultivatedRegion;
    protected ArrayList<Vegetable> vegetableList;
    Vegetable(String name , int weight , String cultivatedSeason , String cultivatedRegion){
        super(name ,weight ,cultivatedSeason);
        this.cultivatedRegion= cultivatedRegion;
        vegetableList = new ArrayList();
    }
    public ArrayList<Vegetable> getVegetableList() {
        return vegetableList;
    }

    public void setVegetableList(ArrayList<Vegetable> vegetableList) {
        this.vegetableList = vegetableList;
    }
     @Override
     public void consumeIt(){
         System.out.println("Vegetables are cooked");
     }
    @Override
     public void storeIt(Crop c) throws CanNotBeStoredException{
         if(c instanceof Vegetable){
         Vegetable v = (Vegetable) c;    
         vegetableList.add(v);
         }
         throw new CanNotBeStoredException("It can not be stored!");
     }
    @Override
     public String toString(){
         return "Name"+ name+"from"+cultivatedRegion+"cultivate season"+cultivatedSeason+"weight"+weight;
    
     } 
    
    
    @Override
    public int compareTo(Object o) {
      if(o instanceof Fruit){ 
        if(this.name == name){
          return 0;
        }
        else if(weight>this.weight){
          return weight-this.weight;
        }
        
    }
      return this.weight-weight;
    }
    
    

   
}

