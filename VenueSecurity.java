package adventureGameAssignment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VenueSecurity {

    // 1. LOGGING SETUP (15 Points)
    // Create a logger for the VenueSecurity class. It will write to my .txt file 'concert_logs.txt'
    private static final Logger logger = LogManager.getLogger(VenueSecurity.class);

    public String venueName = "The Metal Dome";
    private double registerCash = 5000.00;

    // Exception to show error handling
    public void processTicket(String ticketId) {
        // 2. EXCEPTION HANDLING (10 Points)
        // Here I used a try-catch block
        try {
            logger.info("Attempting to scan ticket: " + ticketId);
            
            if (ticketId == null || ticketId.isEmpty()) {
                throw new IllegalArgumentException("Ticket ID cannot be empty.");
            }
            
            if (ticketId.equals("FAKE-123")) {
                // Simulating a specific logic error
                throw new SecurityException("Counterfeit ticket detected!");
            }
            
            System.out.println("Ticket " + ticketId + " accepted.");
            logger.info("Ticket accepted successfully.");

        } catch (IllegalArgumentException e) {
            // This is for any empty input
            logger.error("Input Error: " + e.getMessage());
            System.out.println("Error: You must show a valid ticket.");
            
        } catch (SecurityException e) {
            // Security alert prompt
            logger.fatal("SECURITY ALERT: " + e.getMessage());
            System.out.println("SECURITY CALLED: " + e.getMessage());
            
        } finally {
            // This runs no matter what happens
            System.out.println("...Turnstile reset for next person...");
        }
    }

    public static void main(String[] args) {
        VenueSecurity vs = new VenueSecurity();
        
        // Test 1: Good ticket
        vs.processTicket("VALID-999");
        
        System.out.println("---");
        
        // Test 2: Bad ticket (Triggers Exception & Logging)
        vs.processTicket("FAKE-123");
    }
}