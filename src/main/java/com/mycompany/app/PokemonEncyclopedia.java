package com.mycompany.app;

import com.mycompany.app.domain.Pokemon;

import javax.resource.spi.IllegalStateException;

import com.mycompany.app.services.PokemonEncyclopediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PokemonEncyclopedia {

    @Autowired
    PokemonEncyclopediaServices pokemonEncyclopediaServices;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping("/")
    public String index() {
        return "This is non rest, just checking if everything works.";
    }
}
