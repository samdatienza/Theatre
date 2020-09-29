package project_1;

import java.io.*;
import java.text.*;
import java.util.*;

import project_1.Movies.Status;



public class Theatre {
	public static void main(String[] args) throws IOException, ParseException {
	
	//Create linked list
	LinkedList<Movies> moviesReleased = new LinkedList<Movies>();
	LinkedList<Movies> moviesReceived = new LinkedList<Movies>();
	// For formating dates
	SimpleDateFormat ft = new SimpleDateFormat("MM/dd/yyyy");
	ft.setLenient(false);
		
	//Create scanner
	Scanner scanner = new Scanner(System.in);
	
	//Create file input stream
	FileInputStream inputFile = new FileInputStream("Movies.txt");
	Scanner reader = new Scanner(inputFile);
	
	// Populating the lists, in ascending {releaseDate}
	Add.addFile(moviesReleased, moviesReceived, reader, ft);
	
	// Closing {reader} and {inputFile}
	inputFile.close();
	reader.close();
	

	
	//Temp Values for manipulation
	String name;
	String releaseDate;
	String receiveDate;
	String description;
	
	
	// Boolean for while loop
	Boolean run = true;
	while (run) {
		//Create text based menu
		System.out.println("Please choose an option: ");
		System.out.println("Press 'D' to display movies.");
		System.out.println("Press 'A' to add a movie.");
		System.out.println("Press 'S' to show movies with a given release date.");
		System.out.println("Press 'E' to edit movies.");
		System.out.println("Press 'C' to count movies.");
		System.out.println("Press 'V' to save movies.");
		System.out.println("Press 'X' to terminate program.");
		String option = scanner.nextLine();
		
		if (option.toUpperCase().equals("D")) {
			
			System.out.println("You have selected to display movies.");
			System.out.println("Movies Released:");
			Display.DisplayMovies(moviesReleased);
			System.out.println("Movies Received:");
			Display.DisplayMovies(moviesReceived);
			
		} else if (option.toUpperCase().equals("A")) {
			
			System.out.println("You have selected to add a movie.");
		 	//Gather needed data for movie to be added
			System.out.println("Please enter the Movie's name.");
			name = scanner.nextLine();
			System.out.println("Please enter the Movie's release date.");
			releaseDate = scanner.nextLine();
			System.out.println("Please enter the Movie's description.");
			description = scanner.nextLine();
			System.out.println("Please enter the Movie's recieve date.");
			receiveDate = scanner.nextLine();
			
			boolean matchFound = false;
			Iterator<Movies> i = moviesReceived.iterator();
			//Check to see if movie is already in list
			while (i.hasNext()) {
				if (i.next().getName().equals(name)) {
					matchFound = true;
					break;
				} 
			}
			try {
				ft.parse(releaseDate).after(ft.parse(receiveDate));
			}
			catch (Exception e) {
				System.out.println("The movie you tried to enter is invalid.");
				System.out.println();
				continue;
			}
			if (!matchFound && ft.parse(releaseDate).after(ft.parse(receiveDate))) {
				//takes gathered info, creates it in a movies object, and adds to the list, then sorts the list
				Movies newMovie = new Movies(ft.parse(releaseDate), name, description, ft.parse(receiveDate), Status.received);
				Add.addSorted(moviesReceived, newMovie);
			
			}
			 else {
				System.out.println("The movie you tried to enter is invalid.");
			}

			
		} else if (option.toUpperCase().equals("S")) {
			
			System.out.println("You have selected to show movies with a given release date.");
			System.out.print("Please enter release date -> ");
			Date relDate = ft.parse(scanner.nextLine());
			Display.ReleaseMovies(moviesReleased, moviesReceived, relDate, ft);
			
		} else if (option.toUpperCase().equals("E")) {
			
			System.out.println("You have selected to edit movies.");
			System.out.println("Enter movie to edit.");
			String editName = scanner.nextLine();
			Edit.editMovie(moviesReceived, editName, ft, scanner);
			
		} else if (option.toUpperCase().equals("C")) {
			
			System.out.println("You have selected to count movies.");
			System.out.print("Enter given date -> ");
			String given = scanner.nextLine();
			Count.CountMovies(moviesReleased, moviesReceived, given, ft);
			
		} else if (option.toUpperCase().equals("X")) {
			
			System.out.println("You have selected to terminate the program.");
			run = !run;
			Save.save(moviesReleased, moviesReceived);
			break;
			
		} else if(option.toUpperCase().equals("V")) {
			
			System.out.println("You have selected to save movies.");
			Save.save(moviesReleased, moviesReceived);
			
		} else {
			
			System.out.println("You have selected an invalid option, please try again.");
			continue;
			
		}
		System.out.println();
	}
	
	//Close Everything else
	scanner.close();
	
	}
}
