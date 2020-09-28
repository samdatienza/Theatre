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
	public static void DisplayMovies(Deque<Movies> list) {
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
	 * 1. The received list is empty
	 * 2. The released movie is already in the released list
	 * 3. The given date is invalid
	 * @param release: list of released movies
	 * @param received: list of received movies
	 * @param given: release date
	 * @param sdfmt: format for date
	 */
	public static void ReleaseMovies(Deque<Movies> release, Deque<Movies> received, String given, SimpleDateFormat sdfmt) {
		// Checking if {received} is empty or not.
		if (!received.isEmpty()) { // If {received} is not empty.
			// Checking first if {given} is in the correct format.
			Date releaseDate;
			try {
				releaseDate = sdfmt.parse(given);
			}
			catch (Exception e) {
				System.out.println("Invalid format");
				return;
			}
			// Making lists to use to copy data from received
			Deque<Movies> toBeReleased =  new LinkedList<Movies>();
			Deque<Movies> copyRec = new LinkedList<Movies>();
			Deque<Movies> copyRel = new LinkedList<Movies>();
			// Will be copy of {toBereleased} that are not in {released}
			Deque<Movies> copyTBR = new LinkedList<Movies>();
			// Iterator to go through list
			// Iterator for {released}
			Iterator<Movies> relIt = release.iterator();
			Movies currRel = null;
			
			// Going to find if there are any movies with the given released date. If so, will add to {toBeReleased} to add to {release} later, while making a copy of {received} into {copyRec}
			while (!received.isEmpty()) {
				if (received.peekFirst().getReleaseDate().equals(releaseDate)) {
					toBeReleased.offerLast(received.pollFirst());
				}
				else {
					copyRec.offerLast(received.pollFirst());
				}
			}
			
			// Re-populating {received}
			while(!copyRec.isEmpty()) { received.offerLast(copyRec.pollFirst()); }
			
			// Finding movies to be in {copyTBR}
			while (!toBeReleased.isEmpty()) {
				// Making sure starting from {head} of {release}
				relIt = release.iterator();
				for (int i = 0; i < release.size(); i++) {
					// If movie is in {release} then will remove from {toBeReleased} w/o adding to {copyTBR}
					currRel = relIt.next();
					if (toBeReleased.peekFirst().getName().equals(currRel.getName())) {
						toBeReleased.pollFirst();
						break;
					}
				}
				// Also, change {status} of {current} to {released}
				Movies current = toBeReleased.pollFirst();
				current.setStatus(Status.released);
				copyTBR.offerLast(current);
			}
			
			// Display movies to be released
			System.out.println("Movies to be released:");
			DisplayMovies(copyTBR);
			
			// Adding {copyTBR} to {released}
			while (!copyTBR.isEmpty()) {
				relIt = release.iterator();
				currRel = null;
				Movies found = null;
				while (relIt.hasNext()) {
					currRel = relIt.next();
					if (currRel.equals(copyTBR.peekFirst())) {
						found = currRel;
					}
				}
				if (found != null) { // If {copyTBR}'s {head} is already in {release} will just remove
					copyTBR.pollFirst();
				}
				if (release.isEmpty()) { // Add {copyTBR} {head} in front of {release} {head}
					release.offerFirst(copyTBR.pollFirst());
				}
				if (copyTBR.peekFirst().getReleaseDate().before(release.peekFirst().getReleaseDate())) { // Add to front if {copyTBR} {head}'s {releaseDate} is before {release} {head}'s {releaseDate}
					release.offerFirst(copyTBR.pollFirst());
				}
				if (copyTBR.peekFirst().getReleaseDate().after(release.peekLast().getReleaseDate())) { // Add to end if {copyTBR} {head}'s {releaseDate} is after {release} {tail}'s {releaseDate}
					release.offerLast(copyTBR.pollFirst());
				}
				else { // If {copyTBR}'s {head} is neither the earliest or latest {releaseDate} will remove {release}'s {head} until {copyTBR}'s {head} {releaseDate} is before {release}'s head
					while (!release.isEmpty()) { copyRel.offerLast(release.pollFirst()); } // Copy of {release}
					while (!copyRel.isEmpty()) { 
						if (copyTBR.peekFirst().getReleaseDate().before(copyRel.peekFirst().getReleaseDate())) {
							release.offerLast(copyTBR.pollFirst());
						}
						release.offerLast(copyRel.pollFirst());
					}
				}
				
			}
		}
		else { // If {received} is empty.
			System.out.println("No new movies to release.");
			return;
		}
	}
}
