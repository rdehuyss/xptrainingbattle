package be.cegeka.battle;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class ArmyTest {

    @Test
    public void canEnrollSoldierInArmy() {
        Soldier alice = new Soldier("alice");
        Army army = new Army();

        army.enroll(alice);

        assertThat(army.getSoldiers()).isNotNull();
    }

    @Test
    public void givenArmyWithSoldiers_thenFrontManIsFirstEnlistedSoldier() {
        // given
        Soldier alice = new Soldier("Alice");
        Soldier bob = new Soldier("Bob");
        Soldier cath = new Soldier("Cath");
        Army army = new Army();

        // when
        army.enroll(alice);
        army.enroll(bob);
        army.enroll(cath);

        // then
        assertThat(army.getSoldiers().get(0)).isEqualTo(alice);
    }
}