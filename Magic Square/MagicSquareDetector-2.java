/*
 * @author: Matt Wylie
 * @version: Assignment 4: Magic Square
 * @date: 3/17/2020
 * @description: This object will determine the validity of the file's variables, determine if the variables
 * 				 are in a square form factor, and also if the sum of the rows, columns, and diagonals of the square
 * 				 all equal the same number (Magic Number).
 */

public class MagicSquareDetector {

	private boolean isMagic;
	private boolean isSquare;
	private int magicNum;

	//Construct MagicSquareDetector with defaul values
	public MagicSquareDetector() {
		isMagic = false;
		isSquare = false;
		magicNum = 0;
	}
	
	//Getters and Setters
	public int getMagicNum() {
		return magicNum;
	}

	//Sets value of isSquare to true if length of rows and columns are teh same
	public boolean getIsSquare(int x, int y) {
		if(x == y) {
			isSquare = true;
		}
		else {
			isSquare = false;
		}
		return isSquare;
	}

	//Tests whether the sum of each row, column, diagonal, and reverse diagonal are the same.

	public boolean getIsMagic(int[][] x) {
		magicNum = 0;
		int test = 0;
		//Check if the square is, in fact, as square
		if (isSquare) {
			//Set the Magic Number to the sum of the first row of integers
			//The Magic Number is used to compare with the other sums throughout rest of the method
			for (int i = 0; i < x[0].length; i++) {
				magicNum = magicNum + x[0][i];
			}

			for (int i = 0; i < x.length; i++) {
				for (int j = 0; j < x[i].length; j++) {
					test = test + x[i][j];
				}
				if (test == magicNum) {
					isMagic = true;
				}
				else {
					isMagic = false;
					return isMagic;
				}
				test = 0;
			}

			test = 0;

			for (int row = 0; row < x[0].length; row++) {
				for (int col = 0; col < x.length; col++) {
					test = test + x[col][row];
				}
				if (test == magicNum) {
					isMagic = true;
				}
				else {
					isMagic = false;
					return isMagic;
				}
				test = 0;
			}

			test = 0;

			for (int i = 0; i < x.length; i++) {
				test = test + x[i][i];
			}

			if(test == magicNum) {
				isMagic = true;
			}
			else {
				isMagic = false;
				return isMagic;
			}

			test = 0;

			for (int i = x.length-1; i >= 0; i--) {
				test = test + x[i][i];
			}

			if(test == magicNum) {
				isMagic = true;
			}
			else {
				isMagic = false;
				return isMagic;
			}
		}
		//If the file has Strings, Chars, or the values of each column and row do not equal the magic number,
		//then output an error message.
		else {
			System.out.println("Your text file is not comprised of integers in a square format.");
			System.exit(0);
		}
		//If it passed all the tests, return true
		return isMagic;
	}

}
