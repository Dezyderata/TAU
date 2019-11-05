package com.mycompany.app;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class SetPokemonFreeWrongValuesSteps {
    private Player player;
    private Pokemon wishiwashi;
    private Pokemon slaking;
    private Pokemon  venomoth;
    private Pokemon diglet;
    private Pokemon dugetrio;
    private Pokemon psyduck;
    private Exception exception;

    @Before
    public void setUp(){
        player = new Player("John");
        wishiwashi = new Pokemon("Wishiwashi",0,20, 20, 20,20);
        slaking = new Pokemon("Slaking", 0,10,10,10, 10);
        venomoth = new Pokemon("Venomoth",0,23, 23, 23,23);
        diglet = new Pokemon("Diglett",0,7, 7, 7,7);
        dugetrio = new Pokemon("Dugetrio",0,33, 33, 33,33);
        psyduck = new Pokemon("Psyduck",0,84, 84, 84,84);
        player.catchPokemon(wishiwashi);
        player.catchPokemon(slaking);
        player.catchPokemon(venomoth);
        player.catchPokemon(diglet);
        player.catchPokemon(dugetrio);
        player.catchPokemon(psyduck);
    }
    @Given("^pokemons own by Player$")
    public void pokemons_own_by_player() throws Throwable{
        Assert.assertNotNull(player.pokemons);
        Assert.assertEquals(player.pokemons.size(), 6);
    }
    @When("^try to select pokemon with wrong defence values: (\\d+) and (\\d+)$")
    public void try_to_select_pokemon_with_wrong_defence_values(int minD, int maxD) throws Throwable{
        try {
            player.setPokemonFree(minD, maxD);
        }catch (Exception e){
            exception = e;
        }
    }
    @Then("^the exception should be: IllegalArgumentException$")
    public void the_exception_should_be_IllegalArgumentException() throws Throwable{
        Assert.assertEquals(exception.getMessage(), "Pokemon defence values incorrect!");
        Assert.assertEquals(exception.getClass(), IllegalArgumentException.class);
    }
}
