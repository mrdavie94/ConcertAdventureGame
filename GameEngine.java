package adventureGameAssignment;

import java.util.Scanner;

/**
 * Name: David
 * Date: 03/05/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: This is all about the main game loop that goes through all user input and drives the game.
 * // Chapter 8 - IO: Demons of reading/writing data from the console
 */
public class GameEngine {

    public static void main(String[] args) {
        // Initialize our tools
        Scanner scanner = new Scanner(System.in);
        Narrator brain = Narrator.getInstance();
        
        // Instantiate some of the items you already built!
        Coffee coldBrew = new Coffee();
        ConcertPoster poster = new ConcertPoster();
        
        boolean isRunning = true;
        
        System.out.println("=== METAL CONCERT ADVENTURE ===");
        brain.speak("You're awake. Barely. The metal concert is tonight, but right now, you're just standing in your bedroom.");
        
        // The core game loop
        while (isRunning) {
            System.out.print("\nWhat do you do? > ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            // Parse the command into words (e.g., "look poster" -> ["look", "poster"])
            String[] words = input.split(" ");
            String command = words[0];
            String target = (words.length > 1) ? words[1] : "";

            // Handle the commands using a Switch statement
            switch (command) {
                case "look":
                    if (target.equals("poster")) {
                        // Using your existing ConcertPoster logic!
                        brain.speak(poster.lookAt());
                    } else {
                        brain.speak("Look at what? The crushing void of your responsibilities? Try 'look poster'.");
                    }
                    break;
                
                case "drink":
                    if (target.equals("coffee") || target.equals("brew")) {
                        // Using your existing Coffee logic!
                        coldBrew.use();
                        brain.speak("Caffeine acquired. Your heart rate is now a blast beat.");
                    } else {
                        brain.speak("You can't drink that. Or maybe you can, but I wouldn't recommend it.");
                    }
                    break;

                case "quit":
                case "exit":
                    brain.speak("Giving up already? Fine. Game over.");
                    isRunning = false;
                    break;
                    
                default:
                    brain.speak("I don't know what '" + input + "' means. Are we making up words now?");
                    break;
            }
        }
        
        // Proper disposal of resources
        scanner.close();
    }
}