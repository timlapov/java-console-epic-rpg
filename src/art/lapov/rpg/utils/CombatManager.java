package art.lapov.rpg.utils;

import art.lapov.rpg.characters.Dragon;
import art.lapov.rpg.characters.Enemy;
import art.lapov.rpg.characters.Goblin;
import art.lapov.rpg.characters.Hero;
import art.lapov.rpg.characters.Troll;
import art.lapov.rpg.enums.HeroActions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * CombatManager handles all game logic including character creation,
 * combat mechanics, user input, and game result management.
 */
public class CombatManager {

    // Random number generator for various game mechanics
    private final Random random = new Random();

    /**
     * Factory method to create a hero based on character class choice.
     * @param name Hero's name
     * @param choice Character class (1=Warrior, 2=Mage, 3=Ninja)
     * @return A new Hero instance with appropriate stats
     */
    public Hero createHero(String name, int choice) {
        switch (choice) {
            case 1 -> {
                return new Hero(name, 95, 6, 15, 22);  // Warrior: high HP/defense
            }
            case 2 -> {
                return new Hero(name, 85, 4, 45, 18);   // Mage: high mana/low defense
            }
            default -> {
                return new Hero(name, 90, 5, 20, 20);   // Ninja: balanced stats
            }
        }
    }

    /**
     * Factory method to create a random enemy for battle.
     * Trolls appear more frequently as base enemies.
     * @return A new Enemy instance (Goblin, Dragon, or Troll)
     */
    public Enemy createEnemy() {
        int randomNumber = this.random.nextInt(5);  // Weighted random selection
        switch (randomNumber) {
            case 1 -> {
                return new Goblin();  // Weak enemy
            }
            case 2 -> {
                return new Dragon();  // Strong boss enemy
            }
            default -> {
                return new Troll();   // Standard enemy (60% chance)
            }
        }
    }
    /**
     * Displays the current battle status showing both hero and enemy stats.
     * @param hero The player's hero
     * @param enemy The current enemy
     */
    public void showGameInfo(Hero hero, Enemy enemy) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("⚔️  BATTLE STATUS  ⚔️");
        System.out.println("=".repeat(50));
        System.out.println(hero);
        System.out.println("🔻 VS 🔻");
        System.out.println(enemy);
        System.out.println("=".repeat(50));
    }

    /**
     * Processes the player's chosen action during combat.
     * @param action The selected hero action
     * @param hero The player's hero
     * @param enemy The current enemy
     */
    public void heroActionProcessing(HeroActions action, Hero hero, Enemy enemy) {
        switch (action) {
            case ATTACK -> hero.attack(enemy);
            case USE_SPECIAL_ABILITY -> hero.useSpecialAbility(enemy);
            case POTION -> hero.useHealthPotion();
            default -> System.out.println("⏭️ You missed the action. Prepare to attack.");
        }
    }

    /**
     * Prompts the player to choose an action and handles input validation.
     * @return The selected HeroAction
     */
    public HeroActions askHeroAboutAction() {
        System.out.println("\n🎯 Choose your action:");
        HeroActions[] actions = HeroActions.values();
        
        // Display available actions
        for (int i = 0; i < actions.length; i++) {
            System.out.println((i + 1) + ". " + actions[i].getDisplayName());
        }

        Scanner sc = new Scanner(System.in);

        // Input validation loop
        while (true) {
            try {
                System.out.println("Enter the number:");
                int number = sc.nextInt();

                if (number < 1 || number > actions.length) {
                    throw new IllegalArgumentException("❌ Invalid choice: number must be between 1 and " + actions.length);
                }
                return actions[number - 1];

            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid number. Please try again.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Saves the game results to a text file with timestamp and victory count.
     * @param hero The hero whose results should be saved
     */
    public void saveGameResults(Hero hero) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("scores.txt", true))) {
            // Format: timestamp | hero_name defeated X enemies/enemy
            String enemyText = (hero.getVictories() != 1) ? " enemies" : " enemy";
            String line = LocalDateTime.now() + " | " + hero.getName() + " defeated " + hero.getVictories() + enemyText;
            writer.write(line);
            writer.newLine();
            System.out.println("✅ Game results saved to scores.txt");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Displays the final game results with performance evaluation.
     * @param hero The hero whose results should be displayed
     */
    public void displayGameResults(Hero hero) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("🏆 GAME OVER 🏆");
        System.out.println("=".repeat(50));
        System.out.println("Hero: " + hero.getName());
        System.out.println("Enemies defeated: " + hero.getVictories());

        // Performance-based messages
        if (hero.getVictories() == 0) {
            System.out.println("💔 Better luck next time!");
        } else if (hero.getVictories() < 5) {
            System.out.println("👍 Not bad for a beginner!");
        } else if (hero.getVictories() < 10) {
            System.out.println("⭐ Good job, warrior!");
        } else {
            System.out.println("🌟 Legendary performance!");
        }

        System.out.println("=".repeat(50));
    }

}
