package be.cegeka.battle;

import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Weapon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Soldier {

    private final String name;
    private Weapon weapon;
    private boolean isDead;

    public Soldier(String name) {
        this(name, new BareFist());
    }

    public Soldier(String name, Weapon weapon) {
        this.name = name;
        this.isDead = false;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public Soldier fight(Soldier opponent) {
        if(weapon.getDamage() > opponent.weapon.getDamage()) {
            opponent.die();
            return this;
        } else if(weapon.getDamage() < opponent.weapon.getDamage()) {
            this.die();
            return opponent;
        }
        return this;
    }

    private void die() {
        this.isDead = true;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean isAlive() {
        return !isDead();
    }
}
