package com.mycompany.app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@failure",
        features = "classpath:player/setPokemonFree.feature"
)
public class SetPokemonFreeWrongValuesTest {
}
