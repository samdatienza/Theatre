package project_1;

import java.util.*;

public class Display {
	/**
	 * Displays the movies in the linked list
	 * @param list: list of movies
	 */
	public static void DisplayMovies(Deque<Movies> list) {
		// Using {it} to move through the list
		Iterator<Movies> it = list.iterator();
		// Checking if there has an movies left
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
