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
    public class Store implements CropKeeper {
     protected final int id; 
     protected String name;
     protected double maxCapacityArea;
     protected double usedCapacityArea;
     protected double KGperSquareMeter= 10;
     
     
     Store(String name, int id ,  double maxCapacityArea, double usedCapacityArea, double KGperSquareMeter){
         this.id = id;
         this.name= name;
         this.maxCapacityArea= maxCapacityArea;
         this.usedCapacityArea= usedCapacityArea;
         this.KGperSquareMeter= KGperSquareMeter;
     }

    public int getId() {
        return id;
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

    public double getKGperSquareMeter() {
        return KGperSquareMeter;
    }
     
    public void setName(String name) {
        this.name = name;
    }

    public void setMaxCapacityArea(double maxCapacityArea) {
        this.maxCapacityArea = maxCapacityArea;
    }

    public void setUsedCapacityArea(double usedCapacityArea) {
        this.usedCapacityArea = usedCapacityArea;
    }

    public void setKGperSquareMeter(double KGperSquareMeter) {
        this.KGperSquareMeter = KGperSquareMeter;
    }
     public double availabeCapacity(){
        
         return (maxCapacityArea-usedCapacityArea);
     }
     public boolean canBeStored(Crop f){
         return KGperSquareMeter*availabeCapacity()>f.weight;
     }
     public void importCrop(Fruit a) throws CapacityNotEnoughException{
         if(canBeStored(a)){
            a.getFruitList().add(a);  
         }
         
         throw new CapacityNotEnoughException("Not enough capacity!");       
        }
     public void importCrop(Vegetable a) throws CapacityNotEnoughException{
         if(canBeStored(a)){
            a.getVegetableList().add(a);  
         }
         throw new CapacityNotEnoughException("Not enough capacity!");
     }
    public void exportCrop(Fruit a) throws FruitNotFoundException{
        if(a.getFruitList().contains(a)){
            a.getFruitList().remove(a); 
         }
         throw new FruitNotFoundException("Fruit doesn't exist!");       
        }
    public void exportCrop(Vegetable a) throws VegetableNotFoundException{
        if(a.getVegetableList().contains(a)){
            a.getVegetableList().remove(a); 
         }
         throw new VegetableNotFoundException("Vegetable doesn't exist!");       
        }
     @Override
    public void howToStore(Crop o) {
        if(o instanceof Fruit){
         System.out.println("fruits in large refrigerated cooler rooms");
        }
         System.out.println("vegetables in sheds, its listed");
    }

     }
