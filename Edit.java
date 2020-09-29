package project2;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Edit {
	
	
	// Will edit a requested movies description or release date
	//Lacks testing please test

	public static void editMovie(LinkedList<Movies> receivedMovies, String editName, SimpleDateFormat ft) {
		String updatedDesc = "";
		String updatedReleaseDate = "";
		Date updatedRelDate;
		// Iterator for {receivedMovies}
		Iterator<Movies> it2 = receivedMovies.iterator();
		//Search for requested movie
		while (it2.hasNext()) { 
			//Iterate through list to find requested name
			String findName = it2.next().getName();
			if (editName.equals(findName)) {
				//Give options for changing description or release date
				System.out.println("Movie Found! Please choose option:");
				System.out.println("Press 'D' to edit description");
				System.out.println("Press 'R' to edit release Date");
				//FIX ME: Make the scanner happy and have it pull in what user put in
				String selection = Scanner.next();
				//Change the description
				if (selection.toUpperCase().equals("D")) {
					System.out.println("You have chosen to update the description.");
					System.out.println("The current description is: " + it2.next().getDescription());
					System.out.println("Enter new description:");
					//FIX ME: Make the scanner happy and have it pull in what user put in
					updatedDesc = Scanner.next();
					it2.next().setDescription(updatedDesc);
				}
				//Change the release date
				if (selection.toUpperCase().equals("R")) {
					System.out.println("You have chosen to update the release date.");
					System.out.println("The current release date is: " + it2.next().getReleaseDate());
					System.out.println("Enter new release date:");
					//FIX ME: Make the scanner happy and have it pull in what user put in
					updatedReleaseDate = Scanner.next();
					//Check for correct formatting
					try {
						updatedRelDate = (Date) ft.parse(updatedReleaseDate);
					}
					catch (Exception e) {
						System.out.println("Invalid date format\n");
						return;
					}
					it2.next().setReleaseDate(updatedRelDate);
					
				}
				}
			//User inputed a movie not in the list
			else {
				System.out.println("Movie not found");
			}
			}
	}
}
