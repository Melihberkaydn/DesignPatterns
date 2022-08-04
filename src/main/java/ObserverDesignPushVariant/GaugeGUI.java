package ObserverDesignPushVariant;

import javax.swing.*;
import java.awt.*;

public class GaugeGUI implements Observer<Double> {

	private static final int WIDTH = 220;
	private static final int HEIGHT = 300;

	private int currentValue;

	private final TemperatureModel model;
	private final Point location;

	protected JFrame gaugeFrame;
	protected JPanel gaugeCanvas;

	public GaugeGUI(TemperatureModel model, Point location) {
		this.model = model;
		this.location = location;
		createUI();
		model.addObserver(this);
	}

	protected void createUI() {
		this.gaugeCanvas = new GaugeCanvas();
	}

	public void show() {
		if (gaugeFrame == null) {
			gaugeFrame = new JFrame("Temperature Gauge");
			gaugeFrame.add("Center", gaugeCanvas);
			gaugeFrame.setSize(WIDTH, HEIGHT);
			gaugeFrame.setLocation(location);
			gaugeFrame.addWindowListener(new TemperatureApplication.CloseListener());
		}
		gaugeFrame.setVisible(true);
	}

	@Override
	public void onUpdate(Double newState) {
		setCurrentValue(newState.intValue());
		gaugeCanvas.repaint();
	}

	public void setCurrentValue(int level) {
		this.currentValue = level;
	}

	public int getCurrentValue() {
		return this.currentValue;
	}

	private class GaugeCanvas extends JPanel {

		private static final int MAX_VALUE = 150;
		private static final int MIN_VALUE = -20;

		private static final int GRAPHICS_WIDTH = 20;
		private static final int GRAPHICS_TOP = 20;
		private static final int GRAPHICS_HEIGHT = 200;
		private static final int GRAPHICS_LEFT = 100;

		@Override
		public void paint(Graphics graphics) {
			graphics.clearRect(0, 0, getWidth(), getHeight());
			graphics.setColor(Color.black);
			graphics.drawRect(GRAPHICS_LEFT, GRAPHICS_TOP - 1, GRAPHICS_WIDTH, GRAPHICS_HEIGHT);
			Color fillcolor;
			if (getCurrentValue() > 0.0) {
				fillcolor = Color.red;
			} else {
				fillcolor = Color.blue;
			}
			graphics.setColor(fillcolor);
			graphics.fillOval(GRAPHICS_LEFT - GRAPHICS_WIDTH / 2, GRAPHICS_TOP + GRAPHICS_HEIGHT - GRAPHICS_WIDTH / 3, GRAPHICS_WIDTH * 2, GRAPHICS_WIDTH * 2);
			graphics.setColor(Color.black);
			graphics.drawOval(GRAPHICS_LEFT - GRAPHICS_WIDTH / 2, GRAPHICS_TOP + GRAPHICS_HEIGHT - GRAPHICS_WIDTH / 3, GRAPHICS_WIDTH * 2, GRAPHICS_WIDTH * 2);
			graphics.setColor(Color.white);
			graphics.fillRect(GRAPHICS_LEFT + 1, GRAPHICS_TOP + 1, GRAPHICS_WIDTH - 1, GRAPHICS_HEIGHT - 1);
			graphics.setColor(fillcolor);
			int redtop = GRAPHICS_HEIGHT * (getCurrentValue() - MAX_VALUE) / (MIN_VALUE - MAX_VALUE);
			graphics.fillRect(GRAPHICS_LEFT + 1, GRAPHICS_TOP + redtop, GRAPHICS_WIDTH - 1, GRAPHICS_HEIGHT - redtop);
		}
	}
}
