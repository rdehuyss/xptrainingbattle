package be.cegeka.battle;

import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Weapon;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Soldier {

    private Weapon weapon;

    public Soldier() {
        this(new BareFist());
    }

    public Soldier(Weapon weapon) {
        this.weapon = weapon;
    }

    public Soldier fight(Soldier opponent) {
        return null;
    }

    public Weapon getWeapon() {
        return weapon;
    }
}
