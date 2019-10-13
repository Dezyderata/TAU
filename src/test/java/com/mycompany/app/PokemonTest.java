package com.mycompany.app;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PokemonTest {

    @Test
    public void isPokemonClassIsImplementedTest(){
        Assert.assertNotNull(new Pokemon());
    }

    @Test
    public void isPokemonClassWithAttributesPosible(){
        Assert.assertNotNull(new Pokemon("Slaking",4431,233, 290, 166,284));
    }


}

