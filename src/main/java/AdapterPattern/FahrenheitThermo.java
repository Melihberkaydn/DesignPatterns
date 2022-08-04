package AdapterPattern;

import java.util.Random;

public class FahrenheitThermo {

	private static final Random RANDOM = new Random(1);

	public double getFahrenheitTemperature() {
		return RANDOM.nextDouble() * 100;
	}
}
