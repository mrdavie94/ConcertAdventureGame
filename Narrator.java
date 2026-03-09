package adventureGameAssignment;

/**
 * Name: David Lane
 * Date: 03/05/2026
 * Assignment: Final Project - Concert Text Adventure 
 * Description: This is a singleton class all about the sarcastic internal monologue called the narrator.
 */
public class Narrator {

	// 1.5 - Proper use of the Static keyword
	// 2.3 - Use of the Singleton pattern
	// Single instance of the Narrator
	private static Narrator instance;
	
	// A private constructor that prevents anyone else from instantiating it
	private Narrator() {}
	
	/**
	 * Grabs the single instance of the Narrator.
	 * @return The single Narrator instance.
	 */
	public static Narrator getInstance() {
		if (instance == null) {
			instance = new Narrator();
		}
		return instance;
	}
	
	/**
	 * This outputs a sarcastic or observant type of message to the console.
	 * @param message The thought that will be printed.
	 */
	public void speak(String message) {
		System.out.println("\n[INTERNAL MONOLOGUE]: " + message);
	}
}
