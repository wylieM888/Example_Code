/*
 * @author: Matt Wylie
 * @version: Assignment 2: Cash Register
 * @date: 2/13/2020
 * @description: This class will create the Item object,
 * 				 which is used to store the "grocery list",
 * 			     which includes the grocery item and its
 * 			     corresponding price.
 */
public class Item {

	//Create Item fields
	private String name;
	private double price;
	
	//Instantiate field
	public Item(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//Create getters/setters
	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setName(String x) {
		this.name = x;
	}
	
	public void setPrice(int x) {
		this.price = x;
	}
	
	//Create toString method that outputs individual
	//item's name and price in assignment's format
	public String toString() {
	String x = this.name + ": " + this.price;
	return x;
	
	}

}
