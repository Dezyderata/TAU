package com.mycompany.app;

import java.util.List;
import java.util.ArrayList;

public class Player {

    protected String name;
    protected List<Pokemon> pokemons;
    protected int pokeBalls;
    protected int level;

    public Player() {
        this.pokemons = new ArrayList<>();
        this.pokeBalls = 100;
        this.level = 0;
    }
    public Player(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.pokeBalls = 100;
        this.level = 0;
    }
    public String catchPokemon(Pokemon pokemon){
        if(this.pokeBalls > 0){
            double x = Math.random() + this.level/100;
            if(x >= (pokemon.getCombatPower()/1000)){
                this.pokemons.add(pokemon);
                --this.pokeBalls;
                ++this.level;
                return "Success!";
            }else{
                return "Pokemon has run off!";
            }
        }else{
            return "You out of poke balls!";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPokeBalls() {
        return pokeBalls;
    }

    public void setPokeBalls(int pokeBalls) {
        this.pokeBalls = pokeBalls;
    }
}
