package com.lutemonfighter;

public class Lutemon {
    protected String name;
    protected String type;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;

    public Lutemon(String name, String type, int attack, int defense, int experience, int health, int maxHealth) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        id = (int)(Math.random() * 90000 + 1000);
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getExperience() {
        return experience;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getId() {
        return id;
    }
}

// EOF
