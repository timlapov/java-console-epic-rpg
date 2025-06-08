package art.lapov.rpg.characters;

/**
 * Enemy class representing all hostile characters in the game.
 * Extends Character with enemy-specific display formatting.
 */
public class Enemy extends Character {

    /**
     * Constructor for creating an enemy with specified stats.
     * @param name Enemy's name
     * @param healthPoints Starting health points
     * @param defense Defense rating
     * @param attack Attack power
     */
    public Enemy(String name, int healthPoints, int defense, int attack) {
        super(name, healthPoints, defense, attack);
    }

    @Override
    public String toString() {
        return "Enemy: " + super.toString();
    }
}
