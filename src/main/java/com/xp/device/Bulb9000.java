package com.xp.device;

import com.xp.home.Bulb;

public class Bulb9000 implements Bulb {
    @Override
    public void turnOff() {
        System.out.println("=====>Bulb turnOff");
    }

    @Override
    public void turnOn() {
        System.out.println("=====>Bulb turnOn");
    }
}
