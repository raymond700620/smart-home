package com.xp;

import com.xp.home.*;
import com.xp.device.*;

import java.io.InputStream;
import java.util.Properties;

public class Assembler {

    //Assembly
    public static void main(String[] agrv) throws Exception {
        //1. normalAssembly
        normalAssembly();

        System.out.println("----------------------");

        //2. Plugin
        dynamicAssembly();

    }

    public static void normalAssembly() {
        Bulb bulb = new Bulb9000();
        Switch aSwitch = new Switch9000();

        SmartHome home = new SmartHome();
        home.run(aSwitch, bulb);

    }

    //Plugin - replace devices easily
    public static void dynamicAssembly() throws Exception {
        //Get Class Name based on the configuration file
        InputStream is = Assembler.class.getResourceAsStream("/sample.properties");
        Properties prop = new Properties();
        prop.load(is);


        Bulb bulb = (Bulb) Class.forName(prop.getProperty("BULB_DEVICE")).newInstance();
        Switch aSwitch = (Switch) Class.forName(prop.getProperty("SWITCH_DEVICE")).newInstance();

        SmartHome home = new SmartHome();
        home.run(aSwitch, bulb);

    }
}
