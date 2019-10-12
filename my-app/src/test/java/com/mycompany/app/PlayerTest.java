package com.mycompany.app;


import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PlayerTest {

    @Test
    public void isPlayerClassIsImplementedTest(){
        Assert.assertNotNull(new Player());
    }

    @Test
    public void creationPlayerWithNameTest(){
        Assert.assertNotNull(new Player("Janek"));
    }

}
