package methods;

public class ConversionMethods {

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
	
}
