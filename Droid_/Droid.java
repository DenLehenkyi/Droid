package Droid;

import java.util.AbstractList;
import java.util.ArrayList;

public class Droid {
    private String name;
    private int health;
    private int damage;
    private int armor;
    private String droid_type;

    public Droid() {
        this.health = 0;
        this.damage = 0;
        this.armor = 0;
    }

    public Droid(Droid droid) {
        this.droid_type = droid.getDroid_type();
        this.name = droid.getName();
        this.health = droid.getHealth();
        this.armor = droid.getArmor();
        this.damage = droid.getDamage();
    }


    public Droid(String name) {
        this.name = name;
        this.health = 150;
        this.damage = 14;
        this.armor = 100;
    }

    public void fight(Droid enemy_droid) {
        this.health = Math.abs(health) - enemy_droid.damage;
        this.armor -= enemy_droid.getArmor() / 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public String getDroid_type() {
        return droid_type;
    }

    public void setDroid_type(String droid_type) {
        this.droid_type = droid_type;
    }

    @Override
    public String toString() {
        return "Тип дроїда - " + getDroid_type() + '.' + "\n" +
                "Ім'я дроїда - " + getName() + '.' + "\n" +
                "Здоров'я - " + getHealth() + '.' + "\n" +
                "Шкода - " + getDamage() + '.' + "\n" +
                "Броня - " + getArmor() + "." + "\n";
    }
}
