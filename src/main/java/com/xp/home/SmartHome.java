package com.xp.home;

public class SmartHome {
    public void run(Switch aSwitch, Bulb bulb) {
        if (aSwitch.isOn()) {
            bulb.turnOn();
        } else {
            bulb.turnOff();
        }
    }
}
