package com.mycompany.app;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlayerTest {

    @Test
    public void isPlayerClassIsImplementedTest(){
        Assert.assertNotNull(new Player());
    }

    @Test
    public void creationPlayerWithNameTest(){
        Assert.assertNotNull(new Player("John"));
    }

    @Test
    public void pokemonListExists(){
        Player player = new Player();
        Assert.assertNotNull(player.pokemons);
    }
    @Test
    public void pokemonListExistsInPlayerWithName(){
        Player player = new Player("John");
        Assert.assertNotNull(player.pokemons);
    }

    @Test
    public void impossibleToCatchMightyPokemonByFreshPlayer(){
        Player player = new Player();
        Pokemon slaking = new Pokemon("Slaking",4431,233, 290, 166,284);
        Assert.assertEquals("Pokemon has run off!", player.catchPokemon(slaking));
        Assert.assertEquals(player.pokemons.size(), 0);
        Assert.assertEquals(player.level, 0);
        Assert.assertEquals(player.pokeBalls, 100);
    }

    @Test
    public void playerFailToCatchPokemonDueToLackOfPokeBalls(){
        Player player = new Player();
        player.setPokeBalls(0);
        Pokemon slaking = new Pokemon("Slaking",4431,233, 290, 166,284);
        Assert.assertEquals("You out of poke balls!", player.catchPokemon(slaking));
    }
    @Test
    public void playerSuccessInCatchingPokemon(){
        Player player = new Player();
        Pokemon wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        Assert.assertEquals("Success!", player.catchPokemon(wishiwashi));
        Assert.assertEquals(player.pokemons.size(), 1);
        Assert.assertEquals(player.level, 1);
        Assert.assertEquals(player.pokeBalls, 99);

    }
}
