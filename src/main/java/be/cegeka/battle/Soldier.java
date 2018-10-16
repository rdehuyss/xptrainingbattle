package be.cegeka.battle;

import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Weapon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Soldier {

    private final String name;
    private Weapon weapon;

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
        return null;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
