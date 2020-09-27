package sem2project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class Theatre {
	public static void main(String[] args) throws IOException {
	
	//Create linked list
	Deque<Movies> list = new LinkedList<Movies>();
	// Create iterator
	Iterator<Movies> it = list.iterator();
		
	//Create scanner
	Scanner scanner = new Scanner(System.in);
		
	//Create Date formatting
	SimpleDateFormat ft = new SimpleDateFormat ("mm/dd/YYYY");
		
	//Temp Values for manipulation
	String name = "";
	String releaseDate = "";
	String description = "";
	String receiveDate = "";
	
	//Create file input/output stream
	FileInputStream inputFile = new FileInputStream("Movies.txt");
	Scanner reader = new Scanner(inputFile);
	
	//Create text based menu
	System.out.println("Please choose an option: ");
	System.out.println("Press 'D' to display movies.");
	System.out.println("Press 'A' to add a movie.");
	System.out.println("Press 'S' to show movies with a given release date.");
	System.out.println("Press 'E' to edit movies.");
	System.out.println("Press 'C' to count movies.");
	System.out.println("Press 'X' to terminate program.");
	
	// Boolean to break loop
	Boolean run = true;
	while (run) {
		String option = scanner.next();
		if (option.toUpperCase().equals("D")) {
			System.out.println("You have selected to display movies.");
			Display.DisplayMovies(list, it);
		} else if (option.toUpperCase().equals("A")) {
			System.out.println("You have selected to add a movie.");
			//Code to add movie
			System.out.println("Please enter the Movie's name.");
			name = scanner.next();
			System.out.println("Please enter the Movie's release date.");
			releaseDate = scanner.next();
			System.out.println("Please enter the Movie's description.");
			description = scanner.next();
			System.out.println("Please enter the Movie's recieve date.");
			receiveDate = scanner.next();
			

		} else if (option.toUpperCase().equals("S")) {
			System.out.println("You have selected to show movies with a given release date.");
			//Code to show movies with given release date
		} else if (option.toUpperCase().equals("E")) {
			System.out.println("You have selected to edit movies.");
			//Code to edit movies
		} else if (option.toUpperCase().equals("C")) {
			System.out.println("You have selected to count movies.");
			//Code to count movies
		} else if (option.toUppperCase().equals("X")) {
			System.out.println("You have selected to terminate the program.");
			run = !run;
			break;
		} else {
			System.out.println("You have selected an invalid option, please try again.");
			continue;
		}
		System.out.println("Please choose an option: ");
		System.out.println("Press 'D' to display movies.");
		System.out.println("Press 'A' to add a movie.");
		System.out.println("Press 'S' to show movies with a given release date.");
		System.out.println("Press 'E' to edit movies.");
		System.out.println("Press 'C' to count movies.");
		System.out.println("Press 'X' to terminate program.");
	}
	
	//Close Everything
	reader.close();
	scanner.close();
	inputFile.close();
	
	}
}
