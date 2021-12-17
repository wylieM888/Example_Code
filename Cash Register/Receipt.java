/*
 * @author: Matt Wylie
 * @version: Assignment 2: Cash Register
 * @date: 2/13/2020
 * @description: This class will be used to create the Receipt
 * 			     object, which will then be the method used to
 * 			     generate the receipt string that displays
 * 			     the final transaction amounts once the user has
 * 		         paid the balance in total.
 */

import java.util.*;

public class Receipt {

	final Transaction transaction;
		//What does "final" do?
		//It means that the object's value cannot be changed.
		//Once the user has paid the balance in total, there's no reason
		//to allow for further information manipulation. The final keyword will
		//prevent that from happening.
	
	//Create Receipt constructor
	public Receipt(Transaction t) {
		this.transaction = t;
	}
	
	//Gets Transaction object
	public Transaction getTransaction() {
		Transaction x = transaction;
		return x;
		//Why do we not want a setter for this field?
		//Because the Receipt method will only be called once all transactions are completed.
		//There's no need to make changes to any variables outside of Receipt's scope.
	}

	//Generate single string for receipt to be sent to main once change is <= 0
	public String getReceiptString() {
		
		//Create temporary variables for payment methods, then assign values only if
		//a payment method was used. This is so that only payment methods that were
		//used are displayed.
		String deb = ""; 
		String cre = "";
		String cas = "";
		String che = "";
		if (transaction.getPayments().get(3).getAmount() > 0) {
			cas = "Cash: \t\t" + transaction.getPayments().get(3).getAmount() + "\n";
		}
		if (transaction.getPayments().get(0).getAmount() > 0) {
			deb = "Debit: \t\t" + transaction.getPayments().get(0).getAmount() + "\n";
		}
		if (transaction.getPayments().get(2).getAmount() > 0) {
			cre = "Cash: \t\t" + transaction.getPayments().get(2).getAmount() + "\n";
		}
		if (transaction.getPayments().get(1).getAmount() > 0) {
			che = "Check: \t\t" + transaction.getPayments().get(1).getAmount() + "\n";
		}
		
		//Display shopping cart and price
		String iList = transaction.getItemTransaction().get(0).getName() + ": " + transaction.getItemTransaction().get(0).getPrice() + "\n";
		//Check to see if any other items are needed to be printed to avoid an IndexOutOfBounds error
		if (transaction.getItemTransaction().size() > 1) {
			for (int i = 1; i < transaction.getItemTransaction().size(); i++) {
				iList = iList + transaction.getItemTransaction().get(i).getName() + ": " + transaction.getItemTransaction().get(i).getPrice() + "\n";
			}
		}
		
		//Generate the Receipt String based on the transaction values, while ensuring the
		//format meets assignment requirements.
		String x = iList +
				   "--------------------------\n"+
				  "Subtotal: \t" + transaction.getSubTotal() + "\n"+
				  "Tax: \t\t" + transaction.getTax() + "\n"+
				  "Total: \t\t" + transaction.getTotal() + "\n"+
				  cas +
				  deb +
				  cre +
				  che +
				  "Change: \t" + (transaction.getChange() * -1);
		return x;
	}
}
