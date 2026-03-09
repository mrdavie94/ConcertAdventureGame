package adventureGameAssignment;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Demonstrates the use of Sets and Maps in my adventure game.
 * Explains and uses Comparable and Comparator.
 * * @author David Lane
 * @version 1.0
 */
public class ConcertCollectionsDemo {

    /*
     * --- INSTRUCTOR NOTES: COMPARABLE VS COMPARATOR ---
     * * COMPARABLE:
     * - Defines the natural order of an object.
     * - The Song class implements Comparable.
     * - It only allows ONE sorting sequence so in my case it would be alphabetical by song title.
     * - Method used: compareTo(Object o)
     * * COMPARATOR:
     * - Defines a custom order of an object.
     * - It is an external class like SongDurationComparator that implements Comparator.
     * - It allows for multiple sorting sequences so I can create different comparators 
     * for things like song duration, release year, track number, etc., without changing the Song class.
     * - Method used: compare(Object o1, Object o2)
     */

    /**
     * The main execution method which test Sets, Maps, and sorting.
     * * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        
        System.out.println("--- DEMONSTRATING SET SORTING ---");
        
        // 1. TreeSet using Comparable (Natural Order -> Alphabetical)
        // A Set does not allow duplicates. A TreeSet sorts them automatically.
        // 3.3 - Use of a TreeSet or TreeMap
        Set<Song> alphabeticalSetlist = new TreeSet<>();
        alphabeticalSetlist.add(new Song("Symphony of Destruction", 240));
        alphabeticalSetlist.add(new Song("Enter Sandman", 330));
        alphabeticalSetlist.add(new Song("Paranoid", 170));
        
        System.out.println("Setlist sorted by Title (Comparable):");
        for (Song s : alphabeticalSetlist) {
            System.out.println("- " + s);
        }

        System.out.println("\n---------------------------------");

        // 2. TreeSet using Comparator (Custom Order -> Duration)
        // Passes the custom Comparator into the TreeSet constructor.
        Set<Song> durationSetlist = new TreeSet<>(new SongDurationComparator());
        durationSetlist.add(new Song("Symphony of Destruction", 240));
        durationSetlist.add(new Song("Enter Sandman", 330));
        durationSetlist.add(new Song("Paranoid", 170));

        System.out.println("Setlist sorted by Duration (Comparator):");
        for (Song s : durationSetlist) {
            System.out.println("- " + s);
        }

        System.out.println("\n--- DEMONSTRATING MAP SORTING ---");

        // 3. TreeMap using Comparable (Sorting by Key)
        // A Map stores the Key-Value pairs. A TreeMap automatically sorts by the Key.
        // Here, the Key is a String (Item Name), and the Value is an Int (Price).
        // Strings implement Comparable.
        Map<String, Integer> merchBooth = new TreeMap<>();
        merchBooth.put("Tour T-Shirt", 35);
        merchBooth.put("Band Poster", 15);
        merchBooth.put("Guitar Pick Set", 10);
        merchBooth.put("Hoodie", 60);

        System.out.println("Merch Booth Items sorted Alphabetically by Name:");
        for (Map.Entry<String, Integer> entry : merchBooth.entrySet()) {
            System.out.println("- " + entry.getKey() + ": $" + entry.getValue());
        }
    }
}