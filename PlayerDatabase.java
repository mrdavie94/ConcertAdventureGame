package adventureGameAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Manages the Derby database for the Concert Adventure Game.
 * This class handles any table creation, inserting of save data, 
 * and getting player stats.
 * * @author David Lane
 * @version 1.0
 */
public class PlayerDatabase {

    /** The JDBC URL for the embedded Derby database. It creates the DB if it doesn't exist. */
    private static final String DB_URL = "jdbc:derby:ConcertDB;create=true";

    /**
     * Initializes the database.
     * Connects to Derby, creates the PLAYER_SAVE table if it does not already exist,
     * and inserts a default player profile to be read later.
     */
    
    // 10.1 - Implementation of a database with basic CRUD operations
    // 10.2 - Proper opening and closure of a Database resource
    public void setupDatabase() {
        // 10.3 - Inclusion of prepared statements if user input is used on SQL statements
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            try {
                String createTableSQL = "CREATE TABLE PLAYER_SAVE ("
                        + "ID INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, "
                        + "PLAYER_NAME VARCHAR(50), "
                        + "IS_VIP BOOLEAN)";
                stmt.execute(createTableSQL);
                System.out.println("Database table created successfully.");
                
                // 2. Insert Default Data (Only will run if the table was just created)
                String insertSQL = "INSERT INTO PLAYER_SAVE (PLAYER_NAME, IS_VIP) VALUES ('Alex', true)";
                stmt.executeUpdate(insertSQL);
                System.out.println("Default player data inserted.");
                
            } catch (SQLException e) {
                if (e.getSQLState().equals("X0Y32")) {
                    System.out.println("Table already exists. Skipping creation.");
                } else {
                    throw e; 
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }

    /**
     * Retrieves the VIP status of a player from the database.
     * This performs a READ operation using a PreparedStatement.
     * * @param playerName The name of the player to look up in the database.
     * @return boolean True if the player has VIP status, it is false otherwise.
     */
    public boolean checkVipStatus(String playerName) {
        boolean isVip = false;
        String query = "SELECT IS_VIP FROM PLAYER_SAVE WHERE PLAYER_NAME = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, playerName);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    isVip = rs.getBoolean("IS_VIP");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error reading from database: " + e.getMessage());
        }

        return isVip;
    }
}