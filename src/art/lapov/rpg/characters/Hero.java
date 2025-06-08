package art.lapov.rpg.characters;

import art.lapov.rpg.interfaces.SpecialAbility;

import java.util.Random;

public class Hero extends Character implements SpecialAbility {

    private int mana;
    private int healthPotions;
    private int victories;

    public Hero(String name, int healthPoints, int defense, int mana, int attack) {
        super(name, healthPoints, defense, attack);
        this.mana = mana;
        this.healthPotions = 1;
        this.victories = 0;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getHealthPotions() {
        return healthPotions;
    }

    public void setHealthPotions(int healthPotions) {
        this.healthPotions = healthPotions;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public boolean useHealthPotion() {
        if (healthPotions <= 0) {
            System.out.println("No health potions available! You skip your turn.");
            return false;
        }

        healthPotions--;
        Random random = new Random();
        int healAmount = random.nextInt(21) + 5; // 10-25 HP healing
        this.setHealthPoints(getHealthPoints() + healAmount);
        return true;
    }

    public void addVictory() {
        victories++;
        // Get a new potion after each victory
        healthPotions++;
        // Restore some mana
        mana += 3;
        System.out.println("Victory! You now have " + victories + " victories and gained a health potion!");
    }

    @Override
    public void useSpecialAbility(Character target) {
        if (mana >= 10 ) {
            this.mana -= 10;
            int random = new Random().nextInt(2);
            int increasedDamage = this.getAttack() * (random + 2);
            System.out.println("🔥 You attacked with a fireball of damage: " + increasedDamage);
            target.takeDamage(increasedDamage);
            try {
                Thread.sleep(1000); // 1 second pause for better UX
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } else {
            System.out.println("🤬 No cheating!!! You don't have enough mana. You're missing a move.");
        }
    }

    @Override
    public String toString() {
        return "Hero: " + super.toString() + "  ✨" + mana + "  🧪" + healthPotions + "  🏆" + victories;
    }

}
