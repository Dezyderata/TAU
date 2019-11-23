package com.mycompany.app;


import com.mycompany.app.services.PokemonEncyclopediaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class PokemonEncyclopediaApi {

    @Autowired
    PokemonEncyclopediaServices pokemonEncyclopediaServices;

    @RequestMapping("/")
    public String index(){
        return "This is non rest, just checking if everything works.";
    }
    @RequestMapping(value = "/PokemonEncyclopedia/{pokemonName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Pokemon getPokemon(@PathVariable("pokemonName") String pokemonName){
        return pokemonEncyclopediaServices.Read(pokemonName);
    }

    @RequestMapping(value = "/PokemonEncyclopedia", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayList<Pokemon> getPokemons(){
        return pokemonEncyclopediaServices.ReadAll();
    }

    @RequestMapping(value = "/PokemonEncyclopedia", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addPokemon(@RequestBody Pokemon pokemon){
        pokemonEncyclopediaServices.Add(pokemon);
        return "Success";
    }
    @RequestMapping(value = "/PokemonEncyclopedia/{pokemonName}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePokemon(@PathVariable("pokemonName") String pokemonName){
        pokemonEncyclopediaServices.Delete(pokemonName);
        return "Pokemon removed";

    }

}
