import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/**
 *
 * @author ANIL
 */
public class Test {
    static ArrayList<Crop> Crop= new ArrayList();
    
    public static void main(String[] args) {
        int a =1;
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter file name for ex : Crop.txt ");
        String filename = scn.nextLine();
        try {
      File str = new File("Store.txt");
      File spl = new File("Supplier.txt");
      File crp = new File("Crop.txt");
       Scanner mySupplier = new Scanner(spl); 
       Scanner myCrop = new Scanner(crp);
      Scanner myStore = new Scanner(str);
      Supplier input1 = new Supplier(spl.next());
      Supplier input2 = new Supplier(spl.next());
      Crop input1= new Crop(spl.next());
      
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File doesn't exist");
      a = 0 ;
      e.printStackTrace();
    }
        
        
        
        
        if(a == 1){
        System.out.println("Data received sucssesfully");
        System.out.println("0-Quit");
        System.out.println("1- Display all suppliers");
        System.out.println("2-Display all stores");
        System.out.println("3-Buy a fruit crop");
        System.out.println("4-Sell a fruit crop");
        System.out.println("5-Display My Meetings");
        System.out.println("6-Remove a fruit from a store");
        System.out.println("7-Remove a crop from a supplier");
        System.out.println("8-Show remaining budget");
        System.out.println("9-Show remaining capacity"); 
        }
        if( instanceof Crop){
              Crop crp = (Crop);
          }
        
        Fruit frt = new Fruit();
        Vegetable vgt;
        Store str;
        Supplier spl;
        int menu = scn.nextInt();
        switch(menu){
            case 0:
                System.out.println("Your Choice" + menu );
                 System.out.println("Goodbye");
                 break;
            case 1:
            System.out.println("Your Choice" + menu );
            for(int i = 0; i<spl.size(); i++){
                System.out.println(spl.get(i));
            }
            for(int i = 0; i<spl.getCropList().size(); i++){
                System.out.println(spl.getCropList().get(i));
            }
            if(crp instanceof Fruit){
                Fruit fobj = (Fruit) crp;
                fobj.consumeIt();
            }
            else if(crp instanceof Vegetable){
            Vegetable vobj = (Vegetable) crp;
            vobj.consumeIt();
            }
            spl.howToStore(crp);
             
            break;
            case 2:
                System.out.println("Your Choice" + menu );
            for(int i = 0; i<st.size(); i++){
                System.out.println(st.get(i));
            }
            for(int i = 0; i<str.fruitList.size(); i++){
                System.out.println(str.getFruitList());
            }
            if(crp instanceof Fruit){
                Fruit fobj = (Fruit) crp;
                fobj.consumeIt();
            }
            else if(crp instanceof Vegetable){
            Vegetable vobj = (Vegetable) crp;
            vobj.consumeIt();
            }
            spl.howToStore(crp);
            
             
            break;
            case 3:
            System.out.println("Your Choice" + menu );
            spl.buyCrop(frt);
            str.fruitList.remove(frt);
            break;
            case 4:
            System.out.println("Your Choice" + menu );
            spl.sellCrop(frt);
            str.fruitList.add(frt);
            break;
            case 5:
            System.out.println("Your Choice" + menu );
            str.exportCrop(frt);
            break;
            case 6:
            System.out.println("Your Choice" + menu );
             spl.getCropList().remove(v);
            break;
            case 7:
            System.out.println("Your Choice" + menu );
             spl.getCropList().add(crp);
            break;
            case 8:
            System.out.println("Your Choice" + menu );
                System.out.println("Remaining budget is : " +spl.getBudget());
            break;
            case 9:
            System.out.println("Your Choice" + menu );
                System.out.println("Remaining capacity is : " +str.availabeCapacity());    
            break;
            
    }          
    }
    
}
