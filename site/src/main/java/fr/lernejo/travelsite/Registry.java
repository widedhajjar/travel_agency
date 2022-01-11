package fr.lernejo.travelsite;


public class Registry {
    public String userEmail;
    public String userName;
    public String userCountry;
    public WeatherExceptation weatherExceptation;
    public int minimumTemperatureDistance;

    public Registry(String userEmail, String userName, String userCountry, String weatherExceptation, Integer minimumTemperatureDistance) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userCountry = userCountry;
        this.weatherExceptation= WeatherExceptation.valueOf(weatherExceptation);
        this.minimumTemperatureDistance = minimumTemperatureDistance;
    }
}

