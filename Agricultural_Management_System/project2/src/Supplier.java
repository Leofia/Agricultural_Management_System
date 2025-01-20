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
public class Supplier implements CropKeeper {
    protected static int id = 5;
    protected String name;
    protected double budget;
    protected ArrayList<Crop> cropList;
    
    Supplier(String name ,int id, double budget){
        this.budget= budget;
        this.name=name;
        id++;
    }
    public void buyCrop(Crop c) throws SupplierHasNotEnougMoneyException,FruitNotFoundException {
        if(c instanceof Fruit){
        Fruit f = (Fruit) c;    
        if( this.getCropList().contains(f)&& getBudget()>f.getPrice()){
                setBudget(getBudget()-f.getPrice());
                cropList.add(c);
                f.fruitList.remove(f);
        }
        throw new SupplierHasNotEnougMoneyException("");
        }
        throw new FruitNotFoundException("");
    }
    
    public void sellCrop(Crop c) throws SupplierHasNotEnougMoneyException{
        if(c instanceof Fruit) {
    
          Fruit f = (Fruit) c;
          
        if( this.getCropList().contains(f)&& getBudget()> f.getPrice()){
                setBudget(getBudget()+f.getPrice());
                cropList.remove(f);
                 f.fruitList.add(f);
        }
        throw new SupplierHasNotEnougMoneyException("");
    }
    }

    @Override
    public void howToStore(Crop o) {
        if(o instanceof Fruit){
        System.out.println("A Supplier keeps “fruits in big refrigerators”");
        }
        else
        System.out.println("A Supplier keeps “vegetables in the field booths”");
    } 

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBudget() {
        return budget;
    }

    public ArrayList<Crop> getCropList() {
        return cropList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setCropList(ArrayList<Crop> cropList) {
        this.cropList = cropList;
    }
}
