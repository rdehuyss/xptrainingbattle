package be.cegeka.battle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Army {

    private IHeadquarters hq;

    public Army(IHeadquarters hq) {
        this.hq = hq;
    }

    private List<Soldier> soldiers = new ArrayList<>();

    public void enroll(Soldier soldier) {
        soldier.setId(hq.reportEnlistment(soldier.getName()));
        soldiers.add(soldier);
    }

    public List getSoldiers() {
        return Collections.unmodifiableList(soldiers);
    }
}

