package fr.lernejo.travelsite;


public record Registry(String userEmail, String userName, String userCountry,
                       WeatherExceptation weatherExceptation, int minimumTemperatureDistance) {
}




