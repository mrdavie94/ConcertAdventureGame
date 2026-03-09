package adventureGameAssignment;

/**
 * This class refers to a song played at the metal concert.
 * Implements Comparable to define the sorting order (alphabetical by title).
 * * @author David Lane
 * @version 1.0
 */

// 3.4 - Use of the Comparator or Comparable interface 
public class Song implements Comparable<Song> {
    
    private String title;
    private int durationInSeconds;

    /**
     * Constructor for a Song object.
     * * @param title The name of the song.
     * @param durationInSeconds The length of the song in seconds.
     */
    public Song(String title, int durationInSeconds) {
        this.title = title;
        this.durationInSeconds = durationInSeconds;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInSeconds() {
        return durationInSeconds;
    }

    /**
     * This is the method for the Comparable interface.
     * This will compare this song's title to another song title alphabetically.
     * * @param otherSong The song to compare this one to.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the object.
     */
    @Override
    public int compareTo(Song otherSong) {
        // Uses the String compareTo to sort alphabetically
        return this.title.compareTo(otherSong.getTitle());
    }

    @Override
    public String toString() {
        return title + " (" + durationInSeconds + "s)";
    }
}