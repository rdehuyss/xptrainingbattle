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

    public Army engageInWarWith(Army opponent) {
        Soldier frontman1 = this.getFrontMan();
        Soldier frontman2 = opponent.getFrontMan();

            Soldier winner = frontman1.fight(frontman2);
            if(winner == frontman1) {
                opponent.removeAndBurnDeadSoldiersFromArmy();
                return this;
            } else {
                this.removeAndBurnDeadSoldiersFromArmy();
                return opponent;
            }


    }

    private void removeAndBurnDeadSoldiersFromArmy() {
        this.soldiers.removeIf(x -> x.isDead());
    }
}

