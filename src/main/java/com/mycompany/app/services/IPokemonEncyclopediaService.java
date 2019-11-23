package com.mycompany.app.services;

import com.mycompany.app.domain.Pokemon;

import java.util.ArrayList;

public interface IPokemonEncyclopediaService {
    void Add(Pokemon pokemon) throws javax.resource.spi.IllegalStateException;
    Pokemon Read(String pokemonName);
    ArrayList<Pokemon> ReadAll();
    Pokemon Delete(String pokemonName);
}
