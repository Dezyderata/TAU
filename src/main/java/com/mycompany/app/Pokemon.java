package com.mycompany.app;

public class Pokemon {
    protected String name;
    protected int combatPower;
    protected int maxHealthPoints;
    protected int attack;
    protected int defence;
    protected int stamina;

    public Pokemon(){

    }

    public Pokemon(String name, int combatPower, int maxHealthPoints, int attack, int defence, int stamina){
        this.name = name;
        this.combatPower = combatPower;
        this.combatPower = combatPower;
        this.maxHealthPoints = maxHealthPoints;
        this.attack = attack;
        this.defence = defence;
        this.stamina = stamina;
    }
}
