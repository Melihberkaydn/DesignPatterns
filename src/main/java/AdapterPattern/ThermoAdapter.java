package AdapterPattern;

public class ThermoAdapter implements ThermoInterface {

    private FahrenheitThermo thermo;

    public ThermoAdapter() {
        thermo = new FahrenheitThermo();
    }

    @Override
    public double getTempC() {
        double fahrenheit = thermo.getFahrenheitTemperature();
        double celcius = (fahrenheit - 32.0) * (5.0 / 9.0);
        return celcius;
    }
}
