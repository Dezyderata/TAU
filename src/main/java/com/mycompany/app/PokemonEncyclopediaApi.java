package com.mycompany.app;


import com.mycompany.app.services.PokemonEncyclopediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonEncyclopediaApi {

    @Autowired
    PokemonEncyclopediaServices pokemonEncyclopediaServices;

    @RequestMapping("/")
    public String index(){
        return "This is non rest, just checking if everything works.";
    }

}
