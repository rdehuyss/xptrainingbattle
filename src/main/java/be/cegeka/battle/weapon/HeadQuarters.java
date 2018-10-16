package be.cegeka.battle.weapon;

import be.cegeka.battle.IHeadquarters;

public class HeadQuarters implements IHeadquarters {

    @Override
    public int reportEnlistment(String soldierName) {
        return 5;
    }

    @Override
    public void reportCasualty(int soldierId) {

    }

    @Override
    public void reportVictory(int remainingNumberOfSoldiers) {

    }
}
