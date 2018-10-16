package be.cegeka.battle;

import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Weapon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Soldier {

    private final String name;
    private Weapon weapon;
    private int id;

    public Soldier(String name) {
        this(name, new BareFist());
    }

    public Soldier(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public Soldier fight(Soldier opponent) {
        if(weapon.getDamage() > opponent.weapon.getDamage()) {
            return this;
        } else if(weapon.getDamage() < opponent.weapon.getDamage()) {
            return opponent;
        }
        return this;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
