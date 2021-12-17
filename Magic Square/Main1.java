/*
 * @author: Matt Wylie
 * @version: Assignment 4: Magic Square
 * @date: 3/17/2020
 * @description: This program will prompt the user for a text file, read the file, determine if the
 *               file has appropriate values (integers) and if in a square form factor, determine if
 *               the values are a Magic Square, then output whether or not the integers provided were 
 *               a Magic Square.
 */

import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main1 {

	public static void main(String[] args) throws IOException{

		FileInputStream fileByteStream = null;
		Scanner inFS = null;
		int fileNum;
		String userFile = "";
		
		//Prompt user for file location and name
		//Example: "C:\Users\Matt\Desktop\TestFile.txt"
		try {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter the textfile path and name: ");
			userFile = input.nextLine();
			fileByteStream = new FileInputStream(userFile);
			inFS = new Scanner(fileByteStream);
		}catch(Exception FileNotFoundException) {
			System.out.println("Sorry. I did't find the file you were looking for.");
			System.exit(0);
		}

		//Initialize row/column length, then colCheck which will check if rows are equal in length
		int rowL = 0;
		int colL = 0;
		int colCheck = 0;
		
		//Find the length of columns/rows, output error message if not square or incorrect variables in file
		//Create a string from the inFS Scanner's next line, then another Scanner to scan the string to differentiate rows
		try {
			while(inFS.hasNextInt()) {
				colL = 0;
				String test = inFS.nextLine();
				Scanner newLineCheck = new Scanner(test);
				while(newLineCheck.hasNextInt()) {
					int trash = newLineCheck.nextInt();
					colL++;
				}
				if (rowL == 0) {
					colCheck = colL;
				}
				//If the number of columns don't match each other, output error message
				if(colCheck != colL) {
					System.out.println("Your file of numbers is not in a square form factor.");
					System.exit(0);
				}
				rowL++;
			}
		}catch(Exception InputMismatchException) {
			System.out.println("There was a non-integer variable in your file. Either update your file or try a different file.");
			fileByteStream.close();
			System.exit(0);
		}

		//Initialize new 2d int array
		int[][] square = new int[rowL][colL];

		//Initialize increment variables for storing file variables
		int u = 0;
		int h = 0;

		//Create new MagicSquareDetector to determine if the file is a square before initializing array elements
		MagicSquareDetector mSD = new MagicSquareDetector();

		//Create a new filestream and scanner to start fresh. Created try/catch to fix compile error.
		try {
			fileByteStream = new FileInputStream(userFile);
			inFS = new Scanner(fileByteStream);
		}
		catch(Exception FileNotFoundException) {
			System.out.println("Sorry. I did't find the file you were looking for.");
			fileByteStream.close();
			System.exit(0);
		}

		//Used same 2 Scanner method as above. Will increment as long as inFS Scanner has next int, u is less than row length, and it's in a square form factor
		
		while(inFS.hasNextInt() && u < rowL && mSD.getIsSquare(rowL, colL)) {
			h = 0;
			String test = inFS.nextLine();
			Scanner newLineCheck = new Scanner(test);
			//Will loop until there are no more ints or h quals column length
			while(newLineCheck.hasNextInt() && h < colL) {
				square[u][h] = newLineCheck.nextInt();
				h++;
			}
			u++;
		}
		
		//Create a new MagicSquare object
		MagicSquare magSquare = new MagicSquare(rowL, colL);

		//If the MagicSquare is magic and is a square, initialize MagicSquare with correct values, generate MagicSquare string, then output string
		if (mSD.getIsMagic(square) && mSD.getIsSquare(rowL, colL)) {
			magSquare = new MagicSquare(rowL, colL, square);
			magSquare.setMagicNum(mSD.getMagicNum());
			String magicString = magSquare.toString();
			System.out.println(magicString);
			fileByteStream.close();
		}
		
		//Error messages for the various scenarios that could've went wrong
		else if (mSD.getIsSquare(rowL, colL) == false && mSD.getIsMagic(square) == false){
			System.out.println("Your file is neither square nor magic");
		}
		
		else if (mSD.getIsSquare(rowL, colL) == false) {
			System.out.println("You file is not a square.");
		}
		
		else if (mSD.getIsMagic(square) == false){
			System.out.println("Your square is not magic.");
			fileByteStream.close();
		}

		else {
			System.out.println("Your file is neither square nor magic");
		}

	}

}
