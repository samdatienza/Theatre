package project_1;

import java.text.SimpleDateFormat;
import java.util.*;

import project_1.Movies.Status;

public class Display {
	/**
	 * Displays the movies in the linked list
	 * @param list: list of movies
	 * @author Seth Wolf
	 */
	public static void DisplayMovies(LinkedList<Movies> list) {
		// Using {it} to move through the list
		Iterator<Movies> it = list.iterator();
		// Checking if there has an movies left
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println();
	}
	
	/**
	 * Will show movies from the received list from the given date unless
	 * 1. The movie does not exist
	 * 2. The released movie is already in the released list
	 * 3. The given date is invalid
	 * @param release: list of released movies
	 * @param received: list of received movies
	 * @param given: release date
	 * @param sdfmt: format for date
	 */
	public static void ReleaseMovies(LinkedList<Movies> release, LinkedList<Movies> receive, Date given, SimpleDateFormat sdfmt) {
		try {
			sdfmt.format(given);
		}
		catch (Exception e) {
			System.out.println("Invalid date format");
		}
		LinkedList<Movies> toBeReleased = new LinkedList<Movies>();
		Iterator<Movies> it = null;
		Iterator<Movies> it2 = null; 
		Movies current, relCur, remove, recCur;
		// Will check if there is a movie in {receive} with {given}
		it = receive.iterator();
		while (it.hasNext()) {
			current = it.next();
			if (current.getReleaseDate().equals(given)) {
				toBeReleased.offerLast(current);
			}
		}

		// Checking if a movie in {toBeReleased} is in {release}
		it = toBeReleased.iterator();
		while (it.hasNext()) {
			current = it.next();
			it2 = release.iterator();
			while (it2.hasNext()) {
				relCur = it2.next();
				if (current.getName().equals(relCur.getName())) { // Will remove {remove} from {toBeReleased} 
					remove = relCur;
					LinkedList<Movies> copy = new LinkedList<Movies>();
					while (!toBeReleased.isEmpty()) { copy.offerLast(toBeReleased.pollFirst()); }
					while (!copy.isEmpty()) {
						if (remove.getName().equals(copy.peekFirst().getName())) {
							copy.pollFirst();
						}
						else {
							toBeReleased.offerLast(copy.pollFirst());
						}
					}
					it = toBeReleased.iterator();
				}
			}
		}		
		
		if (toBeReleased.isEmpty()) {
			System.out.println("No movie(s) to be released");
			return;
		}
		
		// Add movies while changing the {Status}
		it = toBeReleased.iterator();
		while (it.hasNext()) {
			current = it.next();
			current.setStatus(Status.released);
			Add.addSorted(release, current);
		}
		
		// Removing movie from receive
		it = receive.iterator();
		while (it.hasNext()) {
			recCur = it.next();
			it2 = toBeReleased.iterator();
			while (it2.hasNext()) {
				current = it2.next();
				if (recCur.getName().equals(current.getName())) {
					remove = current;
					LinkedList<Movies> copy = new LinkedList<Movies>();
					while (!receive.isEmpty()) { copy.offerLast(receive.pollFirst()); }
					while (!copy.isEmpty()) {
						if (remove.getName().equals(copy.peekFirst().getName())) {
							copy.pollFirst();
						}
						else {
							receive.offerLast(copy.pollFirst());
						}
					}
					it = receive.iterator();
				}
			}
		}
	}
	
}
