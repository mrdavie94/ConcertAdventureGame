package adventureGameAssignment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Name: David
 * Date: 03/08/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: A custom calendar utility for the game' timeline.
 * // Chapter 5 - Dates, Strings, and Localization: Implementation of a custom calendar
 * // Chapter 5 - Dates, Strings, and Localization: At least one date calculation
 */

// 5.1 - Use of dates and times
// 5.2 - Implementation of a custom calendar 
public class ConcertCalendar {

    private LocalDate currentDate;
    private LocalDate concertDate;

    public ConcertCalendar() {
        // Setting the current in-game date to today
        this.currentDate = LocalDate.now();
        // Setting the concert date to March 11, 2026
        this.concertDate = LocalDate.of(2026, 3, 11);
    }

    /**
     * Calculates the days remaining until the concert.
     */
    public void calculateDaysUntilConcert() {
        // CH 5: The Date Calculation
    	// 5.4 - At least one date calculation 
        long daysBetween = ChronoUnit.DAYS.between(currentDate, concertDate);

        System.out.println("\n[CALENDAR APP]: You check your phone.");
        if (daysBetween > 0) {
            System.out.println("The concert is in " + daysBetween + " days. The hype is real.");
        } else if (daysBetween == 0) {
            System.out.println("The concert is TODAY. Time to blast some metal!");
        } else {
            System.out.println("The concert was " + Math.abs(daysBetween) + " days ago. You're living in the past.");
        }
    }
}