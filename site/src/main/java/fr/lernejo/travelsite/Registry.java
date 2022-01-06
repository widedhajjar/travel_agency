package fr.lernejo.travelsite;

import com.fasterxml.jackson.annotation.JsonTypeId;

public class Registry {
    public String userEmail;
    public String userName;
    public String userCountry;
    public WeatherExceptation weatherExceptation;
    public int minimumTemperatureDistance;

}
