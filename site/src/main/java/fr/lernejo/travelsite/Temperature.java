package fr.lernejo.travelsite;

import java.util.ArrayList;

public class Temperature {
    public final String country;
    public final ArrayList<TemperatureDay> temperatures;


    public Temperature(String country, ArrayList<TemperatureDay> temperatures) {
        this.country = country;
        this.temperatures = temperatures;
    }

}
