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
public class Fruit extends Crop implements Comparable{
    private boolean taste;
    private double price;
    private final String color;
    protected ArrayList<Fruit> fruitList;
    Fruit(String name , int weight , String cultivatedSeason , boolean taste, double price, String color){
        super(name ,weight , cultivatedSeason);
        this.taste= taste;
        this.price=price;
        this.color=color; 
        fruitList = new ArrayList();
    }
    public String getColor() {
        return color;
    }
    public boolean getTaste(){
        return taste;
    }
    public double getPrice(){
        return price;
    }
    
    public void setTaste(boolean taste) {
        this.taste = taste;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<Fruit> fruitList) {
        this.fruitList = fruitList;
    }
     @Override
     public void consumeIt() {
         System.out.println("fruits are consumed raw");
     }
    @Override
     public  void storeIt(Crop c) throws CanNotBeStoredException{
        if(c instanceof Fruit){
         Fruit f = (Fruit) c;    
         fruitList.add(f);
         }
         throw new CanNotBeStoredException("It can not be stored!");
     }
    @Override
     public String toString(){
         return "Name"+ name+"cultivate season"+cultivatedSeason+"weight"+weight+"color"+getColor()+"is taste good?" + taste + "price" + price;
     } 
           
     
    @Override
    public int compareTo(Object o) {
      if(this.name == name && this.getColor()==getColor()){
          return 0;
      }
      else if(this.weight>weight){
      return this.weight-weight;
      }
      return weight-this.weight;
    }


    
    
}
