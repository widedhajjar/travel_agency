package fr.lernejo.travelsite;

import com.fasterxml.jackson.annotation.JsonTypeId;

public class Registry {
    public String userEmail;
    public String userName;
    public String userCountry;
    public WeatherExceptation weatherExceptation;
    public int minimumTemperatureDistance;

    public Registry(String userEmail, String userName, String userCountry, String weatherExpectation, Integer minimumTemperatureDistance) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry;
        this.weatherExceptation = WeatherExceptation.valueOf(weatherExpectation);
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }
}
