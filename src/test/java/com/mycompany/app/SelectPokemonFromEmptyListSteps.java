package com.mycompany.app;

import com.mycompany.app.domain.Player;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SelectPokemonFromEmptyListSteps {
    private Player player;
    private Exception exception;

    @Before
    public void setUp(){
        player = new Player("John");
    }

    @Given("^empty pokemon list$")
    public void list_of_Players_pokemons() throws Throwable{
        Assert.assertEquals(player.getPokemons().size(),0);
    }
    @When("^try to select pokemon \"([a-zA-Z]+)\"$")
    public void try_to_select_pokemon(String pokemon) throws Throwable{
        try {
            player.selectPokemon(pokemon);
        }catch (Exception e){
            exception = e;
        }

    }
    @Then("^exception should be: IllegalStateException$")
    public void exception_should_be_IllegalStateException() throws Throwable{
        Assert.assertEquals(exception.getMessage(), "Your pokemon list is empty!");
        Assert.assertEquals(exception.getClass(), IllegalStateException.class);
    }
}
