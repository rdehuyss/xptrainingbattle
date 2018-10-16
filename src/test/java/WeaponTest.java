import be.cegeka.battle.weapon.Axe;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {

    @Test
    public void axeHasDamage3() {
        assertThat(new Axe().getDamage()).isEqualTo(3);
    }
}
