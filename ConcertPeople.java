package adventureGameAssignment;

// Abstract parent class
abstract class Person {
    String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    // Abstract method: Every person has a different role
    public abstract void performRole();
}

// This is an interface for the staff members
interface RadioUser {
    void speakIntoRadio(String message);
}

// Concreate Class - The MetalFan
// Relationship: MetalFan IS-A Person
class MetalFan extends Person {
    
    boolean hasBackstagePass;

    public MetalFan(String name, boolean hasPass) {
        super(name);
        this.hasBackstagePass = hasPass;
    }

    @Override
    public void performRole() {
        System.out.println(name + " is screaming the lyrics!");
    }
}

// Concreate class number 2: The SecurityGuard
// Relationship: SecurityGuard IS-A Person, and IMPLEMENTS RadioUser
class SecurityGuard extends Person implements RadioUser {
    
    String station; // This is the front gate of the venue

    public SecurityGuard(String name, String station) {
        super(name);
        this.station = station;
    }

    @Override
    public void performRole() {
        System.out.println(name + " is watching the crowd at the " + station);
    }

    @Override
    public void speakIntoRadio(String message) {
        System.out.println(name + " says to radio: " + message);
    }
}

// Main class to run/test
public class ConcertPeople {
    public static void main(String[] args) {
        MetalFan player = new MetalFan("Alex", true);
        SecurityGuard guard = new SecurityGuard("Big Mike", "Stage Left");
        
        player.performRole();
        guard.speakIntoRadio("We have a crowd surfer.");
    }
}