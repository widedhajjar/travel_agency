package fr.lernejo.travelsite;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

@Service
public class ServiceApi {
    public PredictionEngineClient predictionEngineClient;
    public final ArrayList<Registry> ListRegistry = new ArrayList<>();
    public final ArrayList<Country> ListCountry = new ArrayList<>();
    public final List<String> countries;

    public ServiceApi(List<String> countries) {
        this.countries = countries;
    }


    public List<String> ServiceApi(PredictionEngineClient predictionEngineClient) throws IOException {
        this.predictionEngineClient = predictionEngineClient;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("countries.txt");
        String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        Stream<String> lines = content.lines();
        return lines.toList();
    }

    public Iterable<Registry> register_user(Registry user) {
        if (!this.ListRegistry.contains(user)) this.ListRegistry.add(user);
        return this.ListRegistry;
    }

    public Object get_dest(String userName) {
        Registry currentRegistry = null;
        for (Registry registry :this.ListRegistry)
            if (registry.userName.equals(userName)) currentRegistry = registry;
        if (currentRegistry != null)
            return get_countries(null);
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }

    private void get_final_temperature(String country) throws Exception{
        Call<Temperature> TemperatureCall = this.predictionEngineClient.listTemperature(country);
        if (TemperatureCall != null) {
            Response<Temperature> response = TemperatureCall.execute();
            assert response.body() != null;
            int finalTemperature = (response.body().temperatures.get(0).temperature.intValue() + response.body().temperatures.get(1).temperature.intValue()) / 2;
            ListCountry.add(new Country(country, finalTemperature));
        }
    }
    private Iterable<Country> get_countries(Registry user){
        ArrayList<Country> countriesLink = new ArrayList<>();
        int userCountryTemp = 0;
        for (Country Country : ListCountry)
            if (Country.country.equals(user.userCountry)) userCountryTemp = Country.temperature.intValue();
        for (Country Country : ListCountry) {
            if (!Country.country.equals(user.userCountry)
                && ((Country.temperature.intValue() < userCountryTemp - user.minimumTemperatureDistance) && user.weatherExceptation.equals(WeatherExceptation.COLDER))
                || (Country.temperature.intValue() > (user.minimumTemperatureDistance + userCountryTemp) && user.weatherExceptation.equals(WeatherExceptation.WARMER))) {
                countriesLink.add(Country);
            }
        }
        this.ListCountry.clear();
        return countriesLink;
    }
}










