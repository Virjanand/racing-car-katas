package tddmicroexercises.tirepressuremonitoringsystem;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class AlarmTest {

    @Test
    void alarmStartsOff() {
        Alarm alarm = new Alarm();
        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void pressureTooLow() {
        Alarm alarm = createAlarmWithSensorMock(16.9);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    @Test
    void pressureOkLowerBound() {
        Alarm alarm = createAlarmWithSensorMock(17.0);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void pressureOkUpperBound() {
        Alarm alarm = createAlarmWithSensorMock(21.0);

        alarm.check();

        assertFalse(alarm.isAlarmOn());
    }

    @Test
    void pressureTooHigh() {
        Alarm alarm = createAlarmWithSensorMock(21.1);

        alarm.check();

        assertTrue(alarm.isAlarmOn());
    }

    private Alarm createAlarmWithSensorMock(double pressurePsiValue) {
        Sensor sensorMock = mock(Sensor.class);
        when(sensorMock.popNextPressurePsiValue()).thenReturn(pressurePsiValue);
        return new Alarm(sensorMock);
    }
}

