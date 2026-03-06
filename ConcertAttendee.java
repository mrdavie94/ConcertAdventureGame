package adventureGameAssignment;

/**
 * This represents a player or attendee at the metal concert.
 * This class is used to demo functional interfaces.
 * * @author David Lane
 * @version 1.0
 */
public class ConcertAttendee {
    
    private String name;
    private int energyLevel;
    private double cash;

    /**
     * Constructor to create a new ConcertAttendee.
     * * @param name The name of the attendee.
     * @param energyLevel The starting energy level (0-100).
     * @param cash The amount of money they brought to the merch booth.
     */
    public ConcertAttendee(String name, int energyLevel, double cash) {
        this.name = name;
        this.energyLevel = energyLevel;
        this.cash = cash;
    }

    /**
     * Gets the name of the attendee.
     * @return String used to show the attendee's name.
     */
    public String getName() { return name; }

    /**
     * Gets the current energy level.
     * @return int this represents the energy level for the attendee.
     */
    public int getEnergyLevel() { return energyLevel; }

    /**
     * Sets the new energy level for the attendee.
     * @param energyLevel The new energy value.
     */
    public void setEnergyLevel(int energyLevel) { this.energyLevel = energyLevel; }

    /**
     * Gets the amount of cash the attendee has.
     * @return double representing available cash.
     */
    public double getCash() { return cash; }
}