package project_1;

import java.text.SimpleDateFormat;
import java.util.*;

public class Count {
	/**
	 * Will count the number of movies with a release date earlier than a given date.
	 * @param releasedMovies: list of movies that have been released
	 * @param receivedMovies: list of movies that have been received
	 * @param given: the given date 
	 * @return: number of movies with a release date earlier than a given.
	 */
	public static void CountMovies(Deque<Movies> releasedMovies, Deque<Movies> receivedMovies, Date given, SimpleDateFormat ft) {
		// Iterator for {releasedMovies}
		Iterator<Movies> it1 = releasedMovies.iterator();
		// Iterator for {receivedMovies}
		Iterator<Movies> it2 = receivedMovies.iterator();
		int count = 0;
		// Checking {releasedMovies}
		while (it1.hasNext()) { if (given.after(it1.next().getReleaseDate())) { count++; } }
		// Checking {receivedMovies}
		while (it2.hasNext()) { if (given.after(it2.next().getReceivedDate())) { count++; } }
		
		if (count == 1) {
			System.out.println("There is " + count + " released movie before" + ft.format(given));
		}
		else {
			System.out.println("There are " + count + " released movies before " + ft.format(given));
		}
	}
}
