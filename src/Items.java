import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Items {
	static HashMap<String,Double> i = new HashMap<>();
	 Items(){
		i.put("Parle Biscuit", 20.0);
		i.put("Dairy Milk", 50.0);
		i.put("lays", 15.0);
		i.put("Cream Biscuits", 25.0);
		i.put("Namkeens", 35.0);
		i.put("Pepsi", 45.0);
		i.put("milk", 50.0);
		i.put("pen", 5.0);
		i.put("notebook", 20.0);
		i.put("color", 32.0);
		i.put("White paper", 2.0);
		}
	static void show(){
		System.out.println("Items \t \t Price"); 
		System.out.println("------------------"); 
		for(Map.Entry m : i.entrySet()){    
		    System.out.printf("%-15s|  %3.2f \n",m.getKey(),m.getValue());
		   }  
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Items i = new Items();
		Items.show();
//		if(Items.i.containsKey("notebook")){
//			System.out.println("Item found");
//		}else{
//			System.out.println("Sorry! Item not found");
//		}
	}


}
