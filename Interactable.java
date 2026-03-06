package adventureGameAssignment;

//1. The Interface
//This is all about the actions that can take place in my game.
public interface Interactable {
	
	// Method 1: Get the description of an object
	public String lookAt();
	
	// Method 2: Attempt to pick up the object
	public void pickUp();
	
	// Method 3: Check if the you are strong enough to lift the object
	public boolean isHeavy();
	
	// Method 4: Uses the object (will return a string)
	public String interact(String action);
}
