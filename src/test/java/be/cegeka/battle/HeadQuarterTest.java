package be.cegeka.battle;

import be.cegeka.battle.weapon.HeadQuarters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static be.cegeka.battle.ArmyTestBuilder.aDefaultArmy;
import static be.cegeka.battle.SoldierTestBuilder.aSoldierWithAnAxe;
import static be.cegeka.battle.SoldierTestBuilder.aSoldierWithBareFists;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class HeadQuarterTest {

    @Mock
    IHeadquarters hq;
    @Mock
    Soldier soldier;

    @Test
    public void givenSoldierEnlistment_thenReportedToHQ() {
        Soldier alice = new Soldier("Alice");
        Army army = new Army(hq);

        army.enroll(alice);

        verify(hq).reportEnlistment("Alice");
    }

    @Test
    public void givenEnlistedSoldier_soldierIsAssignedId() {
        IHeadquarters hq = new HeadQuarters();
        Army army = new Army(hq);

        army.enroll(soldier);

        verify(soldier).setId(5);
    }

    @Test
    public void givenSoldierDies_thenReportedToHQ() {
        Soldier alice = new Soldier("Alice");
        Army army = new Army(hq);

        army.enroll(alice);

        alice.die();

        army.reportDeath();

        verify(hq).reportCasualty(alice.getId());
    }

    @Test
    public void givenArmyHasWon_victoryIsReported() {
        // given
        Army strongestArmy = aDefaultArmy()
                .withHQ(hq)
                .withSoldiers(aSoldierWithAnAxe(), aSoldierWithBareFists())
                .build();

        Army weakestArmy = aDefaultArmy()
                .withSoldiers(aSoldierWithBareFists())
                .build();

        //when
        strongestArmy.engageInWarWith(weakestArmy);

        // then
        verify(hq).reportVictory(2);
    }
}
