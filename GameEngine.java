package adventureGameAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Additional Req 2 - Appropriate use of JavaDoc comments
/**
 * Name: David
 * Date: 03/05/2026
 * Assignment: Final Project - Concert Text Adventure
 * Description: The main game loop that processes user input and drives the game.
 * // Chapter 8 - IO: Demos of reading/writing data from the console
 */
public class GameEngine {

    public static void main(String[] args) {
        
    	// 8.1 - Demonstration of reading/writing data from the console
        Scanner scanner = new Scanner(System.in);
        Narrator brain = Narrator.getInstance();
        ConcertPoster poster = new ConcertPoster();
        System.out.println("\n[SYSTEM BOOT]");
        PlayerDatabase dbManager = new PlayerDatabase();
        dbManager.setupDatabase(); 
        GameTime schedule = new GameTime("9:00 PM", "7:30 PM");
        System.out.println("[INFO]: Doors open at " + schedule.getDoorsOpenTime() + ". Show starts exactly at " + schedule.getConcertStartTime() + ".");
        ConcertCalendar calendar = new ConcertCalendar();
        calendar.calculateDaysUntilConcert();
        TimeConsole.displayMessage(java.time.LocalTime.now(), java.util.Locale.getDefault());
        System.out.println("---------------------------------\n");
      
        boolean playAgain = true;
        
        while (playAgain) {
        	// 3.2 - Use of an Array List
        	List<GameItem> inventory = new ArrayList<>();
        	Ticket concertTicket = new Ticket(); 
        	Earplugs earplugs = new Earplugs();
            GuitarPick pick = new GuitarPick();
            Coffee coldBrew = new Coffee();
            boolean alarmSet = false;
            boolean bumpedProducer = false;
            boolean isNextDay = false; 
            boolean ticketShown = false;
            boolean isRunning = true;
            
            System.out.println("\n=================================");
            System.out.println("=== METAL CONCERT ADVENTURE ===");
            System.out.println("=================================");
            brain.speak("It's 2 AM the night before the concert. You are dangerously over-caffeinated. You keep staring at the poster for that metal band. You don't actually know who they are, but the logo looks like a pile of sticks, so they must be heavy.");
            
            // 1. The Bedroom
            Room bedroom = new Room("Bedroom", "Your room is a mess. There's a pencil on the desk, an alarm clock, and that intense band poster.");
            bedroom.addCommand("check pencil");
            bedroom.addCommand("set alarm");
            bedroom.addCommand("take ticket");
            bedroom.addCommand("sleep");
            bedroom.addCommand("look poster");
            bedroom.addCommand("go kitchen");
            bedroom.addCommand("save game");
            bedroom.addCommand("load game");
            bedroom.addCommand("delete save");
            bedroom.addCommand("inventory");

            // 2. The Kitchen
            Room kitchen = new Room("Kitchen", "Your cold brew maker and your lovely Ninja Foodi take up most of the counter. Ziggy your black cat is meowing waiting for food, and of course staring at you judgmentally.");
            kitchen.addCommand("make pbj (Because you need fuel)");
            kitchen.addCommand("pet ziggy");
            kitchen.addCommand("take coffee");
            kitchen.addCommand("go bedroom");
            kitchen.addCommand("go garage");
            kitchen.addCommand("go bus stop");
            kitchen.addCommand("save game");
            kitchen.addCommand("load game");
            kitchen.addCommand("delete save");
            kitchen.addCommand("inventory");
            
            // 3. The Garage
            Room garage = new Room("Garage", "It smells like motor oil and unfulfilled potential. Your adjustable dumbbells and bench sit in the corner. An old electric guitar rests against a blown-out amp.");
            garage.addCommand("play guitar");
            garage.addCommand("lift weights");
            garage.addCommand("take earplugs");
            garage.addCommand("take pick");
            garage.addCommand("go kitchen");
            garage.addCommand("save game");
            garage.addCommand("load game");
            garage.addCommand("delete save");
            garage.addCommand("inventory");

            // 4. The Bus Stop
            Room busStop = new Room("Bus Stop", "A rusty bench under a flickering streetlamp. The bus to the venue should be here soon.");
            busStop.addCommand("wait for bus");
            busStop.addCommand("bump stranger"); 
            busStop.addCommand("go kitchen");
            busStop.addCommand("save game");
            busStop.addCommand("load game");
            busStop.addCommand("delete save");
            busStop.addCommand("inventory");

            // 5. The Concert Venue
            Room venue = new Room("Concert Venue", "The Metal Dome. It's loud, crowded, and smells like stale beer. A massive security guard blocks the entrance.");
            venue.addCommand("show ticket");
            venue.addCommand("enter mosh pit");
            venue.addCommand("save game");
            venue.addCommand("load game");
            venue.addCommand("delete save");
            venue.addCommand("inventory");

            // Set the starting location and print the first description
            Room currentRoom = bedroom;
            System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
            currentRoom.showOptions();
            
            // The core game loop
            while (isRunning) {
                System.out.print("\nWhat do you do? > ");
                String input = scanner.nextLine().trim().toLowerCase();
                
                String[] words = input.split(" ");
                String command = words[0];
                String target = (words.length > 1) ? words[1] : "";

                switch (command) {
                
                
                case "take":
                    if (target.equals("ticket") && currentRoom == bedroom) {
                        if (!inventory.contains(concertTicket)) {
                            inventory.add(concertTicket);
                            brain.speak("You grab the ticket and shove it in your pocket. Try not to wash it with your pants this time.");
                        } else {
                            brain.speak("You already have the ticket.");
                        }
                    } else if (target.equals("earplugs") && currentRoom == garage) {
                        if (!inventory.contains(earplugs)) {
                            inventory.add(earplugs);
                            brain.speak("You grab the neon orange earplugs off the workbench.");
                        } else {
                            brain.speak("You already took the earplugs.");
                        }
                    } else if (target.equals("pick") && currentRoom == garage) {
                        if (!inventory.contains(pick)) {
                            inventory.add(pick);
                            brain.speak("You pocket your lucky guitar pick. What did I name it again? The Pick of Destiny.");
                        } else {
                            brain.speak("You already have the pick.");
                        }
                    } else if (target.equals("coffee") && currentRoom == kitchen) {
                        if (!inventory.contains(coldBrew)) {
                            inventory.add(coldBrew);
                            brain.speak("You pour some aggressively strong cold brew into a travel mug. Liquid anxiety secured.");
                        } else {
                            brain.speak("You already grabbed the coffee. Your heart can only take so much.");
                        }
                    } else {
                        brain.speak("You can't take that.");
                    }
                    break;
                
                case "inventory":
                case "i":
                    brain.speak("Taking stock of your worldly possessions, are we?");
                    // Calls the Generic Wildcard method at the bottom of the class
                    displayInventory(inventory);
                    break;
                	

                case "show":
                    if (target.equals("ticket") && currentRoom == venue) {
                        
                    	// 4.1 - Use of a variable in lambda expression (uses 'target' from outer scope)
                    	// 4.4 - Use of the optional type
                    	// 4.5 - Use of the stream pipeline
                        java.util.Optional<GameItem> foundTicket = inventory.stream()
                                .filter(item -> item instanceof Ticket)
                                .findFirst();

                        if (foundTicket.isPresent()) {
                            // Uses overridden toString() and use() methods
                            foundTicket.get().use(); 
                            
                            // Triggering VenueSecurity Exception Handling
                            VenueSecurity bouncer = new VenueSecurity();
                            bouncer.processTicket("VALID-999"); 
                            
                            // Uses custom functional interface (RadioUser)
                            RadioUser bouncerRadio = message -> System.out.println("[RADIO STATIC]: " + message);
                            bouncerRadio.speakIntoRadio("Gate clear. Let 'em in.");
                            
                            ticketShown = true; 
                            
                        } else {
                            brain.speak("You pat your pockets. Empty. You left the ticket in your bedroom. GAME OVER.");
                            isRunning = false;
                        }
                    } else {
                        brain.speak("Who are you showing that to?");
                    }
                    break;
                    
               
                case "use":
                case "drink": // Typing "drink coffee" does the exact same thing as "use coffee"
                    boolean itemFound = false;
                    for (GameItem item : inventory) {
                        if (item.name.toLowerCase().contains(target)) {
                            item.use(); // Calls the specific override method!
                            itemFound = true;
                            break;
                        }
                    }

                    if (!itemFound) {
                        brain.speak("You don't have anything like that to use.");
                    }
                    break;
                    
                  
                case "enter":
                    if ((target.equals("mosh") || target.equals("pit")) && currentRoom == venue) {
                        if (ticketShown) {
                            // Checks which ending is earned based on the bus stop!
                            if (bumpedProducer) {
                                // Option B: The Secret Ending
                                System.out.println("\n*** SECRET ENDING UNLOCKED ***");
                                brain.speak("You push through the doors. The band is... okay. But suddenly, you see that guy you bumped into at the bus stop. He's wearing a suit, taking furious notes. He looks at you, nods, and points at the stage. Turns out, he's a massive record producer. Because you bumped into him, he missed his earlier flight, ended up at this dive bar, and just signed the band to a record deal. You literally changed music history by being clumsy. YOU WIN.");
                            } else {
                                // Option A: The True Ending
                                System.out.println("\n*** TRUE ENDING ***");
                                brain.speak("You push through the doors, ready for a stadium-filling metal experience. ...There are exactly 10 people here. One of them is the janitor. The band is playing on a stage the size of a ping-pong table. But you know what? You don't care. In your head, the pyrotechnics are blinding. You throw up the metal horns and have the absolute best night of your life. YOU WIN.");
                            }
            
                            ConcertAttendee player = new ConcertAttendee("David", 100, 50.00);
                            java.util.function.UnaryOperator<Integer> moshPitFatigue = (energy) -> energy / 2;
                            player.setEnergyLevel(moshPitFatigue.apply(player.getEnergyLevel()));
                            brain.speak("You survived the pit! But your energy is slashed to " + player.getEnergyLevel() + ".");

                           
                            System.out.println("\n=================================");
                            System.out.println("=== POST-SHOW RECAP & MERCH ===");
                            System.out.println("=================================");
                            
                            // This calls the Collections demo (triggering Song.java and SongDurationComparator.java)
                            ConcertCollectionsDemo.main(new String[0]);
                            
                            System.out.println("\n--- NIGHT HIGHLIGHTS ---");
                            // This calls the Functional demo
                            FunctionalConcertDemo.main(new String[0]);
                            isRunning = false; // Ends the game victoriously!
                        } else {
                            brain.speak("You need to get past the bouncer first. Try showing your ticket.");
                        }
                    } else {
                        brain.speak("You can't enter that.");
                    }
                    break;
                    
                case "help":
                    currentRoom.showOptions();
                    break;

                case "check":
                    if (target.equals("pencil") && currentRoom == bedroom) {
                        brain.speak("Wow! It's a yellow stick of graphite. Could pretend it's a drumstick I suppose.");
                    } else {
                        brain.speak("There's nothing to check like that here.");
                    }
                    break;

                case "set":
                    if (target.equals("alarm") && currentRoom == bedroom) {
                        alarmSet = true;
                        brain.speak("You set the alarm for 9:00 AM. A rare moment of responsibility.");
                    } else {
                        brain.speak("You can't set that here.");
                    }
                    break;

                case "sleep":
                    
                	// 6.5 - Use of assertions
                    // This is a safety check to so this code only runs in the bedroom
                    assert currentRoom == bedroom : "Player tried to sleep outside the bedroom!";

                    if (currentRoom == bedroom && !isNextDay) {
                        // 6.1 - Proper use of Try-Catch blocks
                        try {
                            if (!alarmSet) {
                                // 6.3 - Use and creation of a custom exception
                                throw new MissedBusException("You didn't set your alarm!");
                            } else {
                                isNextDay = true;
                                brain.speak("You finally crash... BEEP BEEP BEEP! You wake up. You feel surprisingly okay for once.");
                                bedroom.setDescription("Morning light fills the room. It's concert day.");
                            }
                        } catch (MissedBusException e) {
                            // 6.2 - Use of catch clause
                            brain.speak(e.getMessage() + " You wake up to the sun setting. It's 7:00 PM. You missed the bus. You missed the concert. Your life is a tragedy. GAME OVER.");
                            isRunning = false; 
                        } finally {
                            // 6.2 - Use of finally clause
                            System.out.println("\n[SYSTEM]: Wakey wakey. Another day is here!");
                        }
                    } else if (isNextDay) {
                        brain.speak("You can't sleep now, you have a concert to get to!");
                    } else {
                        brain.speak("You can't sleep here. That would be weird.");
                    }
                    break;

                case "bump":
                    if ((target.equals("stranger") || target.equals("man")) && currentRoom == busStop) {
                        bumpedProducer = true;
                        brain.speak("In your rush, you ram right into a guy in a suit. He brushes himself off. 'In a hurry to see that metal show?' he asks. He looks intrigued and starts walking toward the venue too.");
                    } else {
                        brain.speak("Stop trying to bump into inanimate objects.");
                    }
                    break;

                case "go":
                    if (target.equals("kitchen")) {
                        if (!isNextDay && currentRoom == bedroom) {
                            brain.speak("It's 2 AM. You need to sleep before wandering around the house. Set your alarm and go to bed!");
                        } else if (currentRoom == bedroom || currentRoom == garage || currentRoom == busStop) {
                            currentRoom = kitchen;
                            
                            // Descriptions of rooms
                            System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
                            brain.speak("You walk into the kitchen. The hum of the refrigerator greets you. Is it peanut butter jelly time?");
                            currentRoom.showOptions();
                        } else if (currentRoom == kitchen) {
                            brain.speak("You are already in the kitchen. The caffeine hasn't kicked in yet, has it?");
                        } else {
                            brain.speak("You can't get to the kitchen from here.");
                        }
                    } 
                    else if (target.equals("bedroom")) {
                        if (currentRoom == kitchen) {
                            currentRoom = bedroom;
                            System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
                            brain.speak("You head back into your messy bedroom.");
                            currentRoom.showOptions();
                        } else {
                            brain.speak("You have to go through the kitchen to get to the bedroom.");
                        }
                    } 
                    else if (target.equals("garage")) {
                        if (currentRoom == kitchen) {
                            currentRoom = garage;
                            System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
                            brain.speak("You step out into the garage. It's chilly, and the concrete is rough on your feet.");
                            currentRoom.showOptions();
                        } else {
                            brain.speak("The door to the garage is in the kitchen.");
                        }
                    } 
                    else if (target.equals("bus") || target.equals("stop")) {
                        if (currentRoom == kitchen) {
                            currentRoom = busStop;
                            System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
                            brain.speak("You grab your things, step outside into the air, and walk down to the bus stop.");
                            currentRoom.showOptions();
                        } else {
                            brain.speak("You need to exit through the kitchen to get to the street.");
                        }
                    } 
                    else {
                        brain.speak("Go where? You need to specify a valid room. Try looking at your options again.");
                    }
                    break;
                
                case "wait":
                    if (currentRoom == busStop) {
                        brain.speak("You wait. And wait. Finally, a rusted city bus screeches to a halt. You climb aboard, pay the fare, and ride all the way across town to the Metal Dome.");
                        currentRoom = venue; 
                        System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
                        currentRoom.showOptions();
                    } else {
                        brain.speak("You stand around waiting for something to happen. Nothing does. Time is ticking.");
                    }
                    break;
                    
                case "play":
                    if (target.equals("guitar") && currentRoom == garage) {
                        brain.speak("You plug in and hit an absolutely ungodly, out-of-tune power chord. The neighbor's dog starts howling. Your parents yell from upstairs to turn it down. You are a rock god.");
                    } else {
                        brain.speak("You can't play that right now. Who says you can't air guitar though!?");
                    }
                    break;

                case "lift":
                    if (target.equals("weights") && currentRoom == garage) {
                        brain.speak("You adjust the dumbbells to 52 lbs and try to curl them. You immediately regret this. Your stiff neck throbs. Stick to software development.");
                    } else {
                        brain.speak("Do you even lift? Not here, you don't.");
                    }
                    break;

                case "pet":
                    if (target.equals("ziggy") && currentRoom == kitchen) {
                        brain.speak("You reach out to pet Ziggy. He gives a loving head boop. Classic.");
                    } else {
                        brain.speak("Ziggy is at home. Please don't pet any people. That's no bueno.");
                    }
                    break;

                case "make":
                    if (target.equals("pbj") && currentRoom == kitchen) {
                        brain.speak("You assemble a masterpiece of peanut butter and jelly. Equal parts jelly and peanut butter. It is your third out of body experience this week. Energy restored.");
                    } else {
                        brain.speak("You don't have the ingredients for that here. Bummer. Could always go for another pb and j right?");
                    }
                    break;
                    
                case "look":
                    if (target.equals("poster") && currentRoom == bedroom) {
                        brain.speak(poster.lookAt());
                    } else {
                        brain.speak("Look at what? The crushing void of your responsibilities? Try checking your options.");
                    }
                    break;
                     
                case "save":
                    // Package the current variables into our Serializable object
                    SaveState currentState = new SaveState(alarmSet, bumpedProducer, isNextDay, currentRoom.getName());
                    // Call the manager to write the file
                    SaveManager.saveGame(currentState);
                    brain.speak("You pause to sear this moment into your memory. Progress saved.");
                    break;
                    
                case "load":
                    if (target.equals("save") || target.equals("game")) {
                        SaveState loadedState = SaveManager.loadGame();
                        
                        if (loadedState != null) {
                            // Restore the primitive variables
                            alarmSet = loadedState.alarmSet;
                            bumpedProducer = loadedState.bumpedProducer;
                            isNextDay = loadedState.isNextDay;
                            
                            // Restore the correct room based on the saved string
                            switch (loadedState.currentRoomName) {
                                case "Bedroom": currentRoom = bedroom; break;
                                case "Kitchen": currentRoom = kitchen; break;
                                case "Garage": currentRoom = garage; break;
                                case "Bus Stop": currentRoom = busStop; break;
                                case "Concert Venue": currentRoom = venue; break;
                                default: currentRoom = bedroom; break;
                            }
                            
                            brain.speak("Suddenly, your memories realign. You are back exactly where you left off.");
                            System.out.println("\n[" + currentRoom.getName().toUpperCase() + "]: " + currentRoom.getDescription());
                            currentRoom.showOptions();
                        } else {
                            brain.speak("You try to remember a past life, but there's nothing there. Are you sure you saved?");
                        }
                    } else {
                        brain.speak("Load what? Try 'load game' or 'load save'.");
                    }
                    break;

                case "delete":
                    if (target.equals("save")) {
                        SaveManager.deleteSaveFile();
                        brain.speak("You wipe your memory completely clean. The save file is gone.");
                    } else {
                        brain.speak("Delete what? You can only 'delete save'.");
                    }
                    break;

                case "quit":
                case "exit":
                    brain.speak("Giving up already? Fine. Game over.");
                    isRunning = false; // Breaks the inner loop
                    break;
                    
                default:
                    brain.speak("I don't know what '" + input + "' means. Are we making up words now?");
                    break;
                }
            } // End of inner 'isRunning' loop
            
            // Prompt to restart the game
            System.out.print("\nWould you like to play again? (yes/no) > ");
            String restartInput = scanner.nextLine().trim().toLowerCase();
            
            if (!restartInput.equals("yes") && !restartInput.equals("y")) {
                playAgain = false;
                brain.speak("Shutting down the simulation. See you at the next show.");
            }
            
        } // End of outer 'playAgain' loop
        
        scanner.close(); // Only close the scanner when they are completely done
    }
    
    /**
     * CH 3 - Generics: Use of an Upper-bounded wildcard.
     * Prints any list of GameItems (or its children like Ticket, Coffee).
     */
    // 3.1.a - Use of an Upper-bounded wildcard when using the generic class
    public static void displayInventory(List<? extends GameItem> items) {
        System.out.println("\n--- POCKET CONTENTS ---");
        if (items.isEmpty()) {
            System.out.println("Your pockets are empty.");
        } else {
            for (GameItem item : items) {
                System.out.println("- " + item.name); // Accesses the name from the abstract class
            }
        }
        System.out.println("-----------------------");
    }
}