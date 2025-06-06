package art.lapov.rpg.characters;

public class Goblin extends Enemy {
    public Goblin() {
        super("Goblin", 40, 10, 10);
    }

    @Override
    public String toString() {
        return "Goblin{ " + super.toString() + " }";
    }
}
