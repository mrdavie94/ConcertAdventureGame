package adventureGameAssignment;

// 2. This is an example of how I could use my Interactable class
public class ConcertPoster implements Interactable {
	
	// Example of a band name... still a work in progress on a final name.
	private String bandName = "Skull Crusher";
	
	// Example of my lookAt method.
	@Override
	public String lookAt() {
		return "A ripped poster of " + bandName + ". It looks intense.";
	}
	
	// Example of pickUp method with a slight jab from the narrator. 
	@Override
	public void pickUp() {
		System.out.println("You carefully peel the poster off the wall. Wow, I thought for sure you'd rip it!");
	}
	
	// Example of my isHeavy method
	@Override
	public boolean isHeavy() {
		// Posters are not heavy so this would return false
		return false;
	}
	
	@Override
	public String interact(String action) {
		if (action.equalsIgnoreCase("tear")) {
			return "Did you... did you really just tear the poster! Why would you do that?";
		}
		return "You touch the poster. Nothing happens... Who would have thought?";
	}

}
