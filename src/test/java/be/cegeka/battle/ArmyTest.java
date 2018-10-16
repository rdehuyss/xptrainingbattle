package be.cegeka.battle;

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
        assertThat(army.getSoldiers().get(0)).isEqualTo(alice);
    }
}