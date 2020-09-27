package sem2project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Theatre {
	public static void main(String[] args) throws IOException {
	
	//Create linked list
		//LinkedList list = new LinkedList();
		
	//Create scanner
	Scanner scanner = new Scanner(System.in);
	
	//Create file input/output stream
	FileInputStream inputFile = new FileInputStream("Movies.txt");
	
	//Create text based menu
	System.out.println("Please choose an option: ");
	System.out.println("Press 'D' to display movies.");
	System.out.println("Press 'A' to add a movie.");
	System.out.println("Press 'S' to show movies with a given release date.");
	System.out.println("Press 'E' to edit movies.");
	System.out.println("Press 'C' to count movies.");
	System.out.println("Press 'X' to terminate program.");
	
	String option = scanner.next();
	While true {
		if (option.equals("D")) {
			System.out.println("You have selected to display movies.");
			//Code to display movies
		} else if (option.equals("A")) {
			System.out.println("You have selected to add a movie.");
			//Code to add movie 
		} else if (option.equals("S")) {
			System.out.println("You have selected to show movies with a given release date.");
			//Code to show movies with given release date
		} else if (option.equals("E")) {
			System.out.println("You have selected to edit movies.");
			//Code to edit movies
		} else if (option .equals("C")) {
			System.out.println("You have selected to count movies.");
			//Code to count movies
		} else if (option.equals("X")) {
			System.out.println("You have selected to terminate the program.");
			//Code to Terminate program
			break;
		} else {
			System.out.println("You have selected an invalid option, please try again.");
			continue;
	}
	
	//Close Everything
	scanner.close();
	inputFile.close();
	
	}
}
