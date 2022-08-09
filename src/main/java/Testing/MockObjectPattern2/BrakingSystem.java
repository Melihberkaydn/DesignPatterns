package Testing.MockObjectPattern2;

public class BrakingSystem {

	private static final double SAFETY_DISTANCE = 15;

	private ABS abs = new ABS();

	private Brake brake;

	private Sensor distanceSensor;
	private Sensor speedSensor;
	private Sensor brakingPedal;
	private boolean absWarning;
	private boolean hazardousLightWarning;


	public void calculateNextFrame() {
		var speed = speedSensor.sense();
		var brakingDistance = (speed / 10.) * (speed / 10.);
		boolean shouldBrake = (brakingDistance + SAFETY_DISTANCE ) >= distanceSensor.sense();

		if (!shouldBrake) {
			return;
		}

		if (abs.shouldOverrideBrake()) {
			absWarning = true;
		} else {
			double pressure = .25 + (brakingPedal.sense() * .5);
			brake.brake(pressure);
		}
	}

	public boolean isAbsWarning() {
		return absWarning;
	}

	public boolean isHazardousLightWarning() {
		return hazardousLightWarning;
	}
}
