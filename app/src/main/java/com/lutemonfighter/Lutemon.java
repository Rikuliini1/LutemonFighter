package com.lutemonfighter;

import java.io.Serializable;

public class Lutemon implements Serializable {
    protected String name;
    protected String type;
    protected int attack;
    protected int defense;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected int id;
    protected int lutemonTypeIcon;
    protected int lutemonDeleteIcon;



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

    public int getLutemonTypeIcon() {
        return lutemonTypeIcon;
    }
    public int getLutemonDeleteIcon() {
        return lutemonDeleteIcon;


    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setId(int id) {
        this.id = id;

    }
}

// EOF
