package be.cegeka.battle.weapon;

import be.cegeka.battle.weapon.Axe;
import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Spear;
import be.cegeka.battle.weapon.Sword;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WeaponTest {

    @Test
    public void axeHasDamage3() {
        assertThat(new Axe().getDamage()).isEqualTo(3);
    }
    @Test
    public void SwordHasDamage2() {
        assertThat(new Sword().getDamage()).isEqualTo(2);
    }
    @Test
    public void SpearHasDamage2() {
        assertThat(new Spear().getDamage()).isEqualTo(2);
    }

    @Test
    public void BareFistHasDamage1() {
        assertThat(new BareFist().getDamage()).isEqualTo(1);
    }
}
