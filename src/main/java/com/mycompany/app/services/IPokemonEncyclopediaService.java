package com.mycompany.app.services;

import com.mycompany.app.Pokemon;

import java.util.ArrayList;

public interface IPokemonEncyclopediaService {
    void Add(Pokemon pokemon);
    Pokemon Read(String pokemonName);
    ArrayList<Pokemon> ReadAll();
    void Delete(String pokemonName);

}
