package fr.lernejo.travelsite;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping(path= "/api")
public class ApiRestController {

    public final ArrayList<Registry> listRegistry = new ArrayList<>();


    @PostMapping("/api/inscription")
    public void addInscription (@RequestBody Registry user){
        listRegistry.add(user);
    }

    @GetMapping("/travels")
    public ArrayList<Country> travels(@RequestParam String userName){
        ArrayList<Country> list = new ArrayList<>();
        list.add(new Country("China",32.2));
        return list;
    }
}
