package methods;

public class ScriptMethods {

	// This method executes when user input is not on the menu. 
	public static void invalidOption() {
		System.out.println("You have not selected a valid option.");
		System.out.println("You will be exited out of the application.");
		System.out.println("Please re-run and follow the prompts as given.");
	}
	
	// Method to be used when input temp is below absolute zero. 
	public static void absoluteZero() {
		System.out.println("This input is below absolute zero.");
		System.out.println("This is in violation of the 3rd Law of Thermodynamics.");
		System.out.println("You will be exited out of the application.");
		System.out.println("Please re-run and follow the prompts as given.");
	}
	
	
	public static void printMenuOptions() {
		
		System.out.println("Enter [1] for Fahrenheit");
		System.out.println("Enter [2] for Celsius");
		System.out.println("Enter [3] for Kelvin");
		System.out.println("Enter [4] if you would like to exit.");
	}
	
	// Used when user opts to exit. 
	public static void seeYouLater() {
		System.out.println("You have chosen to exit. See you later.");
	}
	
	public static void thankYou() {
		System.out.println("Thank you for using UnitConverter. See you again soon.");
	}
	
}
