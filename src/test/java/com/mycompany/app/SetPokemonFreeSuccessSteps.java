package com.mycompany.app;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class SetPokemonFreeSuccessSteps {
    private Player player;
    private Pokemon wishiwashi;
    private Pokemon slaking;
    private Pokemon  venomoth;
    private Pokemon diglet;
    private Pokemon dugetrio;
    private Pokemon psyduck;
    private List<Pokemon> freePokemons;
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
    @Given("^list of pokemons own by Player$")
    public void list_of_Players_pokemons() throws Throwable{
        Assert.assertNotNull(player.pokemons);
        Assert.assertEquals(player.pokemons.size(), 6);
    }
    @When("^select pokemons with defence between (\\d+) and (\\d+)$")
    public void select_pokemons_with_defence_between(int minD, int maxD) throws Throwable{
        freePokemons = new ArrayList<>();
        freePokemons = player.setPokemonFree(minD, maxD);

    }
    @Then("^number of pokemons that were set free should be (\\d+)$")
    public void number_of_pokemons_that_were_set_free_should_be(int number) throws Throwable{
        Assert.assertEquals(freePokemons.size(), number);
    }
}
