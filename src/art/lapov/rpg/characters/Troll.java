package art.lapov.rpg.characters;

public class Troll extends Enemy {

    public Troll() {
        super("Troll", 25, 5, 15);
    }

    @Override
    public String toString() {
        return "Troll{ " + super.toString() + " }";
    }

}
