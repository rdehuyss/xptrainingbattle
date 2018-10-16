package be.cegeka.battle;

import be.cegeka.battle.Soldier;
import be.cegeka.battle.weapon.Axe;
import be.cegeka.battle.weapon.BareFist;
import be.cegeka.battle.weapon.Sword;
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
    public void fight_AxeWinsFromSword()
    {
        Soldier soldierWithAxe = new Soldier("soldierWithAxe", new Axe());
        Soldier soldierWithSword = new Soldier("soldierWithSword", new Sword());

        Soldier winner = soldierWithAxe.fight(soldierWithSword);
        assertThat(winner).isEqualTo(soldierWithAxe);
    }

    @Test
    public void fight_SameWeapon_AttackerWins()
    {
        Soldier soldier1 = new Soldier("soldier1", new Axe());
        Soldier soldier2 = new Soldier("soldier2", new Axe());

        Soldier winner = soldier1.fight(soldier2);
        assertThat(winner).isEqualTo(soldier1);
    }

    @Test
    public void soldierHasName() {
        Soldier alice = new Soldier("alice");
        assertThat(alice.getName()).isNotNull();
    }

}
