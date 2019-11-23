package com.mycompany.app;


import com.mycompany.app.services.PokemonEncyclopediaServices;
import io.swagger.models.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;


@RestController
public class PokemonEncyclopediaApi {

    @Autowired
    PokemonEncyclopediaServices pokemonEncyclopediaServices;

    @RequestMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String index(){
        return "This is non rest, just checking if everything works.";
    }

    @RequestMapping(value = "/PokemonEncyclopedia/{pokemonName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity getPokemon(@PathVariable("pokemonName") String pokemonName) throws SQLException {
        if(pokemonEncyclopediaServices.Read(pokemonName).equals(false)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(pokemonEncyclopediaServices.Read(pokemonName), HttpStatus.OK);
    }

    @RequestMapping(value = "/PokemonEncyclopedia", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArrayList<Pokemon> getPokemons(){
        return pokemonEncyclopediaServices.ReadAll();
    }

    @RequestMapping(value = "/PokemonEncyclopedia", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Pokemon addPokemon(@RequestBody Pokemon pokemon){
        if(pokemonEncyclopediaServices.Add(pokemon)<1) return null;
        return pokemon;
    }
    @RequestMapping(value = "/PokemonEncyclopedia/{pokemonName}", method = RequestMethod.DELETE)
    public String deletePokemon(@PathVariable("pokemonName") String pokemonName){
        pokemonEncyclopediaServices.Delete(pokemonName);
        return "redirect:PokemonEncyclopedia";
    }


}
