package art.lapov.rpg.characters;

/**
 * Abstract base class for all characters in the RPG game.
 * Provides common functionality for heroes and enemies including
 * combat mechanics, health management, and basic stats.
 */
public abstract class Character {
    private String name;        // Character's name
    private int healthPoints;   // Current health points
    private int defense;        // Defense rating (reduces incoming damage)
    private int attack;         // Attack power

    /**
     * Constructor for creating a character with specified stats.
     * @param name Character's name
     * @param healthPoints Starting health points
     * @param defense Defense rating
     * @param attack Attack power
     */
    public Character(String name, int healthPoints, int defense, int attack) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
    }

    /**
     * Performs a basic attack against the target character.
     * @param target The character to attack
     */
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.takeDamage(attack);
        try {
            Thread.sleep(1000); // Brief pause for better user experience
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Applies damage to this character, accounting for defense.
     * @param damage The raw damage amount before defense calculation
     */
    public void takeDamage(int damage) {
        int effectiveDamage = damage - defense;
        if (effectiveDamage < 0) {
            effectiveDamage = 0; // Cannot heal from negative damage
        }
        healthPoints -= effectiveDamage;
        System.out.println(name + " takes " + effectiveDamage + " damage! Remaining HP: " + healthPoints);

        if (healthPoints <= 0) {
            System.out.println("😵 " + name + " has been defeated");
        }
    }

    /**
     * Checks if the character is still alive.
     * @return true if health points > 0, false otherwise
     */
    public boolean isAlive() {
        return healthPoints > 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return name + "  ♥️" + healthPoints + "  🛡️" + defense + "  🗡️" + attack;
    }
}
