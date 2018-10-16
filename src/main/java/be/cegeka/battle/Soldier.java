package be.cegeka.battle;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Soldier {

    private final String name;

    public Soldier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Soldier fight(Soldier opponent) {
        throw new NotImplementedException();
    }
}
