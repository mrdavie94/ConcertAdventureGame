package adventureGameAssignment;

import java.io.Serializable;

/**
 * Name: David
 * Date: 03/08/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: An object that holds the player's current progress to be serialized.
 */
public class SaveState implements Serializable {
    
    // Required for Serializable classes to verify version compatibility
    private static final long serialVersionUID = 1L;
    
    public boolean alarmSet;
    public boolean bumpedProducer;
    public boolean isNextDay;
    public String currentRoomName;

    // Constructor to quickly package the variables
    public SaveState(boolean alarmSet, boolean bumpedProducer, boolean isNextDay, String currentRoomName) {
        this.alarmSet = alarmSet;
        this.bumpedProducer = bumpedProducer;
        this.isNextDay = isNextDay;
        this.currentRoomName = currentRoomName;
    }
}