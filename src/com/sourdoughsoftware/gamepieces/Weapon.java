package com.sourdoughsoftware.gamepieces;

public class Weapon extends Item{
    private int attackPoints;
    private String victory;
    public Weapon(String name, String description, int attackPoints, String victory) {
        super(name, description);
        this.attackPoints = attackPoints;
        this.victory = victory;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public String getVictory() {
        return this.victory;
    }
}