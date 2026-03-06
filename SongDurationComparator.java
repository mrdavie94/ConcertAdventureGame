package adventureGameAssignment;

import java.util.Comparator;

/**
 * A custom Comparator used to sort Song objects by their duration, 
 * rather than their alphabetical title.
 * * @author David Lane
 * @version 1.0
 */
public class SongDurationComparator implements Comparator<Song> {

    /**
     * Compares two Song objects based on their duration (uses seconds).
     * * @param s1 The first song to compare.
     * @param s2 The second song to compare.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    @Override
    public int compare(Song s1, Song s2) {
        // Integer.compare handles the math
        return Integer.compare(s1.getDurationInSeconds(), s2.getDurationInSeconds());
    }
}