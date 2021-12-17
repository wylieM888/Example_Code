/*
 * @author: Matt Wylie
 * @version: Assignment 4: Magic Square
 * @date: 3/17/2020
 * @description: This object will store the length of rows and columns, the values of the text file in a 2-d array, and
 * 				 the magic number (the value that sum of rows and columns equal).
 */

public class MagicSquare {

	private int numR;
	private int numC;
	private int[][] square;
	private int magicNum;

	//Construct a dummy MagicSquare Object
	public MagicSquare(int numR, int numC) {
		this.numR = numR;
		this.numC = numC;
		square = new int[numR][numC];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				square[i][j] = -11;
			}
		}
	}

	//Construct a MagicSquare Object with a 2-D array 
	public MagicSquare(int numR, int numC, int[][] x) {
		this.numR = numR;
		this.numC = numC;
		square = new int[numR][numC];
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				square[i][j] = x[i][j];
			}
		}
	}

	//Getter and Setters
	public int getNumR() {
		return numR;
	}
	public void setNumR(int numR) {
		this.numR = numR;
	}
	public int getNumC() {
		return numC;
	}
	public void setNumC(int numC) {
		this.numC = numC;
	}
	public int[][] getSquare() {
		return square;
	}
	
	public void setSquare(int[][] x) {
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				square[i][j] = x[i][j];
			}
		}
	}

	public int getMagicNum() {
		return magicNum;
	}

	public void setMagicNum(int x) {
		magicNum = x;
	}

	//Returns a string of the magic square in the format provided in the assignment
	public String toString() {
		String x = "The combination of numbers ";
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[i].length; j++) {
				x = x + square[i][j] + " ";
			}
		}
		x = x + "is a magic square of order " + numR + ". The magic constant is " + magicNum +".";

		return x;
	}

}
