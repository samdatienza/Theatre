package project_1;

import java.util.*;

public class Display {
	public static void DisplayMovies(Deque<Movies> list, Iterator<Movies> it) {
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
