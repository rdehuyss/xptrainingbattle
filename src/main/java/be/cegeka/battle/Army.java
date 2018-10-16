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

    public Soldier getFrontMan() {
        if(soldiers.isEmpty())
            return null;

        return soldiers.get(0);
    }

    public Army engageInWarWith(Army opposingArmy) {
        Soldier frontman = this.getFrontMan();
        Soldier opposingFrontman = opposingArmy.getFrontMan();

            Soldier winner = frontman.fight(opposingFrontman);
            if(winner == frontman) {
                opposingArmy.reportAndRemoveDeadSoldiersFromArmy();
                return this;
            } else {
                this.reportAndRemoveDeadSoldiersFromArmy();
                return opposingArmy;
            }


    }

    private void reportAndRemoveDeadSoldiersFromArmy() {
        reportDeath();
        soldiers.removeIf(Soldier::isDead);
    }

    public void reportDeath() {
        soldiers.stream()
                .filter(Soldier::isDead)
                .mapToInt(Soldier::getId)
                .forEach(hq::reportCasualty);
    }
}

