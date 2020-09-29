package project_1;

import java.util.*;
import java.text.SimpleDateFormat;

public class Edit {
	
	
	// Will edit a requested movies description or release date
	//Lacks testing please test

	public static void editMovie(LinkedList<Movies> receivedMovies, String editName, SimpleDateFormat ft, Scanner scnr) {
		String updatedDesc;
		String updatedReleaseDate;
		Date updatedRelDate;
		// Iterator for {receivedMovies}
		Iterator<Movies> it2 = receivedMovies.iterator();
		//Search for requested movie
		while (it2.hasNext()) { 
			//Iterate through list to find requested name
			Movies found = it2.next();
			if (editName.equals(found.getName())) {
				//Give options for changing description or release date
				System.out.println("Movie Found! Please choose option:");
				System.out.println("Press 'D' to edit description");
				System.out.println("Press 'R' to edit release Date");
				//Change the description
				String selection = scnr.nextLine();
				if (selection.toUpperCase().equals("D")) {
					System.out.println("You have chosen to update the description.");
					System.out.println("The current description is: " + found.getDescription());
					System.out.println("Enter new description:");
					updatedDesc = scnr.nextLine();
					found.setDescription(updatedDesc);
				}
				//Change the release date
				if (selection.toUpperCase().equals("R")) {
					System.out.println("You have chosen to update the release date.");
					System.out.println("The current release date is: " + ft.format(found.getReleaseDate()));
					System.out.println("Enter new release date:");
					updatedReleaseDate = scnr.nextLine();
					//Check for correct formatting
					try {
						updatedRelDate = ft.parse(updatedReleaseDate);
					}
					catch (Exception e) {
						System.out.println("Invalid date format\n");
						return;
					}
					found.setReleaseDate(updatedRelDate);
					
				}
				break;
			}
			//User inputed a movie not in the list
			else {
				System.out.println("Movie not found");
			}
		}
	}
}