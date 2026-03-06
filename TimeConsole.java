package adventureGameAssignment;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * This class handles any time-based messaging for my Adventure Game.
 * It also determines the current time of day and retrieves
 * localized messages (English or Spanish) back to the user.
 * * @author David Lane
 * @version 1.0
 */
public class TimeConsole {

    /**
     * The main method used to run the application.
     * * 
     */
    public static void main(String[] args) {
        // --- TEST CASE 1: English, Early Morning (3:00 AM) ---
        System.out.println("--- Test 1: English / 03:00 ---");
        displayMessage(LocalTime.of(3, 0), Locale.US);

        // --- TEST CASE 2: Spanish, Noon (12:30 PM) ---
        System.out.println("\n--- Test 2: Spanish / 12:30 ---");
        displayMessage(LocalTime.of(12, 30), new Locale("es", "ES"));

        // --- TEST CASE 3: English, Evening (10:00 PM) ---
        System.out.println("\n--- Test 3: English / 22:00 ---");
        displayMessage(LocalTime.of(22, 0), Locale.US);
        
        // --- TEST CASE 4: Current Real Time ---
        System.out.println("\n--- Test 4: Current System Time ---");
        displayMessage(LocalTime.now(), Locale.getDefault());
    }

    /**
     * Displays a message to the console from the given time and locale.
     * Loads the appropriate ResourceBundle and selects the key
     * for the specific time of day.
     * * @param time   The LocalTime object showing the specific time to test.
     * @param locale The Locale object (e.g., Locale.US or new Locale("es", "ES")).
     */
    public static void displayMessage(LocalTime time, Locale locale) {
        // Loads the properties file based on the locale
        // It looks for GameMessages first, then appends _es if needed.
        ResourceBundle messages = ResourceBundle.getBundle("GameMessages", locale);
        
        String key = getTimeKey(time);
        String output = messages.getString(key);
        
        System.out.println("Time: " + time + " | Message: " + output);
    }

    /**
     * Determines the correct property key based on the provided times.
     * Ranges:
     * Early Morning: 00:00 - 06:00
     * Morning:       06:01 - 11:59
     * Noon:          12:00 - 12:59
     * Afternoon:     13:00 - 20:59
     * Evening:       21:00 - 23:59
     * * @param time The LocalTime to evaluate.
     * @return A String representing the key in the properties file.
     */
    public static String getTimeKey(LocalTime time) {
        // Uses isBefore/isAfter logic
        if (time.isBefore(LocalTime.of(6, 1))) {
            return "early_morning";
        } else if (time.isBefore(LocalTime.of(12, 0))) {
            return "morning";
        } else if (time.isBefore(LocalTime.of(13, 0))) {
            return "noon";
        } else if (time.isBefore(LocalTime.of(21, 0))) {
            return "afternoon";
        } else {
            return "evening";
        }
    }
}