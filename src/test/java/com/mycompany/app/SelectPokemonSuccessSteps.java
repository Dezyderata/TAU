package com.mycompany.app;

import com.mycompany.app.domain.Player;
import com.mycompany.app.domain.Pokemon;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import org.junit.Assert;

public class SelectPokemonSuccessSteps {
    private Player player;
    private Pokemon wishiwashi;
    private Pokemon slaking;
    private Pokemon testPokemon;

    @Before
    public void setUp(){
        player = new Player("John");
        wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        slaking = new Pokemon("Slaking", 0,0,0,0,0);
        player.catchPokemon(wishiwashi);
        player.catchPokemon(slaking);

    }
    @Given("^list of pokemons catch by Player$")
    public void list_of_pokemons_catch_by_Player() throws Throwable{
        Assert.assertNotNull(player.getPokemons());
        Assert.assertEquals(player.getPokemons().size(), 2);
    }
    @When("^try to select \"([a-zA-Z]+)\"$")
    public void try_to_select(String pokemon_name) throws Throwable{
        testPokemon = player.selectPokemon(pokemon_name) ;

    }
    @Then("^the answer should be: \"([a-zA-Z]+)\"$")
    public void the_answer_should_be(String ans) throws Throwable{
        Assert.assertEquals(testPokemon.getName(), ans);
    }

}
