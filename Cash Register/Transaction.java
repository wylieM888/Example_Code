/*
 * @author: Matt Wylie
 * @version: Assignment 2: Cash Register
 * @date: 2/13/2020
 * @description: This class will create the Transaction object that
 * 				 will receive, calculate, and store
 * 			     the user's payment types and amounts, subtotal, tax
 * 				 total, and change.
 */


import java.util.*;

public class Transaction{

	//Create Transaction fields
	private ArrayList<Item> item;
	private ArrayList<Payment> payments;
	private double subTotal;
	private double tax;
	private double total;
	private double change;
	
	//Creates transaction constructor
	public Transaction(){
		item = new ArrayList<Item>();
		payments = new ArrayList<Payment>();
	}
	
	//Creates transaction constructor that calls in an Item
	//ArrayList, assigns the value to the transaction's item
	//ArrayList field, then instantiate's the transaction's payments
	//ArrayList
	public Transaction(ArrayList<Item> items) {
		this.item = new ArrayList<Item>();
		for(int i = 0; i < items.size(); i++) {
			Item n = items.get(i);
			this.item.add(n);
		}
		payments = new ArrayList<Payment>();
	}
	
	//Create field getters/setters
	public ArrayList<Item> getItemTransaction() {
		return this.item;
	}
	
	public ArrayList<Payment> getPayments(){
		return payments;
	}

	public double getSubTotal() {
		return subTotal;
	}
	
	public double getTax() {
		return tax;
	}
	
	public double getTotal(){
		return this.total;
	}
	
	public double getChange(){
		return this.change;
	}
	
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public void setTax(double tax){
		this.tax = tax;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public void setChange(double change){
		this.change = change;
	}
	
	//Computes subtotal by looping throw items list
	//and adding the item prices
	public void computeSubtotal() {
		double tempTotal = 0;
		double x = 0;
		for(int i = 0; i < this.item.size(); i++) {
			x = this.item.get(i).getPrice();
			tempTotal = tempTotal + x;
		}
		this.subTotal = tempTotal;
	}
	
	//Calculates tax by multiplying subtotal by the
	//tax rate 0.07.
	public void computeTax() {
		this.tax = this.subTotal * .07;
	}
	
	//Computes total by adding subtotal and tax
	public void computeTotal() {
		this.total = this.subTotal + this.tax;
	}
	
	//Will loop through payment options and get user's values
	//until change has reached 0 or less.
	public void takePayment() {
		
		//Create temporary variables to be used in the payment loops
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		int typeChoice = 0;
		double payAmount = 0;
		
		PaymentType debit = PaymentType.DEBIT_CARD;
		PaymentType credit = PaymentType.CREDIT_CARD;
		PaymentType cash = PaymentType.CASH;
		PaymentType check = PaymentType.CHECK;
		
		Payment payDebit = new Payment(debit, 0);
		Payment payCredit = new Payment(credit, 0);
		Payment payCash = new Payment(cash, 0);
		Payment payCheck = new Payment(check, 0);
		
		//Change will be the sentinel value for the post-test loop. Will
		//continue to loop through payment options until user has paid
		//the balance in total, where change will be 0 or less.
		change = this.total;
		
		do {
			//Print out payment options. Post-Test since the total
			//for a purchase will always be >0, so it'll always
			//need to be ran at least once.
			System.out.println("");
			System.out.println("How would you like to pay?");
			System.out.println("1. Cash\n2. Debit Card\n3. Credit Card\n4. Check\n");
			
			//Create condition to be met until user inputs a valid value/amount
			//If user's choice is 1 - 4, continue to options
			//If user's choice is not 1 - 4, output error message
			boolean test = true;
			while(test) {
				try{
					typeChoice = input.nextInt();
					test = false;
				}catch (Exception IOException){
					System.out.println("Incorrect value. Please try again.");
					input.nextLine();
				}
			}

			//If user's choice is valid, ask for payment amount for payment type
			if (typeChoice == 1) {
				System.out.println("Enter the amount to pay with this type.");
				//Prompt user for payment amount
				//Determine if user input is valid (amount > 0 and whole/floating point number)
				boolean test1 = true;
				while(test1) {
					try{
						payAmount = input1.nextDouble();
						if (payAmount > 0) {
							//If conditions met:
							//1) Add the amount to transactions PaymentType field
							//2) Subtract amount from change and store in change field,
							//3) Display remaining balance
							//4) Stop while loop
							payCash.setAmount(payCash.getAmount() + payAmount);
							this.change = this.change - payAmount;
							System.out.println("Total after payment is " + this.change);
							System.out.println("");
							test1 = false;
						}
						//Error message if user's amount is 0 or less
						else {
							System.out.println("Payment must be greater than 0. Please enter a different amount.");
							input1.nextLine();
						}
						//Error message if user's amount is not a whole/floating point number
					} catch (Exception IOException){
						System.out.println("Incorrect value. Please try again.");
						input1.nextLine();
					}
				}

			}

			//***The same code used for cash will be used for debit, credit, and check
			//Just change the typeChoice values and respective payment type.*********
			
			else if (typeChoice == 2) {
				System.out.println("Enter the amount to pay with this type:");
				boolean test2 = true;
				while(test2) {
					try {
						payAmount = input1.nextDouble();
						if (payAmount > 0) {
							payDebit.setAmount(payDebit.getAmount() + payAmount);
							this.change = this.change - payAmount;
							System.out.println("Total after payment is " + this.change);
							System.out.println("");
							test2 = false;
						}
						else {
							System.out.println("Payment must be greater than 0. Please enter a different amount.");
							input1.nextLine();
						}
					}catch (Exception IOException){
						System.out.println("Incorrect value. Please try again.");
						input1.nextLine();
					}
				}
			}
			else if (typeChoice == 3) {
				System.out.println("Enter the amount to pay with this type:");
				boolean test3 = true;
				while(test3) {
					try {
						payAmount = input1.nextDouble();
						if (payAmount > 0) {
							payCredit.setAmount(payCredit.getAmount() + payAmount);
							this.change = this.change - payAmount;
							System.out.println("Total after payment is " + this.change);
							System.out.println("");
							test3 = false;
						}
						else {
							System.out.println("Payment must be greater than 0. Please enter a different amount.");
							input1.nextLine();
						}
					}catch (Exception IOException){
						System.out.println("Incorrect value. Please try again.");
						input1.nextLine();
					}
				}
			}
			else if (typeChoice == 4) {
				System.out.println("Enter the amount to pay with this type:");
				boolean test4 = true;
				while(test4) {
					try {
						payAmount = input1.nextDouble();
						if (payAmount > 0) {
							payCheck.setAmount(payCheck.getAmount() + payAmount);
							this.change = this.change - payAmount;
							System.out.println("Total after payment is " + this.change);
							System.out.println("");
							test4 = false;
						}
						else {
							System.out.println("Payment must be greater than 0. Please enter a different amount.");
							input1.nextLine();
						}
					}catch (Exception IOException){
						System.out.println("Incorrect value. Please try again.");
						input1.nextLine();
					}
				}
			}
			//If user's choice is < 1 or > 4, output error message
			else {
				System.out.println("That was not a valid option. Please complete the transaction.");
			}
		} while(this.change > 0);
		
		//Assign payment values for payment type to the transaction's payment arraylist field
		payments.add(payDebit);
		payments.add(payCheck);
		payments.add(payCredit);
		payments.add(payCash);
	}
}