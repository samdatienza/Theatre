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
	public static void addFile(Deque<Movies> release, Deque<Movies> receive, Scanner reader, SimpleDateFormat sdfrmt) throws ParseException {
		while (reader.hasNext()) {
			String[] movieInfo = reader.nextLine().split(", ");
			Movies newMovie = new Movies(sdfrmt.parse(movieInfo[1]), movieInfo[0], movieInfo[2], sdfrmt.parse(movieInfo[3]), Status.valueOf(movieInfo[4]));
			if (newMovie.getStatus() == Status.released) { // Add to {release}
				if (release.isEmpty()) { // Add to front it {release} is empty
					release.offerFirst(newMovie);
				}
				if (newMovie.getReleaseDate().before(release.peekFirst().getReleaseDate())) { // Add to front if {release}'s {releaseDate} is after {newMovie}'s {releaseDate}
					release.offerFirst(newMovie);
				}
				if (newMovie.getReleaseDate().after(release.peekLast().getReleaseDate())) { // Add to back if {release}'s {releaseDate} is before {newMovies}'s {releaseDate}
					release.offerLast(newMovie);
				}
				else { // If {newMovie}'s {releaseDate} is neither the earliest or latest {releaseDate}
					// Make a copy of {release}
					Deque<Movies> copyRel = new LinkedList<Movies>();
					while (!release.isEmpty()) { copyRel.offerLast(release.pollFirst()); } 
					while (!copyRel.isEmpty()) { // Check's {newMovie}'s {releaseDate} and fill {release} again
						if (newMovie.getReleaseDate().before(copyRel.peekFirst().getReleaseDate())) {
							release.offerLast(newMovie);
						}
						release.offerLast(copyRel.pollFirst());
					}
				}
			}
			else if (newMovie.getStatus() == Status.received) { // Add to {receive}
				if (receive.isEmpty()) { // Add to front it {receive} is empty
					receive.offerFirst(newMovie);
				}
				if (newMovie.getReleaseDate().before(receive.peekFirst().getReleaseDate())) { // Add to front if {receive}'s {releaseDate} is after {newMovie}'s {releaseDate}
					receive.offerFirst(newMovie);
				}
				if (newMovie.getReleaseDate().after(receive.peekLast().getReleaseDate())) { // Add to back if {receive}'s {releaseDate} is before {newMovies}'s {releaseDate}
					receive.offerLast(newMovie);
				}
				else { // If {newMovie}'s {releaseDate} is neither the earliest or latest {releaseDate}
					// Make a copy of {receive}
					Deque<Movies> copyRec = new LinkedList<Movies>();
					while (!release.isEmpty()) { copyRec.offerLast(release.pollFirst()); } 
					while (!copyRec.isEmpty()) { // Check's {newMovie}'s {releaseDate} and fill {release} again
						if (newMovie.getReleaseDate().before(copyRec.peekFirst().getReleaseDate())) {
							release.offerLast(newMovie);
						}
						release.offerLast(copyRec.pollFirst());
					}
				}
			}
		}
	}
}
