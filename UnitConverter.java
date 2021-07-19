package main;
import java.util.Scanner;

public class Converter {
 
	static Scanner scanner = new Scanner(System.in);
	
	/*
	 * Conversion methods
	 */
	
	public static double fahrenheitToCelsius(double f) {
		double c = (f - 32) / 1.8;
		return c;
	}
	
	public static double fahrenheitToKelvin(double f) {
		double c = (f - 32) / 1.8;
		double k = (c + 273.15);
		return k;
	}
	
	public static double celsiusToFahrenheit(double c) {
		double f = (c * 1.8) + 32;
		return f;
	}
	
	public static double celsiusToKelvin(double c) {
		double k = c + 273.15;
		return k;
	}
	
	public static double kelvinToFarenheit(double k) {
		double c = k - 273.15;
		double f = celsiusToFahrenheit(c);
		return f;
	}
	
	public static double kelvinToCelsius(double k) {
		double c = k - 273.15;
		return c;
	}
	
	/*
	 * Script Methods
	 */
	
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
	
	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);

		// Prompts for the user. 		
		System.out.println("Hey. I bet you're here to convert units of temperature." + "\n");
		System.out.println("Please select your unit of measurement below.");
		System.out.println("(E.g. if you would like to convert 68 degrees *Fahrenheit* to Celsius, enter [1])." + "\n");
		
		// Prints menu options
		printMenuOptions();
		
		int measurementType = scanner.nextInt();
		
		
		if (measurementType == 4) {
			seeYouLater();
			scanner.close();
			return;
		} // Exits out of application if Option 4 is selected. 
		
		
		System.out.println("***********************************************");
		
		
		/*
		 * This switch stmt confirms measurement selected.
		 * It also prompts the user for amount they would like to convert. 
		 */
		
		switch (measurementType) {
		case 1 : 
			System.out.println("You have specified that your measurement is in Fahrenheit." + "\n");
			System.out.println("Please enter your amount below (i.e. enter '68' for 68 degrees F).");
			break;
		case 2 :
			System.out.println("You have specified that your measurement is in Celsius." + "\n");
			System.out.println("Please enter your amount below (i.e. enter '20' for 20 degrees C).");
			break;
		case 3 : 
			System.out.println("You have specified that your measurement is in Kelvin."  + "\n");
			System.out.println("Please enter your amount below (e.g. enter '293' for 293 K).");
			break;
		default : 
			invalidOption();
			scanner.close();
			return;
		} 
		
		// Picks up amount specified by user. 
		double amount = scanner.nextDouble();


		
		System.out.println("***********************************************");
		
		/*
		 * The lowest theoretical temperature is absolute zero, 
		 * at which no more thermal energy can be extracted from a body.
		 * The switch statement below ensures that the input is not below absolute zero. 
		 */
		
		switch (measurementType) {
		case 1 : 
			System.out.println("Your input is " + amount + " degrees F.");
			if (amount < -459.67) {
				absoluteZero();
				scanner.close();
				return;
			}
			break;
		case 2 : 
			System.out.println("Your input is " + amount + " degrees C.");
			if (amount < -273.15) {
				absoluteZero();
				scanner.close();
				return;
			}
			break;
		case 3 : 
			System.out.println("Your input is " + amount + " degrees K.");
			if (amount < 0) {
				absoluteZero();
				scanner.close();
				return;
			}
			break;
		} // end of switch stmt.
		
		
		// Second menu asks user what they would like to convert to. 
		System.out.println(" ");
		System.out.println("What unit of temperature would you like to convert your input to?");
		printMenuOptions(); 

		// Grabs units the user wants to convert to.
		int convertTo = scanner.nextInt();

		
		
		System.out.println("***********************************************");
		
		switch (convertTo) {
		case 1 :
			// converts to Fahrenheit.
			if (measurementType == 1) {
				System.out.println("Your input is already in Fahrenheit.");
				System.out.println("You will be exited out of the application.");
				System.out.println("Please re-run and opt to convert your input to either Celsius or Kelvin.");
				scanner.close();
				return;
			}
			else if (measurementType == 2) {
				double f = celsiusToFahrenheit(amount);
				System.out.println(amount + " C is equal to " + String.format("%.2f", f) + " F.");
				thankYou();
				scanner.close();
				return;
			}
			else if (measurementType == 3) {
				double f = kelvinToFarenheit(amount);
				System.out.println(amount + " K is equal to " + String.format("%.2f", f) + " F.");
				thankYou();
				scanner.close();
				return;
			}
			break;
		case 2 :
			// converts to Celsius.
			if (measurementType == 2) {
				System.out.println("Your input is already in Celsius.");
				System.out.println("You will be exited out of the application.");
				System.out.println("Please re-run and opt to convert your input to either Fahrenheit or Kelvin.");
				scanner.close();
				return;
			}
			else if (measurementType == 1 ) {
				double c = fahrenheitToCelsius(amount);
				System.out.println(amount + " F is equal to " + String.format("%.2f", c) + " C.");
				thankYou();
				scanner.close();
				return;
			}
			else if (measurementType == 3) {
				double c = kelvinToCelsius(amount);
				System.out.println(amount + " K is equal to " + String.format("%.2f", c) + " C.");
				thankYou();
				scanner.close();
				return;
			}
			break;
		case 3 : 
			// converts to Kelvin. 
			if (measurementType == 3) {
				System.out.println("Your input is already in Kelvin.");
				System.out.println("You will be exited out of the application.");
				System.out.println("Please re-run and opt to convert your input to either Fahrenheit or Celsius.");
				scanner.close();
				return;
			}
			else if (measurementType == 1) {
				double k = fahrenheitToKelvin(amount);
				System.out.println(amount + " F is equal to " + String.format("%.2f", k) + " K.");
				thankYou();
				scanner.close();
				return;
			}
			else if (measurementType == 2) {
				double k = celsiusToKelvin(amount);
				System.out.println(amount + " F is equal to " + String.format("%.2f", k) + " K.");
				thankYou();
				scanner.close();
				return;
			}
			break;
		default : 
			invalidOption();
			
		}
		
		scanner.close();
		
		
		

		
	} //end of main
}
