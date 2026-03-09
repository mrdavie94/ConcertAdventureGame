package adventureGameAssignment;

/**
 * This is to test the Derby database.
 * This class initializes the database, reads a value, and uses that 
 * value to instantiate an object from our game.
 * * @author David Lane
 * @version 1.0
 */
public class GameDatabaseLauncher {

    /**
     * The main method.
     * * @param args Command line arguments.
     */
    public static void main(String[] args) {
        System.out.println("--- Booting Concert Adventure Game ---");

        // 1. Initialize the Database Manager
        PlayerDatabase dbManager = new PlayerDatabase();
        
        // 2. Setup the DB and load the default data
        dbManager.setupDatabase();

        // 3. Read the value from the database
        String myName = "David";
        boolean databaseVipStatus = dbManager.checkVipStatus(myName);
        
        System.out.println("Fetched VIP Status for " + myName + " from Database: " + databaseVipStatus);

        // 4. Use the retrieved value
        System.out.println("\n--- Spawning Player Object ---");
        
        // The existing MetalFan that I created from a previous assignment
        MetalFan player = new MetalFan(myName, databaseVipStatus);
        
        player.performRole();
        
        if (player.hasBackstagePass) {
            System.out.println("The bouncer checks his list... You are allowed backstage!");
        } else {
            System.out.println("The bouncer stops you. General admission only... Better luck next time champ!");
        }
    }
}