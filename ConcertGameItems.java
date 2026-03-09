package adventureGameAssignment;

// 1.8 - Use of enumerations (enums)
enum ItemType {
 CONSUMABLE, 
 KEY_ITEM,   
 EQUIPMENT  
}

// 1.2 - Polymorphic class structure with use of parent classes and interfaces
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
//Item 1: Coffee
class Coffee extends GameItem {
 
 public Coffee() {
     super("Cold Brew Coffee", ItemType.CONSUMABLE);
 }

 // 1.9 - Proper use of @Override notation
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
     
     // 1.7 - Use of nested classes
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
//Item 2: Concert Ticket
class Ticket extends GameItem {
 public Ticket() {
     super("Concert Ticket", ItemType.KEY_ITEM);
 }

 @Override
 public void use() {
     System.out.println("You show the ticket to the bouncer.");
 }

 // 1.4a - Including override of .toString() in at least one scenario
 @Override
 public String toString() {
     return "Item: " + name + " (Type: " + type + ")";
 }
}

//Item 3: Earplugs
class Earplugs extends GameItem {
 public Earplugs() {
     super("Foam Earplugs", ItemType.EQUIPMENT);
 }

 @Override
 public void use() {
     System.out.println("You squish the foam earplugs and put them in. The world sounds comfortably muffled. Protect your hearing!");
 }
}

//Item 4: Guitar Pick
class GuitarPick extends GameItem {
 public GuitarPick() {
     super("Lucky Guitar Pick", ItemType.KEY_ITEM);
 }

 @Override
 public void use() {
     System.out.println("You flick your lucky guitar pick. It doesn't do much right now, but it makes you feel cool.");
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