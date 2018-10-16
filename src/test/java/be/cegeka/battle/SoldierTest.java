package be.cegeka.battle;

import be.cegeka.battle.weapon.Axe;
import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Sword;
import org.junit.Test;

import static be.cegeka.battle.SoldierTestBuilder.aSoldierWithASword;
import static be.cegeka.battle.SoldierTestBuilder.aSoldierWithAnAxe;
import static org.assertj.core.api.Assertions.assertThat;

public class SoldierTest {

    @Test
    public void SolderHasBareFistWeaponByDefault()
    {
        Soldier soldier = new Soldier("name");

        assertThat(soldier.getWeapon()).isInstanceOf(BareFist.class);
    }

    @Test
    public void fight_AxeWinsFromSword()
    {
        Soldier soldierWithAxe = aSoldierWithAnAxe().build();
        Soldier soldierWithSword = aSoldierWithASword().build();

        Soldier winner = soldierWithAxe.fight(soldierWithSword);
        assertThat(winner).isEqualTo(soldierWithAxe);
        assertThat(winner.isAlive()).isTrue();
        assertThat(soldierWithSword.isAlive()).isFalse();
    }

    @Test
    public void fight_SameWeapon_AttackerWins()
    {
        Soldier soldier1 = aSoldierWithAnAxe().build();
        Soldier soldier2 = aSoldierWithAnAxe().build();

        Soldier winner = soldier1.fight(soldier2);
        assertThat(winner).isEqualTo(soldier1);
        assertThat(winner.isAlive()).isTrue();
        assertThat(soldier2.isAlive()).isFalse();
    }

    @Test
    public void soldierHasName() {
        Soldier alice = new Soldier("alice");
        assertThat(alice.getName()).isNotNull();
    }

}
