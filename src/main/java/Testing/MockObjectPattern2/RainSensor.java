package Testing.MockObjectPattern2;

import java.util.concurrent.ThreadLocalRandom;

public class RainSensor implements Sensor {

	@Override
	public double sense() {
		return ThreadLocalRandom.current().nextDouble();
	}
}
