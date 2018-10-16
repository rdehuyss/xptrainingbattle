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

        if(frontman == null)
        {
            opposingArmy.getHeadquarters().reportVictory(opposingArmy.getNumberOfAliveSoldiers());
            return opposingArmy;
        }
        else if (opposingFrontman == null)
        {
            this.getHeadquarters().reportVictory(this.getNumberOfAliveSoldiers());
            return this;
        }
        else {
            frontman.fight(opposingFrontman);
            this.reportAndRemoveDeadSoldiersFromArmy();
            opposingArmy.reportAndRemoveDeadSoldiersFromArmy();

            return engageInWarWith(opposingArmy);
        }
    }

    public IHeadquarters getHeadquarters() {
        return hq;
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

    public int getNumberOfAliveSoldiers() {
        return (int) soldiers.stream()
                .filter(Soldier::isAlive)
                .count();
    }
}

