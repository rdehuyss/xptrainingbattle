package be.cegeka.battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {

    private List<Soldier> soldiers = new ArrayList<>();

    public void enroll(Soldier soldier) {
        soldiers.add(soldier);
    }

    public List getSoldiers() {
        return Collections.unmodifiableList(soldiers);
    }
}

