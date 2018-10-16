package be.cegeka.battle;

import be.cegeka.battle.weapon.Axe;
import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Sword;
import be.cegeka.battle.weapon.Weapon;

public class SoldierTestBuilder {

    private String name;
    private Weapon weapon;

    private SoldierTestBuilder() {

    }

    public static SoldierTestBuilder aDefaultSoldier(){
        return new SoldierTestBuilder()
                .withName("PsychoPath");
    }


    public static SoldierTestBuilder aSoldierWithAnAxe(){
        return aDefaultSoldier()
                .withWeapon(new Axe());
    }

    public static SoldierTestBuilder aSoldierWithASword(){
        return aDefaultSoldier()
                .withWeapon(new Sword());
    }

    public static SoldierTestBuilder aSoldierWithBareFists(){
        return aDefaultSoldier()
                .withWeapon(new BareFist());
    }

    private SoldierTestBuilder withName(String name) {
        this.name = name;
        return this;
    }

    private SoldierTestBuilder withWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
    }

    public Soldier build(){
        return new Soldier(name, weapon);
    }
}
