package com.mycompany.app;

import java.util.List;
import java.util.ArrayList;

public class Player {

    protected String name;
    protected List<Pokemon> pokemons;

    public Player(){
        this.pokemons = new ArrayList<>();
    }
    public Player(String name){
        this.name = name;
        this.pokemons = new ArrayList<>();
    }

}
