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


}
