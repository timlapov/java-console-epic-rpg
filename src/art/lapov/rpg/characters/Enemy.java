package art.lapov.rpg.characters;

public class Enemy extends Character {

    public Enemy(String name, int healthPoints, int defense, int attack) {
        super(name, healthPoints, defense, attack);
    }

    @Override
    public String toString() {
        return "Enemy{ " + super.toString() + " }";
    }
}
