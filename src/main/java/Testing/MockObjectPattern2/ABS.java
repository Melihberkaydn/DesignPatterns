package Testing.MockObjectPattern2;

public class ABS {

	private static final double THRESHOLD = .3;

	private Sensor tractionSensor;

	public boolean shouldOverrideBrake() {
		return tractionSensor.sense() < THRESHOLD;
	}
}
