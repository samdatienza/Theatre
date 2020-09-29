package project_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import project_1.Movies.Status;

public class Add {
	/**
	 * Will add a movie from a file
	 * @param release: list of movies marked as released
	 * @param receive: list of movies marked as received
	 * @param reader: scanner for inputFile
	 * @param sdfrmt: to format dates	 
	 * @throws ParseException: for SimpleDateFormat method
	 * @author Seth Wolf
	 */
	public static void addFile(LinkedList<Movies> release, LinkedList<Movies> receive, Scanner reader, SimpleDateFormat sdfrmt) throws ParseException {
		while (reader.hasNext()) {
			String[] movieInfo = reader.nextLine().split(", ");
			Movies newMovie = new Movies(sdfrmt.parse(movieInfo[1]), movieInfo[0], movieInfo[2], sdfrmt.parse(movieInfo[3]), Status.valueOf(movieInfo[4]));
			if (newMovie.getStatus() == Status.released) { // Add to {release}
				addSorted(release, newMovie);
			}
			else if (newMovie.getStatus() == Status.received) { // Add to {receive}
				addSorted(receive, newMovie);
			}
		}
	}
	
	/** 
	 * Assuming all of the paramaters are correct, will add {movie} to {list}
	 * @param list: list of movies
	 * @param movie: movie need to be added to list
	 */
	public static void addSorted(LinkedList<Movies> list, Movies movie) {
		if (list.isEmpty()) { // Add {movie} to {list} if empty
			list.offerFirst(movie);
		}
		else if (movie.getReleaseDate().before(list.peekFirst().getReleaseDate()) || movie.getReleaseDate().equals(list.peekFirst().getReleaseDate())) { // Add {movie} to front
			list.offerFirst(movie);
		}
		else if (movie.getReleaseDate().after(list.peekLast().getReleaseDate()) || movie.getReleaseDate().equals(list.peekLast().getReleaseDate())) { // Add {movie} to end
			list.offerLast(movie);
		}
		else { // Add {movie} to {list} in neither earliest or latest release
			LinkedList<Movies> copy = new LinkedList<Movies>(); // Copy of {list}
			while (!list.isEmpty()) { copy.offerLast(list.pollFirst()); } // Populate {copy}
			while (!copy.isEmpty()) { 
				if (movie.getReleaseDate().before(copy.peekFirst().getReleaseDate()) || movie.getReleaseDate().equals(copy.peekFirst().getReleaseDate())) { // Will add {movie} to {list} and break loop
					list.offerLast(movie);
					break;
				}
				list.offerLast(copy.pollFirst());
			}
			if (!copy.isEmpty()) { // If {copy} still have {Movies} in it. Will populate the rest to {list}
				while (!copy.isEmpty()) { list.offerLast(copy.pollFirst()); }
			}
		}
		
	}
}
