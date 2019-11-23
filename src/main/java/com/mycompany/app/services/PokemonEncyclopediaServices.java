package com.mycompany.app.services;

import com.mycompany.app.domain.Pokemon;
import org.springframework.stereotype.Component;

import javax.resource.spi.IllegalStateException;
import java.util.ArrayList;

@Component
public class PokemonEncyclopediaServices implements IPokemonEncyclopediaService{

    private ArrayList<Pokemon> pokemonEncyclopedia;

    public PokemonEncyclopediaServices(){
        this.pokemonEncyclopedia = new ArrayList<>();
    }
    public PokemonEncyclopediaServices(ArrayList<Pokemon> pokemonEncyclopedia){
        this.pokemonEncyclopedia = pokemonEncyclopedia;
    }
    @Override
    public void Add(Pokemon pokemon) throws IllegalStateException {
        if(pokemonEncyclopedia.contains(pokemon)){
            throw new IllegalStateException("This pokemon is already in PokemonEncyclopedia");
        }
        else{
            pokemonEncyclopedia.add(pokemon);
        }
    }

    @Override
    public Pokemon Read(String pokemonName) {
        if(pokemonName.isEmpty()){
            throw new IllegalArgumentException("Name is required");
        }else {
            for (Pokemon pokemon : this.pokemonEncyclopedia) {
                if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                    return pokemon;
                }
            }
            throw new NullPointerException("No such pokemon in PokemonEncyclopedia");
        }
    }

    @Override
    public ArrayList<Pokemon> ReadAll() {
        return this.pokemonEncyclopedia;
    }

    @Override
    public Pokemon Delete(String pokemonName) {
        if(pokemonEncyclopedia.isEmpty()){
            throw new IllegalArgumentException("Name is required");
        }else {
            for (Pokemon pokemon : this.pokemonEncyclopedia) {
                if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                    pokemonEncyclopedia.remove(pokemon);
                    return pokemon;
                }
            }
            throw new NullPointerException("No such pokemon in PokemonEncyclopedia");
        }
    }

}
