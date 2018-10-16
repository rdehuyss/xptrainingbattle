package be.cegeka.battle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static be.cegeka.battle.ArmyTestBuilder.*;
import static be.cegeka.battle.SoldierTestBuilder.*;
import static be.cegeka.battle.SoldierTestBuilder.aSoldierWithAnAxe;
import static be.cegeka.battle.SoldierTestBuilder.aSoldierWithBareFists;
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
        Army strongestArmy = aDefaultArmy()
                .withSoldiers(aSoldierWithAnAxe())
                .build();

        Army weakestArmy = aDefaultArmy()
                .withSoldiers(aSoldierWithBareFists())
                .build();

        //when
        Army winningArmy = strongestArmy.engageInWarWith(weakestArmy);

        // then
        assertThat(winningArmy).isEqualTo(strongestArmy);
        assertThat(winningArmy.getSoldiers()).hasSize(1);
        assertThat(weakestArmy.getSoldiers()).isEmpty();
    }

    @Test
    public void givenTwoArmiesWithUnevenAmoutOfSoldiers_WhoEngageInWar_StrongestArmyWins() {
        // given
        Army strongestArmy = aDefaultArmy()
                .withSoldiers(
                        aSoldierWithASword(),
                        aSoldierWithAnAxe()
                        )
                .build();

        Army weakestArmy = aDefaultArmy()
                .withSoldiers(
                        aSoldierWithAnAxe(),
                        aSoldierWithBareFists())
                .build();

        //when
        Army winningArmy = strongestArmy.engageInWarWith(weakestArmy);

        // then
        assertThat(winningArmy).isEqualTo(strongestArmy);
        assertThat(winningArmy.getSoldiers()).hasSize(1);
        assertThat(weakestArmy.getSoldiers()).isEmpty();
    }

    @Test
    public void givenTwoArmiesWithUnevenAmoutOfSoldiers_WhoEngageInWar_ObviouslyStrongestArmyWins() {
        // given
        Army strongestArmy = aDefaultArmy()
                .withSoldiers(
                        aSoldierWithAnAxe(),
                        aSoldierWithAnAxe()
                        )
                .build();

        Army weakestArmy = aDefaultArmy()
                .withSoldiers(
                        aSoldierWithASword(),
                        aSoldierWithBareFists())
                .build();

        //when
        Army winningArmy = strongestArmy.engageInWarWith(weakestArmy);

        // then
        assertThat(winningArmy).isEqualTo(strongestArmy);
        assertThat(winningArmy.getSoldiers()).hasSize(2);
        assertThat(weakestArmy.getSoldiers()).isEmpty();
    }
}