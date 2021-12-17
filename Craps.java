/*
 * Author: Matt Wylie
 * Date: 1/15/2020
 * 
 * Craps Game Rules:
 * 
 * First Roll: If 2 dice roll equals 7 or 11, you win
 * 			   If 2 dice roll equals 2, 3, or 12, you lose
 * 			   Any other number becomes pointer, then roll again
 * 
 * Subsequent Rolls: If 2 dice roll sum equals 7, 11, or pointer, you win
 * 					 If 2 dice roll sum equals 2, 3, or 12, you lose
 */

public class Craps {

	//Display results if player loses
	public static void displayLose(int wins, int lose) {
		System.out.println("LOSS!");
		System.out.println(wins + " win(s) , " + lose + " loss(es)");
		System.out.println("");
	}
	
	//Display results if player wins
	public static void displayWin(int wins, int lose) {
		System.out.println("WIN!");
		System.out.println(wins + " win(s) , " + lose + " loss(es)");
		System.out.println("");
	}

	//Generate random number b/w 1 and 6 for die
	public static int getRandom() {
		return (int)(Math.random() * 6 + 1 - 1) + 1;
	}

	//Display current round numbers, including round number, roll number, die 1 num, die 2 num, and sum of dice
	public static void displayResult(int roundNum, int rollNum, int x, int y, int sum2) {
		System.out.println("Round " + roundNum + " , Roll " + rollNum + " --  Die1: " + x + " , Die2: " + y + 
				" -- Total: " + sum2);
	}

	//Adds two numbers
	public static int sum(int x, int y) {
		return x + y;
	}

	public static void main(String[] args) {

		//Initialize starting integer variables for loop
		int lose = 0, wins = 0, pointer = 0, rollNum = 0, roundNum = 1, counter = 0;

		do {

			//Get starting number for 2 dice and sum
			int die1 = getRandom();
			int die2 = getRandom();
			int sum = sum(die1, die2);

			//Display first 10 rounds
			if (counter < 10) {
				displayResult(roundNum, rollNum, die1, die2, sum);
			}
			
			//If die roll neither wins or loses, set pointer to sum, then display pointer
			if ((sum != 2) && (sum != 3) && (sum != 7) && (sum != 11) && (sum != 12)) {
				pointer = sum;
				if (counter < 10) {
					System.out.println("Pointer is " + pointer);
				}
				//Role dice and find sum again, then display first 10 rounds
				die1 = getRandom();
				die2 = getRandom();
				sum = sum(die1, die2);
				rollNum++;
				if (counter < 10) {
					displayResult(roundNum, rollNum, die1, die2, sum);
				}
				//While the dice roll neither wins or loses, continue to roll and display first 10 rounds
				while ((sum != 2) && (sum != 3) && (sum != 7) && (sum != 11) && (sum != 12) && (sum != pointer)) {
					die1 = getRandom();
					die2 = getRandom();
					sum = sum(die1, die2);
					rollNum++;
					if (counter < 10) {
						displayResult(roundNum, rollNum, die1, die2, sum);
					}
				}
				
				//If dice sum reaches 7, 11, or pointer, display win results, increment round and win number, and set
				//roll number back to zero for next round
				if ((sum == 7) || (sum == 11) || (sum == pointer)) {
					wins++;
					if (counter < 10) {
						displayWin(wins, lose);
					}
					roundNum++;
					rollNum = 1;
				}
				//If dice sum is not a winning number, display lose results, increment round and lose number, and set
				//roll number back to zero for next round
				else {
					lose++;
					if (counter < 10) {
						displayLose(wins, lose);
					}
					roundNum++;
					rollNum = 1;
				}
			}
			//Dice won first roll - display win results, increment round and win number, and set
			//roll number back to zero for next round
			else if ((sum == 7) || (sum == 11) || (sum == pointer)) {
				wins++;
				if (counter < 10) {
					displayWin(wins, lose);
				}
				roundNum++;
				rollNum = 1;
			}
			//Dice lost first roll - display lose results, increment round and lose number, and set
			//roll number back to zero for next round
			else {
				lose++;
				if (counter < 10) {
					displayLose(wins, lose);
				}
				roundNum++;
				rollNum = 1;
			}
			//Increment counter to ensure only first 10 rounds are displayed
			counter++;
			
		//Loop 100,000 times
		} while(roundNum <= 100000);

		//Display overall win/lose stats for 100,000 rounds
		System.out.println("OVERALL: ");
		System.out.println(wins + " win(s) , " + lose + " loss(es)" );

	}
}

