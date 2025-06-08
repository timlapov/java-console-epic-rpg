package art.lapov.rpg.characters;

import art.lapov.rpg.interfaces.SpecialAbility;

import java.util.Random;

/**
 * Hero class representing the player character with special abilities,
 * mana system, health potions, and victory tracking.
 */
public class Hero extends Character implements SpecialAbility {

    private int mana;           // Magical energy used for special abilities
    private int healthPotions;  // Number of healing potions available
    private int victories;      // Count of defeated enemies

    /**
     * Constructor for creating a new hero with specified stats.
     * @param name Hero's name
     * @param healthPoints Starting health points
     * @param defense Defense rating
     * @param mana Starting mana points
     * @param attack Attack power
     */
    public Hero(String name, int healthPoints, int defense, int mana, int attack) {
        super(name, healthPoints, defense, attack);
        this.mana = mana;
        this.healthPotions = 1;  // Start with one health potion
        this.victories = 0;      // Start with no victories
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

    /**
     * Uses a health potion to restore health. Deducts one potion from inventory.
     * Healing amount is random between 5-25 HP.
     */
    public void useHealthPotion() {
        if (healthPotions <= 0) {
            System.out.println("⏭️ No health potions available! You skip your turn.");
            return;
        }
        healthPotions--;
        Random random = new Random();
        int healAmount = random.nextInt(21) + 5; // Random healing: 5-25 HP
        System.out.println("+ " + healAmount + "♥️");
        this.setHealthPoints(getHealthPoints() + healAmount);
    }

    /**
     * Increments victory count and provides rewards for defeating an enemy.
     * Rewards include: +1 health potion and +5 mana restoration.
     */
    public void addVictory() {
        victories++;
        healthPotions++;  // Reward: gain a health potion
        mana += 5;        // Reward: restore some mana
        System.out.println("Victory! You now have " + victories + "🏆 and gained a health potion!");
    }

    /**
     * Uses the hero's special ability - a powerful fireball attack.
     * Costs 10 mana and deals 2-3x normal attack damage.
     * @param target The character to attack with the special ability
     */
    @Override
    public void useSpecialAbility(Character target) {
        if (mana >= 10 ) {
            this.mana -= 10; // Deduct mana cost
            int random = new Random().nextInt(2);
            int increasedDamage = this.getAttack() * (random + 2); // 2-3x damage multiplier
            System.out.println("🔥 You attacked with a fireball of damage: " + increasedDamage);
            target.takeDamage(increasedDamage);
            try {
                Thread.sleep(1000); // Brief pause for dramatic effect
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
