package com.mycompany.app;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.mockito.Mockito.*;


@RunWith( JUnit4.class)
public class PlayerTest {


    @Test
    public void testPokeCatchWinMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getCombatPower()).thenReturn(0);
        Assert.assertEquals("Success!", player.catchPokemon(pokemon));
    }

    @Test
    public void testPokeCatchLoseMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getCombatPower()).thenReturn(10000);
        Assert.assertEquals("Pokemon has run off!", player.catchPokemon(pokemon));
    }


    @Test
    public void isPlayerClassIsImplementedTest(){
        Assert.assertNotNull(new Player());
    }

    @Test
    public void creationPlayerWithNameTest(){
        Assert.assertNotNull(new Player("John"));
    }

    @Test
    public void pokemonListExistsTest(){
        Player player = new Player();
        Assert.assertNotNull(player.pokemons);
    }
    @Test
    public void pokemonListExistsInPlayerWithNameTest(){
        Player player = new Player("John");
        Assert.assertNotNull(player.pokemons);
    }

    @Test
    public void impossibleToCatchMightyPokemonByFreshPlayerTest(){
        Player player = new Player();
        Pokemon slaking = new Pokemon("Slaking",4431,233, 290, 166,284);
        Assert.assertEquals("Pokemon has run off!", player.catchPokemon(slaking));
        Assert.assertEquals(player.pokemons.size(), 0);
        Assert.assertEquals(player.level, 0);
        Assert.assertEquals(player.pokeBalls, 99);
    }

    @Test
    public void playerFailToCatchPokemonDueToLackOfPokeBallsTest(){
        Player player = new Player("John");
        player.setPokeBalls(0);
        Pokemon slaking = new Pokemon("Slaking",4431,233, 290, 166,284);
        Assert.assertEquals("You out of poke balls!", player.catchPokemon(slaking));
    }
    @Test
    public void playerSuccessInCatchingPokemonTest(){
        Player player = new Player();
        Pokemon wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        Assert.assertEquals("Success!", player.catchPokemon(wishiwashi));
        Assert.assertEquals(player.pokemons.size(), 1);
        Assert.assertEquals(player.level, 1);
        Assert.assertEquals(player.pokeBalls, 99);

    }
    @Test(expected = IllegalStateException.class)
    public void playerSelectFromEmptyPokemonListTest(){
        Player player = new Player();
        player.selectPokemon("Wishiwashi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void playerSelectPokemonWithoutNameFromPokemonListTest(){
        Player player = new Player();
        player.selectPokemon("");
    }                                                
    @Test(expected = NullPointerException.class)
    public void playerSelectPokemonWhichHeDoesNotHaveTest(){
        Player player = new Player();
        Pokemon wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        player.catchPokemon(wishiwashi);
        player.selectPokemon("Slaking");
    }
     @Test
    public void playerSelectPokemonSuccessTest(){
        Player player = new Player();
        Pokemon wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        player.catchPokemon(wishiwashi);
        Assert.assertEquals(player.selectPokemon("Wishiwashi"), wishiwashi);

    }
}
