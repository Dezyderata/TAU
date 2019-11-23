package com.mycompany.app;

public class Pokemon {
    protected String name;
    protected int combatPower;
    protected int maxHealthPoints;
    protected int attack;
    protected int defence;
    protected int stamina;
    protected int health;

    public Pokemon(){

    }
    public Pokemon(String name){
        this.name = name;
    }

    public Pokemon(String name, int combatPower, int maxHealthPoints, int attack, int defence, int stamina){
        this.name = name;
        this.combatPower = combatPower;
        this.maxHealthPoints = maxHealthPoints;
        this.attack = attack;
        this.defence = defence;
        this.stamina = stamina;
        this.health = 100;
    }

    public String getName() {
        return name;
    }


    public int getCombatPower() {
        return combatPower;
    }

    public int getHealth() {
        return health;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }


    public int getAttack() {
        return attack;
    }


    public int getDefence() {
        return defence;
    }

    public int getStamina() {
        return stamina;
    }



    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                '}';
    }
}
