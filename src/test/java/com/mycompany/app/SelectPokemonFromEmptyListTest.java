package com.mycompany.app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@empty",
        features = "classpath:player/selectPokemon.feature"


)
public class SelectPokemonFromEmptyListTest {
}
