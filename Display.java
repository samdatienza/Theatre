package project_1;

import java.util.*;

public class Display {
	public static void DisplayMovies(Deque<Movies> list, Iterator<Movies> it) {
		// Displaying the movies by using {it}
		it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
