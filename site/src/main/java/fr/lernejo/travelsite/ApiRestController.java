package fr.lernejo.travelsite;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ApiRestController {

    //public final ArrayList<Registry> ListRegistry = new ArrayList<>();
    public final PredictionEngineClient predictionEngineClient = new Launcher().predictionEngineClient();
    public final ServiceApi serviceApi = new ServiceApi((List<String>) this.predictionEngineClient);



    @PostMapping("/api/inscription")
    public @ResponseBody Iterable<Registry> register_user(@RequestBody Registry user){

        return this.serviceApi.register_user(user);
    }
    @GetMapping("/api/travels")
    public @ResponseBody
    Object get_dest(@RequestParam String userName){
        return this.serviceApi.get_dest(userName);

    }
}
