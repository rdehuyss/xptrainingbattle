package be.cegeka.battle;

import be.cegeka.battle.weapon.Axe;
import be.cegeka.battle.weapon.BareFist;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ArmyTest {

    @Mock
    IHeadquarters hq;

    @Test
    public void canEnrollSoldierInArmy() {
        Soldier alice = new Soldier("alice");
        Army army = new Army(hq);

        army.enroll(alice);

        assertThat(army.getSoldiers()).isNotNull();
    }

    @Test
    public void givenArmyWithSoldiers_thenFrontManIsFirstEnlistedSoldier() {
        // given
        Soldier alice = new Soldier("Alice");
        Soldier bob = new Soldier("Bob");
        Soldier cath = new Soldier("Cath");
        Army army = new Army(hq);

        // when
        army.enroll(alice);
        army.enroll(bob);
        army.enroll(cath);

        // then
        assertThat(army.getFrontMan()).isEqualTo(alice);
    }

    @Test
    public void givenArmyWithNoSoldiers_thenFrontManIsNull() {
        // given
        Army army = new Army(hq);

        // then
        assertThat(army.getFrontMan()).isNull();
    }

    @Test
    public void givenTwoArmiesWithOneSoldier_WhoEngageInWar_StrongestOneWins() {
        // given
        Soldier strongestSoldier = new Soldier("", new Axe());
        Army strongestArmy = new Army(hq);
        strongestArmy.enroll(strongestSoldier);

        Soldier weakestSoldier = new Soldier("", new BareFist());
        Army weakestArmy = new Army(hq);
        weakestArmy.enroll(weakestSoldier);

        //when
        Army winningArmy = strongestArmy.engageInWarWith(weakestArmy);

        // then
        assertThat(winningArmy).isEqualTo(strongestArmy);
        assertThat(winningArmy.getSoldiers()).containsOnly(strongestSoldier);
        assertThat(strongestSoldier.isDead()).isFalse();
        assertThat(weakestArmy.getSoldiers()).isEmpty();
        assertThat(weakestSoldier.isDead()).isTrue();
    }
}