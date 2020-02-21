package com.xp.home;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SmartHomeTest {

    //1. Test using Stub and Spy
    private class AlwaysOnSwitch implements Switch {
        @Override
        public boolean isOn() {
            return true;
        }
    }

    private class AlwaysOffSwitch implements Switch {
        @Override
        public boolean isOn() {
            return false;
        }
    }
    private class BulbSpy implements Bulb {

        private boolean turnedOn = false;

        private boolean turnedOff = false;

        @Override
        public void turnOn() {
            turnedOn = true;
        }

        @Override
        public void turnOff() {
            turnedOff = true;
        }

        public boolean turnedOnWasCalled() {
            return turnedOn;
        }
        public boolean turnedOffWasCalled() {
            return turnedOff;
        }

    }

    @Test
    public void givenSwitchIsOn_whenRun_bulbTurnsOn() {
        Switch switchStub = new AlwaysOnSwitch();
        BulbSpy bulbSpy = new BulbSpy();

        new SmartHome().run(switchStub, bulbSpy);

        assertEquals(true, bulbSpy.turnedOnWasCalled());

    }

    @Test
    public void givenSwitchIsOff_whenRun_bulbTurnsOff() {
        Switch switchStub = new AlwaysOffSwitch();
        BulbSpy bulbSpy = new BulbSpy();

        new SmartHome().run(switchStub, bulbSpy);

        assertEquals(false, bulbSpy.turnedOnWasCalled());
        assertEquals(true, bulbSpy.turnedOffWasCalled());
    }



    //2. Test using Mock
    @Test
    public void givenSwitchIsOn_whenRun_bulbTurnsOn2() {
        Switch switchMock = mock(Switch.class);
        when(switchMock.isOn()).thenReturn(true); //always on

        Bulb bulbMock = mock(Bulb.class);

        new SmartHome().run(switchMock, bulbMock);

        verify(bulbMock).turnOn();

        verify(bulbMock,never()).turnOff();

    }



}
