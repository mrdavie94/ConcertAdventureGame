package adventureGameAssignment;

import java.io.*;
import java.nio.file.*;

/**
 * Name: David
 * Date: 03/08/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: Manages serialization and File IO for saving the game.
 * // Chapter 8 - IO: Demonstration of the FileWriter class
 * // Chapter 9 - NIO: Creation and deletion of a file stored locally
 */
public class SaveManager {

	
	// 1.6 - Proper use of the final keyword
	
    private static final String SAVE_FILE = "concert_save.dat";
    private static final String LOG_FILE = "save_log.txt";

    /**
     * Serializes the SaveState object to a local file.
     * @param state The current progress of the player.
     */
    
    public static void saveGame(SaveState state) {
    	
        // 6.4 - Proper disposal of resources (try-with resources block)
    	// 8.2 - Demonstration of the FileWriter class
    	// 9.1 - Manipulation of an existing file on local machine (appending to log)
    	
        try (FileOutputStream fos = new FileOutputStream(SAVE_FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileWriter logWriter = new FileWriter(LOG_FILE, true)) { // Appends to log
            
            // Serialize the object
            oos.writeObject(state);
            System.out.println("[SYSTEM]: Game state serialized and saved to " + SAVE_FILE);
            
            // Write a plain text log using FileWriter (Chapter 8 requirement)
            logWriter.write("Player saved game while in room: " + state.currentRoomName + "\n");
            
        } catch (IOException e) {
            System.out.println("[ERROR]: Could not save game. " + e.getMessage());
        }
    }

    /**
     * Deletes the serialized save file.
     * // Chapter 9 requirement: Deletion of a locally stored file
     */
    
    public static void deleteSaveFile() {
        try {
            Path filePath = Paths.get(SAVE_FILE);
            
            // 9.2 - Creation and deletion of a file stored locally 
            
            if (Files.deleteIfExists(filePath)) {
                System.out.println("[SYSTEM]: Save file successfully deleted.");
            } else {
                System.out.println("[SYSTEM]: No save file found to delete.");
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Could not delete file. " + e.getMessage());
        }
    }
    
    /**
     * Deserializes the SaveState object from the local file.
     * @return The saved state, or null if loading fails.
     */
    public static SaveState loadGame() {
        // Chapter 8 - IO: Demonstration of reading from a file via streams
        try (FileInputStream fis = new FileInputStream(SAVE_FILE);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            SaveState state = (SaveState) ois.readObject();
            System.out.println("[SYSTEM]: Game state loaded successfully.");
            return state;

        } catch (FileNotFoundException e) {
            System.out.println("[SYSTEM]: No save file found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[ERROR]: Could not load game. " + e.getMessage());
        }
        return null;
    }
}