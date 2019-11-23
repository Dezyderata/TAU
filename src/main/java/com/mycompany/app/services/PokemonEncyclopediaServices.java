package com.mycompany.app.services;

import com.mycompany.app.Pokemon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PokemonEncyclopediaServices implements IPokemonEncyclopediaService {

    private ArrayList<Pokemon> pokemonEncyclopedia;

    public PokemonEncyclopediaServices(){
        this.pokemonEncyclopedia = new ArrayList<>();
        this.pokemonEncyclopedia.add(new Pokemon("Slaking",4431,233, 290, 166,284));
        this.pokemonEncyclopedia.add(new Pokemon("Wishiwashi",0,0, 0, 0,0));
    }
    public PokemonEncyclopediaServices(ArrayList<Pokemon> pokemonEncyclopedia){
        this.pokemonEncyclopedia = pokemonEncyclopedia;
    }


    @Override
    public int Add(Pokemon pokemon) {
        if(this.pokemonEncyclopedia.contains(pokemon)){
            return 0;
        }
        this.pokemonEncyclopedia.add(pokemon);
        return 1;

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
    public void Delete(String pokemonName) {
        if(this.pokemonEncyclopedia.isEmpty()){
            throw new IllegalArgumentException("Name is required");
        }else {
            for (Pokemon pokemon : this.pokemonEncyclopedia) {
                if (pokemon.getName().equalsIgnoreCase(pokemonName)) {
                    this.pokemonEncyclopedia.remove(pokemon);
                }
            }
            throw new NullPointerException("No such pokemon in PokemonEncyclopedia");
        }
    }
}
