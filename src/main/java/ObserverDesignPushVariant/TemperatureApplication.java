package ObserverDesignPushVariant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public final class TemperatureApplication {

	private TemperatureApplication() {
		// Private constructor because a utility class should not be instantiable.
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		TemperatureModel temperature = new TemperatureModel();

		FahrenheitGUI fahrenheitGUI = new FahrenheitGUI(temperature, new Point(100, 100));
		fahrenheitGUI.show();

		CelsiusGUI celsiusGUI = new CelsiusGUI(temperature, new Point(100, 250));
		celsiusGUI.show();

		SliderGUI sliderGUI = new SliderGUI(temperature, new Point(300, 100));
		sliderGUI.show();

		GaugeGUI gaugeGUI = new GaugeGUI(temperature, new Point(300, 200));
		gaugeGUI.show();

		KelvinGUI kelvinGUI = new KelvinGUI(temperature, new Point(100, 400));
		kelvinGUI.show();
	}

	public static class CloseListener extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent event) {
			event.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}
