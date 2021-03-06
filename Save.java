package project_1;

import java.util.*;
import java.io.*;

public class Save {
	/**
	 * Will save to file
	 * @param release: LinkedList list of released movies
	 * @param receive: LinkedList list of received movies
	 * @param throws: for FileOutputStream
	 * @author Seth Wolf
	 */
	public static void save(LinkedList<Movies> release, LinkedList<Movies> receive) throws IOException {
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
