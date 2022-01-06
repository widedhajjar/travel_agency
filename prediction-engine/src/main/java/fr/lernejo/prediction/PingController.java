package fr.lernejo.prediction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class PingController {

    @GetMapping(path = "/api/ping")
    String ping() {
        return "OK";
    }

    @GetMapping(path = "/api/temperature")
    public Temperature temperature(@RequestParam String country) throws IOException {
        final TemperatureService temperatureService = new TemperatureService();
        Temperature temperature = new Temperature(country);
            temperature.temperatures.add(new TemperatureDay("2021-12-04", temperatureService.getTemperature(country)));
            temperature.temperatures.add(new TemperatureDay("2021-12-05", temperatureService.getTemperature(country)));
            return temperature;
        }
}
