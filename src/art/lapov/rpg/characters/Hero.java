package art.lapov.rpg.characters;

import art.lapov.rpg.interfaces.SpecialAbility;

public class Hero extends Character implements SpecialAbility {

    private int mana;
    private int healthPoitons;
    private int victories;

    public Hero(String name, int healthPoints, int defense, int mana, int attack) {
        super(name, healthPoints, defense, attack);
        this.mana = mana;
        this.healthPoitons = 1;
        this.victories = 0;
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

    public int getHealthPoitons() {
        return healthPoitons;
    }

    public void setHealthPoitons(int healthPoitons) {
        this.healthPoitons = healthPoitons;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    @Override
    public String toString() {

        return "Hero: " + super.toString() + " | victories: " + victories + " | mana: " + mana + " | poitons: " + healthPoitons;
    }

}
