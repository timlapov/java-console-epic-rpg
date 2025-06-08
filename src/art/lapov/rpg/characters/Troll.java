package art.lapov.rpg.characters;

/**
 * Troll enemy - the standard/base enemy type.
 * Stats: 40 HP, 5 Defense, 10 Attack
 * Most commonly encountered enemy (60% spawn rate).
 */
public class Troll extends Enemy {
    public Troll() {
        super("Troll", 40, 5, 10);
    }
}
