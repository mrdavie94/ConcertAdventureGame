package adventureGameAssignment;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * A demo using the five core Java Functional Interfaces
 * and tying it into my Adventure Game.
 * * @author David Lane
 * @version 1.0
 */
public class FunctionalConcertDemo {

    /**
     * The main method. It runs through the examples
     * of Supplier, Consumer, Predicate, Function, and UnaryOperator.
     * * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        
        System.out.println("--- WELCOME TO THE CONCERT ---");
        ConcertAttendee player = new ConcertAttendee("David", 100, 100.00);

        // 1. SUPPLIER -This takes NO arguments, and RETURNS a value.
        // 2.1 - Use of lambda expressions in at least five scenarios
        // 4.2 - Use of at least two of the built-in functional interfaces
        Supplier<String> moshPitLoot = () -> {
            String[] groundItems = {"a muddy shoe", "a broken pair of glasses", "an unopened energy drink", "a guitar pick"};
            int randomIndex = new Random().nextInt(groundItems.length);
            return groundItems[randomIndex];
        };
        System.out.println("\n[SUPPLIER]: You looked at the ground and found " + moshPitLoot.get() + ".");

        // 2. CONSUMER - This takes an argument, but RETURNS NOTHING.
        // Example: You drink an energy drink, changing your energy level but returning nothing.
        Consumer<ConcertAttendee> drinkEnergyDrink = (attendee) -> {
            attendee.setEnergyLevel(attendee.getEnergyLevel() + 50);
            System.out.println("\n[CONSUMER]: " + attendee.getName() + " chugged a caffeine beverage. Your energy level is: " + attendee.getEnergyLevel() + ".");
        };
        drinkEnergyDrink.accept(player);

        // 3. PREDICATE - This takes an argument, but RETURNS a boolean value
        // Example: Checking if the player has enough cash to buy a tour hoodie. The hoodie costs $60.
        Predicate<ConcertAttendee> canAffordHoodie = (attendee) -> attendee.getCash() >= 60.00;
        System.out.print("\n[PREDICATE]: Can " + player.getName() + " afford the $60 hoodie? ");
        if (canAffordHoodie.test(player)) {
            System.out.println("Yes!");
        } else {
            System.out.println("No, they only have $" + player.getCash() + ".");
        }

        // 4. FUNCTION - This takes an argument of type T, and RETURNS a result of type R
        // Example: Converts the player's energy level to a string.
        Function<Integer, String> getEnergyStatus = (energy) -> {
            if (energy > 80) return "Buzzing/Hyper";
            if (energy > 50) return "Rocking out normally";
            return "Crashing hard, needs sleep";
        };
        System.out.println("\n[FUNCTION]: Player's current status is: '" + getEnergyStatus.apply(player.getEnergyLevel()) + "'.");

        // 5. UNARY OPERATOR - This takes an argument of type T, and RETURNS the SAME type T
        // Example: The player enters the mosh pit, which cuts their energy level in half.
        // UnaryOperator is a function where the input and output is the same.
        UnaryOperator<Integer> moshPitFatigue = (energy) -> energy / 2;
        player.setEnergyLevel(moshPitFatigue.apply(player.getEnergyLevel()));
        System.out.println("\n[UNARY OPERATOR]: Player survived the mosh pit! Energy slashed to " + player.getEnergyLevel() + ".");
    }
}