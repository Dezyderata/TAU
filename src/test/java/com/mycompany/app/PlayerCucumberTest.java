package com.mycompany.app;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber"},
        features = "classpath:player/findInPlayer.feature"
)
public class PlayerCucumberTest {

}
