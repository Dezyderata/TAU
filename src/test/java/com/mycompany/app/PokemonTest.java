package com.mycompany.app;

import com.mycompany.app.domain.Pokemon;
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
    public void isPokemonClassWithAttributesPossibleTest(){
        Assert.assertNotNull(new Pokemon("Slaking",4431,233, 290, 166,284));
    }
    @Test
    public void attributesCheckTest(){
        Pokemon slaking = new Pokemon("Slaking",4431,233, 290, 166,284);
        Assert.assertEquals(4431, slaking.getCombatPower());
        Assert.assertEquals(233, slaking.getMaxHealthPoints());
        Assert.assertEquals(290, slaking.getAttack());
        Assert.assertEquals(166, slaking.getDefence());
        Assert.assertEquals(284, slaking.getStamina());

    }
    @Test
    public void toStringMethodTest(){
        Pokemon wishiwashi = new Pokemon("Wishiwashi",0,0, 0, 0,0);
        Assert.assertEquals("Pokemon{name='Wishiwashi'}", wishiwashi.toString());
    }



}

