package adventureGameAssignment;

/**
 * Name: David
 * Date: 03/08/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: An immutable object representing the concert's fixed schedule.
 * // Chapter 2 - Design Patterns: Use of the Immutable Object pattern
 */
// RULE 1: The class must be 'final' so it cannot be extended by subclasses
// 2.4 - Use of the Immutable Object pattern
public final class GameTime {
    
    // RULE 2: All fields must be 'private' and 'final'
    private final String concertStartTime;
    private final String doorsOpenTime;

    // RULE 3: Variables are set exactly once via the constructor
    public GameTime(String concertStartTime, String doorsOpenTime) {
        this.concertStartTime = concertStartTime;
        this.doorsOpenTime = doorsOpenTime;
    }

    // RULE 4: Only getters are provided. Absolutely no setter methods!
    public String getConcertStartTime() {
        return concertStartTime;
    }

    public String getDoorsOpenTime() {
        return doorsOpenTime;
    }
}