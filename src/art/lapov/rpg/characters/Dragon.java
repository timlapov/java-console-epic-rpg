package art.lapov.rpg.characters;

/**
 * Dragon enemy - the most powerful boss enemy.
 * Stats: 60 HP, 10 Defense, 25 Attack
 * High damage output makes it a challenging opponent.
 */
public class Dragon extends Enemy {
    public Dragon() {
        super("Dragon", 60, 10, 25);
    }
}
