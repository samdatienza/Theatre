package project_1;

import java.util.*;
import java.io.*;

public class Save {
	/**
	 * Will save to file
	 * @param release: deque list of released movies
	 * @param receive: deque list of received movies
	 * @param throws: for FileOutputStream
	 * @author Seth Wolf
	 */
	public static void save(Deque<Movies> release, Deque<Movies> receive) throws IOException {
		// FileOutputStream and PrintWriter
		FileOutputStream outputFile = new FileOutputStream("Movies.txt");
		PrintWriter wrt = new PrintWriter(outputFile);
		// Iterator
		Iterator<Movies> it = release.iterator();
		for (int i = 0; i < release.size(); ++i) {
			Movies curr = it.next();
			wrt.write(curr.toString() + "\n");
		}
		it = receive.iterator();
		for (int i = 0; i < receive.size(); ++i) {
			Movies curr = it.next();
			wrt.write(curr.toString() + "\n");
		}
		
		wrt.close();
		outputFile.close();
	}
}
