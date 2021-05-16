package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm {
    private static final double LOW_PRESSURE_THRESHOLD = 17;
    private static final double HIGH_PRESSURE_THRESHOLD = 21;

    private Sensor sensor;

    private boolean alarmOn;

    // Constructor for backwards compatibility
    public Alarm() {
        sensor = new Sensor();
    }

    // For unit testing
    Alarm(Sensor sensor) {
        this.sensor = new Sensor();
        this.sensor = sensor;
    }

    public void check() {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (isPressureWrong(psiPressureValue)) {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn() {
        return alarmOn;
    }

    private boolean isPressureWrong(double psiPressureValue) {
        return isPressureTooLow(psiPressureValue) || isPressureTooHigh(psiPressureValue);
    }

    private boolean isPressureTooHigh(double psiPressureValue) {
        return Double.compare(psiPressureValue, HIGH_PRESSURE_THRESHOLD) > 0;
    }

    private boolean isPressureTooLow(double psiPressureValue) {
        return Double.compare(psiPressureValue, LOW_PRESSURE_THRESHOLD) < 0;
    }
}
