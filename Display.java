package project_1;

import java.util.*;

public class Display {
	public static void DisplayMovies(Deque<Movies> list) {
		// Displaying the movies by using {it}
		new Iterator<Movies> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
