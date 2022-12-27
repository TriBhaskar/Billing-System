import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Billing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch=0,quantity,count=0;
		String custName, choosedItem;
		long custMno;
		boolean flag;
		double totalamount=0;
		//Object Creation of all
		
		Items itemsObj = new Items();
		Cart cartObj = new Cart();
		System.out.println("|--------------------------------------------------------------------------------------------------------|");
		System.out.println("|--------------------------------------------------------------------------------------------------------|");
		System.out.println("\t\t\t==== WELCOME TO SimEmmo BILLING SYSTEM ==== ");
		
		System.out.println("Enter Your Name : ");
		custName = sc.next();
		System.out.println("Enter Your Mobile no : ");
		custMno = sc.nextLong();
		Items.show();
		do{
			Customer c = new Customer(custName,custMno);
			System.out.println("\n 1.Add item \n 2.Remove item \n 3.Show items in the cart\n 4.Show all items\n 0.Exit");
			System.out.println("Enter the your choice : ");
			ch = sc.nextInt();                                                                         
			switch(ch){
			case 0:
				System.out.println("Thank you for shopping with us");
				break;
			case 1:
				do{
				System.out.println("Name the item you want to add :");
				choosedItem = sc.next();
				System.out.println("Enter the quantity :");
				quantity = sc.nextInt();
				flag=cartObj.addItem(choosedItem,quantity);
				}while(flag);
				break;
			case 2:
				System.out.println("Name the item you want to remove :");
				choosedItem = sc.next();
				flag=cartObj.removeItem(choosedItem);
				break;
			case 3:
				cartObj.showItem();
				break;
			case 4:
				Items.show();
				break;
			default:
				System.out.println("Select the Correct Option");
			}	
		}while(ch>0);
		java.util.Date date = new java.util.Date(); 
		
		if(!cartObj.cartItems.isEmpty()){
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("Bill to - "+custName+"\t\t\t\t\t\t "+date);
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("Item Name\t\tRate\t\tQuantity\t\tTotal Price");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			
			for(Map.Entry m: cartObj.cartItems.entrySet()){  
				int quan=cartObj.ItemsQuantity.get(m.getKey());
				double rate =(double) m.getValue();
				double totalprice =  rate * quan;
			    System.out.printf("%-18s     %-18.2f     %-18d     %-18.2f \n",m.getKey(),m.getValue(),cartObj.ItemsQuantity.get(m.getKey()),totalprice);
			    totalamount = totalamount+totalprice;
			   } 
			System.out.printf("Total amount\t\t\t\t\t\t\t  Rs.%.2f \n",totalamount);
			double gst=0.08*totalamount;
			System.out.printf("GST\t\t\t\t\t\t\t\t  Rs.%.2f \n",gst);
			System.out.printf("Final amount\t\t\t\t\t\t\t  Rs.%.2f \n",(gst+totalamount));
		}
	}

}
