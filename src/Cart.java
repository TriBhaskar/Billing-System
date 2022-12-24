import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	HashMap<String,Double> cartItems = new HashMap<>();
	HashMap<String,Integer> ItemsQuantity = new HashMap<>();
	Items i = new Items();
	
	 boolean addItem(String choosedItem,int quantity){
		Items i = new Items();
		if(Items.i.containsKey(choosedItem)){
			cartItems.put(choosedItem, Items.i.get(choosedItem));
			ItemsQuantity.put(choosedItem, quantity);
			System.out.println("Item Added");
		//	System.out.println("found");
			return false;
		}else{
			System.out.println("Sorry! Item not found");
			return true;
		}
	}
	 boolean removeItem(String choosedItem){
		if(Items.i.containsKey(choosedItem)){
			cartItems.remove(choosedItem);
			ItemsQuantity.remove(choosedItem);
			return false;
		}else{
			System.out.println("Sorry! Item not found");
			return true;
		}
	}
	 void showItem(){
		 if(!cartItems.isEmpty()){
		for(Map.Entry m : cartItems.entrySet()){    
		    System.out.printf("%-15s---  %3.2f \n",m.getKey(),m.getValue());
		   } 
		 }else{
			 System.out.println("Your cart is empty");
		 }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Items i = new Items();
		Cart c = new Cart();
		c.addItem("pen",5);
		c.showItem();
	}

}
