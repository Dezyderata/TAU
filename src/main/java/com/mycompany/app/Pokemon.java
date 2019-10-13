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
        this.maxHealthPoints = maxHealthPoints;
        this.attack = attack;
        this.defence = defence;
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCombatPower() {
        return combatPower;
    }

    public void setCombatPower(int combatPower) {
        this.combatPower = combatPower;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                '}';
    }
}
