package AdapterPattern;

import java.text.DecimalFormat;

public final class TemperatureCurve {

	private static final int TEMPERATURE_SAMPLES = 15;

	private TemperatureCurve() {
	}

	public static void main(String[] args) {

		ThermoInterface thermo = new ThermoAdapter();

		DecimalFormat df = new DecimalFormat("#.#");

		for (int i = 0; i < TEMPERATURE_SAMPLES; i++) {
			System.out.println("Sample " + (i + 1) + ": " + df.format(thermo.getTempC()));
		}
	}
}
