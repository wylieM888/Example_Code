/*
 * @author: Matt Wylie
 * @version: Assignment 2: Cash Register
 * @date: 2/13/2020
 * @description: This class will create the Payment object,
 * 				 which is used to store the payment type 
 * 				 (cash, credit, debit, and check) and the 
 * 				 amount the user has paid with each type.
 */

public class Payment {

	//Create Payment fields
	private PaymentType type;
	private double amount;
	
	//Create Payment constructor
	public Payment(PaymentType type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	//Create getters/setters
	public PaymentType getType(){
		return this.type;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public void setType(PaymentType type) {
		this.type = type;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
