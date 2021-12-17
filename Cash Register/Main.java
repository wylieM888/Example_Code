/*
 * @author: Matt Wylie
 * @version: Assignment 2: Cash Register
 * @date: 2/13/2020
 * @description: This program will generate a shopping list
 * 				 with item names and prices, display the total,
 * 				 prompt user for payment method and amount,
 * 				 then display a receipt.
 * 
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//Declare a new Item arraylist
		ArrayList<Item> x = new ArrayList<Item>();
		
		//Create a grocery list by instantiating items
		//with item names and prices.
		Item apple = new Item("Apple", 1.25);
		x.add(apple);
		Item grapes = new Item("Grapes", 2.00);
		x.add(grapes);
		Item eggs = new Item("Eggs", 1.50);
		x.add(eggs);
		
		//Print out the grocery list
		for (int i = 0; i < x.size(); i++) {
			String u = x.get(i).toString();
			System.out.println(u);
		}
		
		//Instantiate a transaction using the Item arraylist
		Transaction transaction = new Transaction(x);
		//Compute subtotal first, then tax, then total
		transaction.computeSubtotal();
		transaction.computeTax();
		transaction.computeTotal();

		//Output the transaction total
		System.out.println("Total: " + transaction.getTotal());
		
		//Call the takePayment method to have user pay for
		//their groceries
		transaction.takePayment();
		
		//Instantiate a new Receipt using the transaction above
		Receipt r = new Receipt(transaction);
		
		//Get the receipt string from the Receipt method
		String p = r.getReceiptString();
		
		//Print the receipt
		System.out.print(p);
	}

}

