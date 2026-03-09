package adventureGameAssignment;

/**
 * Name: David
 * Date: 03/08/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: Custom exception triggered when the player sleeps without setting an alarm.
 * // Chapter 6 - Exceptions: Use and creation of a custom exception
 */
public class MissedBusException extends Exception {
    
    // Constructor that passes the custom message to the parent Exception class
    public MissedBusException(String message) {
        super(message);
    }
}