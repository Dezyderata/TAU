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
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (this.pokemons.isEmpty()) {
            throw new IllegalStateException("Your pokemon list is empty!");
        } else {
            for (int i = 0; i < this.pokemons.size(); i++) {
                if (this.pokemons.get(i).getName().equalsIgnoreCase(name)) {
                    return this.pokemons.get(i);
                }
            }
            throw new NullPointerException("You didn't catch this pokemon");
        }
    }
//    public List<Pokemon> selectPokemonByCombatPower(int maxCB, int minCB) throws IllegalStateException, IllegalArgumentException, NullPointerException {
//        if (minCB < 0 || maxCB < 0) {
//            throw new IllegalArgumentException("Pokemon combat power values incorrect!");
//        }
//        if (this.pokemons.isEmpty()) {
//            throw new IllegalStateException("Your pokemon list is empty!");
//        }
//        List<Pokemon> ans = new ArrayList<>();
//        Pokemon pok;
//        for (int i = 0; i < this.pokemons.size(); i++) {
//            pok =
//            if (this.pokemons.get(i).getCombatPower()) {
//               this.pokemons.get(i);
//           }
//        }
//    }
    public void removePokemon(String pattern){
        if (pattern.isEmpty()) {
            throw new IllegalArgumentException("Name is required");
        }
        if (this.pokemons.isEmpty()) {
            throw new IllegalStateException("Your pokemon list is empty!");
        } else {
            for (int i = 0; i < this.pokemons.size(); i++) {
                if (this.pokemons.get(i).getName().equalsIgnoreCase(pattern)) {
                    this.pokemons.remove(i);

                }
            }
            throw new NullPointerException("You didn't catch this pokemon");
        }
    }
    protected String trainPokemon(String name){
        Pokemon pokemon = this.selectPokemon(name);
        int index = pokemons.indexOf(pokemon);
        double x = Math.random() + this.level/100;
        if(x >= ((pokemon.getCombatPower()+pokemon.getAttack())/10000)){
            pokemon.setAttack(pokemon.getAttack()+5);
            pokemon.setCombatPower(pokemon.getCombatPower()+5);
            pokemon.setDefence(pokemon.getDefence()+5);
            pokemon.setMaxHealthPoints(pokemon.getMaxHealthPoints()+5);
            pokemon.setStamina(pokemon.getStamina()+5);
            pokemon.setAttack(pokemon.getAttack()+5);
            pokemons.set(index, pokemon);
            return "Pokemon training success!";
        }else{
            pokemon.setHealth(pokemon.getHealth() - 10);
            if(pokemon.getHealth() == 0){
                pokemons.remove(pokemons.indexOf(pokemon));
                return "Pokemon training fail! Pokemon has died!";
            }else{
                pokemons.set(index, pokemon);
                return "Pokemon training fail!";
            }
        }
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getPokeBalls() {
        return pokeBalls;
    }

    public void setPokeBalls(int pokeBalls) {
        this.pokeBalls = pokeBalls;
    }

}
