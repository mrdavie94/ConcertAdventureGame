package adventureGameAssignment;

//1. ENUMERATION EXAMPLE 
// Using an Enum is helpful for fixed items. 
enum ItemType {
 CONSUMABLE, // Like coffee or energy drinks
 KEY_ITEM,   // Like the concert ticket
 EQUIPMENT   // Like earplugs or better shoes
}

//2. ABSTRACT METHOD EXAMPLE 
// Abstract classes help with designing a template.
// An example is every item I make has a name and also a use
// A ticket has a much different use than coffee
abstract class GameItem {
 String name;
 ItemType type;

 public GameItem(String name, ItemType type) {
     this.name = name;
     this.type = type;
 }

 // Abstract method: Children have to use this.
 public abstract void use(); 
}

//Class extending the abstract class
class Coffee extends GameItem {
 
 public Coffee() {
     super("Cold Brew", ItemType.CONSUMABLE);
 }

 // 3. @OVERRIDE EXAMPLE
 // Here I am overriding the abstract method from the parent. 
 // This makes it so I can provide a more specific way to use Coffee.
 @Override
 public void use() {
     System.out.println("You drank the " + name + ". Great choice! Feeling it yet?.");
 }
}

//Class to show a Nested Class
class Backpack {
 
 // 4. NESTED CLASS EXAMPLE 
// A nested class is pretty useful here because a Pocket 
// doesn't make sense outside the context of a Backpack. It helps group logic.
 static class Pocket {
     int capacity;
     
     public Pocket(int capacity) {
         this.capacity = capacity;
     }
     
     void checkSpace() {
         System.out.println("This pocket has " + capacity + " items.");
     }
 }
}

//5. ADDITIONAL EXAMPLE - (Another @Override)
// Overriding toString() is pretty standard practice
// it helps make printing objects readable for the game text.
class Ticket extends GameItem {
 public Ticket() {
     super("Concert Ticket", ItemType.KEY_ITEM);
 }

 @Override
 public void use() {
     System.out.println("You show the ticket to the bouncer.");
 }

 // Extra Override
 @Override
 public String toString() {
     return "Item: " + name + " (Type: " + type + ")";
 }
}

//Main class just to run it and show it works
public class ConcertGameItems {
 public static void main(String[] args) {
     Coffee myCoffee = new Coffee();
     myCoffee.use();

     Backpack.Pocket frontPocket = new Backpack.Pocket(5);
     frontPocket.checkSpace();
     
     Ticket myTicket = new Ticket();
     System.out.println(myTicket.toString());
 }
}