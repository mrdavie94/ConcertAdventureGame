package adventureGameAssignment;

public class GameTime {
    
    // 1. The private static instance (The only one that will ever exist)
    private static final GameTime instance = new GameTime();
    
    public String currentTime;

    // 2. A Private constructor prevents anyone else from making a new clock
    private GameTime() {
        currentTime = "8:00 PM";
    }

    // 3. This is a Public method to get the one single instance
    public static GameTime getInstance() {
        return instance;
    }

    /* * GENERAL COMMENTS:
     * This uses the Singleton pattern here for the Game Clock.
     * this is helpful because it avoids creating multiple 
     * clock objects that might get out of sync.
     * Since instance is static and final, it's loaded into memory only once,
     * which makes it easier to access getInstance().
     */
}