package com.mycompany.app;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@success",
        features = "classpath:player/selectPokemon.feature"
)
public class SelectPokemonSuccessTest {

}
