package com.mycompany.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Player {

    protected String name;
    protected List<Pokemon> pokemons;
    protected int pokeBalls;
    protected int level;
    protected Date joiningDate;



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
        if(this.getPokeBalls() > 0){
            double x = Math.random() + this.level/100;
            if(x >= (pokemon.getCombatPower()/1000)){
                this.pokemons.add(pokemon);
                --this.pokeBalls;
                ++this.level;
                return "Success!";
            }else{
                --this.pokeBalls;
                return "Pokemon has run off!";
            }
        }else{
            return "You out of poke balls!";
        }
    }
    public Pokemon selectPokemon(String name) throws IllegalStateException, IllegalArgumentException, NullPointerException {
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name is required");
        }
        if(this.pokemons.isEmpty()){
            throw new IllegalStateException("Your pokemon list is empty!");
        }else{
            for(int i = 0; i < this.pokemons.size(); i++){
                if(this.pokemons.get(i).getName().equalsIgnoreCase(name)){
                    return this.pokemons.get(i);
                }
            }
            throw new NullPointerException("You didn't catch this pokemon");
        }
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

}
