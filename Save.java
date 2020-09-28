package project_1;

import java.util.*;
import java.io.*;

public class Save {
	/**
	 * Will save to file using passed {wrt}
	 * @param list: list filled with movies
	 * @param wrt: the PrintWriter
	 * @author Seth Wolf
	 */
	public static void save(Deque<Movies> list, PrintWriter wrt) {
		// Iterator
		Iterator<Movies> it = list.iterator();
		for (int i = 0; i < list.size(); ++i) {
			Movies curr = it.next();
			wrt.println(curr.toString());
		}
	}
}
