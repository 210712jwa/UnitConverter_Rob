package main;
import java.util.Scanner;
import methods.ConversionMethods;
import methods.ScriptMethods;

public class Converter {
 

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// Prompts for the user. 		
		System.out.println("Hey. I bet you're here to convert units of temperature.");
		System.out.println(" ");
		System.out.println("Please select your unit of measurement below.");
		System.out.println("(E.g. if you would like to convert 68 degrees *Fahrenheit* to Celsius, enter [1]).");
		
		// Prints menu options
		ScriptMethods.printMenuOptions();
		
		int measurementType = scanner.nextInt();
		
		
		if (measurementType == 4) {
			ScriptMethods.seeYouLater();
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
			System.out.println("You have specified that your measurement is in Fahrenheit.");
			System.out.println(" ");
			System.out.println("Please enter your amount below (i.e. enter '68' for 68 degrees F).");
			break;
		case 2 :
			System.out.println("You have specified that your measurement is in Celsius.");
			System.out.println(" ");
			System.out.println("Please enter your amount below (i.e. enter '20' for 20 degrees C).");
			break;
		case 3 : 
			System.out.println("You have specified that your measurement is in Kelvin.");
			System.out.println(" ");
			System.out.println("Please enter your amount below (e.g. enter '293' for 293 K).");
			break;
		default : 
			ScriptMethods.invalidOption();
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
				ScriptMethods.absoluteZero();
				scanner.close();
				return;
			}
			break;
		case 2 : 
			System.out.println("Your input is " + amount + " degrees C.");
			if (amount < -273.15) {
				ScriptMethods.absoluteZero();
				scanner.close();
				return;
			}
			break;
		case 3 : 
			System.out.println("Your input is " + amount + " degrees K.");
			if (amount < 0) {
				ScriptMethods.absoluteZero();
				scanner.close();
				return;
			}
			break;
		} // end of switch stmt.
		
		
		// Second menu asks user what they would like to convert to. 
		System.out.println(" ");
		System.out.println("What unit of temperature would you like to convert your input to?");
		ScriptMethods.printMenuOptions(); 

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
				double f = ConversionMethods.celsiusToFahrenheit(amount);
				System.out.println(amount + " C is equal to " + String.format("%.2f", f) + " F.");
				ScriptMethods.thankYou();
				scanner.close();
				return;
			}
			else if (measurementType == 3) {
				double f = ConversionMethods.kelvinToFarenheit(amount);
				System.out.println(amount + " K is equal to " + String.format("%.2f", f) + " F.");
				ScriptMethods.thankYou();
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
				double c = ConversionMethods.fahrenheitToCelsius(amount);
				System.out.println(amount + " F is equal to " + String.format("%.2f", c) + " C.");
				ScriptMethods.thankYou();
				scanner.close();
				return;
			}
			else if (measurementType == 3) {
				double c = ConversionMethods.kelvinToCelsius(amount);
				System.out.println(amount + " K is equal to " + String.format("%.2f", c) + " C.");
				ScriptMethods.thankYou();
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
				double k = ConversionMethods.fahrenheitToKelvin(amount);
				System.out.println(amount + " F is equal to " + String.format("%.2f", k) + " K.");
				ScriptMethods.thankYou();
				scanner.close();
				return;
			}
			else if (measurementType == 2) {
				double k = ConversionMethods.celsiusToKelvin(amount);
				System.out.println(amount + " F is equal to " + String.format("%.2f", k) + " K.");
				ScriptMethods.thankYou();
				scanner.close();
				return;
			}
			break;
		default : 
			ScriptMethods.invalidOption();
			
		}
		
		scanner.close();
		
		
		

		
	} //end of main
}
