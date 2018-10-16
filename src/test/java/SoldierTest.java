import be.cegeka.battle.Soldier;
import be.cegeka.battle.weapon.BareFist;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void SolderHasBareFistWeaponByDefault()
    {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getWeapon()).isInstanceOf(BareFist.class);
    }

    @Test
    public void soldierHasName() {
        Soldier alice = new Soldier("alice");
        assertThat(alice.getName()).isNotNull();
    }



}
