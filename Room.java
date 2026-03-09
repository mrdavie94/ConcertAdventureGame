package adventureGameAssignment;

import java.util.ArrayList;
import java.util.List;

/**
 * Name: David Lane
 * Date: 03/05/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: This shows the different locations in the game and the actions you are able to do.
 * // Chapter 3 - Generics: Use of an Array List
 * // Use of private properties, getters/setters
 */
public class Room {
    
    // 1.1 - Proper use of visibility modifiers 
	// Additional Req 3.a - All properties should be privates
    private String name;
    private String description;
    private List<String> availableCommands; // The Array List that shows the commands a player can choose
 // Additional Req 3.e - Correct use of Camel Casing
    private boolean isLocked;

    /**
     * Constructor for the Room.
     * @param name The name of the room.
     * @param description What the narrator says when you enter.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.availableCommands = new ArrayList<>();
        
        // Help or quit commands that are in every room
        this.availableCommands.add("help (Shows these options again)");
        this.availableCommands.add("quit (Exits the game)");
    }

    /**
     * Adds in commands that work with the current room a player is in.
     * @param command The command to add (e.g., "look poster").
     */
    public void addCommand(String command) {
        this.availableCommands.add(command);
    }

    /**
     * Prints the list of commands the player can type.
     */
    public void showOptions() {
        System.out.println("\n--- AVAILABLE ACTIONS ---");
        
        // 3.5 - Valid example of a foreach statement
        for (String cmd : availableCommands) {
            System.out.println("> " + cmd);
        }
        System.out.println("-------------------------");
    }

    // ---  Getters and Setters ---
    // 2.2 - Valid example of encapsulation
    // Additional Req 3.b - Getter for non-boolean properties begins with a get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
 // Additional Req 3.c - Getters for Boolean properties begins with Is or Get
    public boolean isLocked() {
        return isLocked;
    }

    // Additional Req 3.d - Setter methods begin with set
    public void setLocked(boolean locked) {
        this.isLocked = locked;
    }
}