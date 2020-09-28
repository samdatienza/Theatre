package sem2project1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;

public class Theatre {
	public static void main(String[] args) throws IOException {
	
	//Create linked list
	Deque<Movies> moviesReleased = new LinkedList<Movies>();
	Deque<Movies> moviesReceived = new LinkedList<Movies>();
		
	//Create scanner
	Scanner scanner = new Scanner(System.in);
		
	//Create Date formatting
	SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/YYYY");
	ft.setLenient(false);
		
	//Temp Values for manipulation
	String name = "";
	String releaseDate = "";
	String description = "";
	String receiveDate = "";
	
	//Create file input/output stream
	FileInputStream inputFile = new FileInputStream("Movies.txt");
	Scanner reader = new Scanner(inputFile);
		
	// Populating the lists, is ascending {releaseDate}
	Add.addFile(moviesReleased, moviesReceived, reader, ft);
	
	

	
	// Boolean to break loop
	Boolean run = true;
	while (run) {
		//Create text based menu
		System.out.println("Please choose an option: ");
		System.out.println("Press 'D' to display movies.");
		System.out.println("Press 'A' to add a movie.");
		System.out.println("Press 'S' to show movies with a given release date.");
		System.out.println("Press 'E' to edit movies.");
		System.out.println("Press 'C' to count movies.");
		System.out.println("Press 'X' to terminate program.");
		String option = scanner.next();
		
		if (option.toUpperCase().equals("D")) {
			
			System.out.println("You have selected to display movies.");
			System.out.println("Movies released:");
			Display.DisplayMovies(moviesReleased);
			System.out.println("Movies received:");
			Display.DisplayMovies(moviesReceived);
			
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
			System.out.print("Please enter release date -> ");
			String relDate = scanner.next();
			Display.ReleaseMovies(moviesReleased, moviesReceived, relDate, ft);
			
		} else if (option.toUpperCase().equals("E")) {
			System.out.println("You have selected to edit movies.");
			//Code to edit movies
		} else if (option.toUpperCase().equals("C")) {
			
			System.out.println("You have selected to count movies.");
			System.out.print("Enter given date -> ");
			String given;
			Count.CountMovies(moviesReleased, moviesReceived, given, ft);
			
		} else if (option.toUpperCase().equals("X")) {
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
