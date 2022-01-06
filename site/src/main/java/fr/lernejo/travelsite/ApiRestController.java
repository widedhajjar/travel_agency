package fr.lernejo.travelsite;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ApiRestController {

    public final ArrayList<Registry> ListRegistry = new ArrayList<>();


    @PostMapping("/api/inscription")
    public void addInscription (@RequestBody Registry user){
        ListRegistry.add(user);
    }

    @GetMapping("/api/travels")
    public ArrayList<Country> getTravels(@RequestParam String userName){
        ArrayList<Country> list = new ArrayList<>();
        list.add(new Country("China",32.2));
        return list;
    }
}
