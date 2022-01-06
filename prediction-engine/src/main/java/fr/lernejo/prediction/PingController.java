package fr.lernejo.prediction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PingController {

    @GetMapping(path = "/api/ping")
    String ping() {
        return "OK";
    }

    @GetMapping(path = "/temperature")
    public Object temperature(@RequestParam String country){
        final TemperatureService temperatureService = new TemperatureService();
        ArrayList<TemperatureDay> tempList= new ArrayList<>();
        try{
            tempList.add(new TemperatureDay("2021-12-04", temperatureService.getTemperature(country)));
            tempList.add(new TemperatureDay("2021-12-05", temperatureService.getTemperature(country)));
            return new Temperature(country, tempList);
        }catch (UnknownCountryException error){
            return new ResponseEntity<>(error.getMessage(),HttpStatus.EXPECTATION_FAILED);
        }
    }


}
