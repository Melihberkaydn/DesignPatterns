package ObserverDesignPushVariant;

public class TemperatureModel extends Subject<Double> {

	private double celsiusTemperature;

	public void setF(double tempF) {
		setC(TemperatureConverter.convertFahrenheitToCelsius(tempF));
	}

	public void setC(double tempC) {
		celsiusTemperature = tempC;
		notifyObservers(tempC);
	}

	public void setK(double tempK) {
		setC(TemperatureConverter.convertKelvinToCelsius(tempK));
	}

	public void increaseF(double amount) {
		final double currentFahrenheit = TemperatureConverter.convertCelsiusToFahrenheit(celsiusTemperature);
		final double newFahrenheit = currentFahrenheit + amount;

		setC(TemperatureConverter.convertFahrenheitToCelsius(newFahrenheit));
	}

	public void increaseC(double amount) {
		setC(celsiusTemperature + amount);
	}

	public void increaseK (double amount) {
		setC(celsiusTemperature + amount);
	}

}
