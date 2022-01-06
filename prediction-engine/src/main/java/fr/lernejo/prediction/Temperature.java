package fr.lernejo.prediction;

import java.util.ArrayList;

public class Temperature {
    public String country;
    public ArrayList<TemperatureDay> temperatures;


    public Temperature(String country, ArrayList<TemperatureDay> temperatures) {
        this.country = country;
        this.temperatures = temperatures;
    }

}
