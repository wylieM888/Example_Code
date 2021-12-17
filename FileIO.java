import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileIO {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		readFromFile("test.txt");
		
	}

	public static void readFromFile(String fileName) throws FileNotFoundException {
		
		try {
		//Create new file and file scanner
		File myFile = new File(fileName);
		Scanner s = new Scanner(myFile);
		
		//Initialize dummy variables
		String name = "";
		int age = 0;
		String homeTown = "";

		//While there's a next line in the file, assign variables
		while(s.hasNextLine()) {
			name = s.nextLine();
			//If the user tries to pull some funny business and not put an int,
			//assign the age to 0
			try {
				age = Integer.parseInt(s.nextLine());
			}catch(Exception NumberFormatException) {
				age = 0;
			}
			homeTown = s.nextLine();
		}
		
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Hometown: " + homeTown);
		}catch(Exception FileNotFoundException) {
			System.out.println("There was no file by that name.");
		}
	}
}
