package fr.lernejo.travelsite;


public class Registry {
    public final String userEmail;
    public final String userName;
    public final String userCountry;
    public final WeatherExceptation weatherExceptation;
    public final int minimumTemperatureDistance;

    public Registry(String userEmail, String userName, String userCountry, String weatherExceptation, Integer minimumTemperatureDistance) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry;
        this.weatherExceptation= WeatherExceptation.valueOf(weatherExceptation);
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }
}

