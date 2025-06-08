package art.lapov.rpg.characters;

public abstract class Character {
    private String name;
    private int healthPoints;
    private int defense;
    private int attack;

    public Character(String name, int healthPoints, int defense, int attack) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.defense = defense;
        this.attack = attack;
    }

    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + "!");
        target.takeDamage(attack);
        try {
            Thread.sleep(1000); // 1 second pause for better UX
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void takeDamage(int damage) {
        int effectiveDamage = damage - defense;
        if (effectiveDamage < 0) {
            effectiveDamage = 0;
        }
        healthPoints -= effectiveDamage;
        System.out.println(name + " takes " + effectiveDamage + " damage! Remaining HP: " + healthPoints);

        if (healthPoints <= 0) {
            System.out.println("😵 " + name + " has been defeated");
        }
    }

    public boolean isAlive() {
        return (healthPoints) > 0;
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
