package com.mycompany.app;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class FindInPlayerFailSteps {
    private Player player;
    private Pokemon wishiwashi;
    private Pokemon slaking;
    private Exception exception;

    @Before
    public void setUp(){
        player = new Player("John");
        wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        slaking = new Pokemon("Slaking", 0,0,0,0,0);
        player.catchPokemon(wishiwashi);
        player.catchPokemon(slaking);

    }

    @Given("^list of Players pokemons$")
    public void list_of_Players_pokemons() throws Throwable{
        Assert.assertNotNull(player.pokemons);
        Assert.assertEquals(player.pokemons.size(), 2);
    }
    @When("^try to select wrong pokemon \"([a-zA-Z]+)\"$")
    public void try_to_select_wrong_pokemon(String pokemon_name) throws Throwable{
        try {
            player.selectPokemon(pokemon_name);
        }catch (Exception e){
            exception = e;
        }

    }
    @Then("^the answer should be: NullPointerException$")
    public void the_answer_should_be_NullPointerException() throws Throwable{
        Assert.assertEquals(exception.getMessage(), "You didn't catch this pokemon");
        Assert.assertEquals(exception.getClass(), NullPointerException.class);
    }
}
