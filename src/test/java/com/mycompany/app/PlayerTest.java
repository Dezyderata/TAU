package com.mycompany.app;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import static org.mockito.Mockito.*;


@RunWith( JUnit4.class)
public class PlayerTest {

    @Test
    public void testCatchThreePokemonMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getCombatPower()).thenReturn(0);
        player.catchPokemon(pokemon);
        player.catchPokemon(pokemon);
        player.catchPokemon(pokemon);
        verify(pokemon, times(3)).getCombatPower();

    }

    @Test
    public void testPokeCatchWinMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getCombatPower()).thenReturn(0);
        Assert.assertEquals("Success!", player.catchPokemon(pokemon));
        verify(pokemon, atLeastOnce()).getCombatPower();
    }

    @Test
    public void testPokeCatchLoseMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getCombatPower()).thenReturn(10000);
        Assert.assertEquals("Pokemon has run off!", player.catchPokemon(pokemon));
        verify(pokemon, only()).getCombatPower();
    }
    @Test
    public void testTrainPokemonSuccessMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getName()).thenReturn("Fafik");
        when(pokemon.getCombatPower()).thenReturn(0);
        when(pokemon.getAttack()).thenReturn(0);
        player.catchPokemon(pokemon);
        Assert.assertEquals("Pokemon training success!", player.trainPokemon("Fafik"));
        verify(pokemon, never()).getHealth();


    }

    @Test
    public void testTrainPokemonFailMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getName()).thenReturn("Fafik");
        when(pokemon.getCombatPower()).thenReturn(0);
        when(pokemon.getHealth()).thenReturn(100);
        when(pokemon.getAttack()).thenReturn(100000);
        player.catchPokemon(pokemon);
        Assert.assertEquals("Pokemon training fail!", player.trainPokemon("Fafik"));
        verify(pokemon, atMost(2)).getHealth();

    }

    @Test
    public void testTrainPokemonFailPokemonParishMock(){
        Player player = new Player("Mark");
        Pokemon pokemon = mock(Pokemon.class);
        when(pokemon.getName()).thenReturn("Fafik");
        when(pokemon.getCombatPower()).thenReturn(0);
        when(pokemon.getHealth()).thenReturn(0);
        when(pokemon.getAttack()).thenReturn(100000);
        player.catchPokemon(pokemon);
        Assert.assertEquals(1, player.getPokemons().size());
        Assert.assertEquals("Pokemon training fail! Pokemon has died!", player.trainPokemon("Fafik"));
        Assert.assertEquals(0, player.getPokemons().size());
        verify(pokemon, atLeast(2)).getHealth();
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
