package art.lapov.rpg.characters;

import art.lapov.rpg.interfaces.SpecialAbility;

public class Hero extends Character implements SpecialAbility {

    private int mana;

    public Hero(String name, int healthPoints, int defense, int mana, int attack) {
        super(name, healthPoints, defense, attack);
        this.mana = mana;
    }

    @Override
    public void useSpecialAbility(java.lang.Character target) {

    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public String toString() {

        return "Hero{" + super.toString() + " | mana: " + mana + '}';
    }

}
