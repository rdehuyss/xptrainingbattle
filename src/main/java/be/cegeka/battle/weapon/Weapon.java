package be.cegeka.battle.weapon;

public abstract class Weapon {

    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
