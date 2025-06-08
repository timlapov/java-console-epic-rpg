package art.lapov.rpg;

import art.lapov.rpg.characters.Enemy;
import art.lapov.rpg.characters.Hero;
import art.lapov.rpg.enums.HeroActions;
import art.lapov.rpg.exceptions.HeroOutOfRangeException;
import art.lapov.rpg.utils.CombatManager;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class that serves as the entry point for the Epic Console RPG game.
 * Handles the game initialization, main game loop, and user interactions.
 */
public class Main {

    // Scanner for reading user input throughout the game
    private static final Scanner sc = new Scanner(System.in);

    /**
     * Main method that initializes and runs the Epic Console RPG game.
     * Manages the complete game flow from character creation to game end.
     */
    public static void main(String[] args) {

        System.out.println("🎮 Welcome to Epic Console RPG! 🎮");
        System.out.println("=".repeat(50));

        System.out.println("Choose a character and name to begin. Different characters have different starting characteristics.");

        // Initialize game components and create hero character
        String name = getHeroName();
        int characterChoice = heroSelectionRequest();

        CombatManager combatManager = new CombatManager();
        Hero hero = combatManager.createHero(name, characterChoice);
        System.out.println("\n🎉 Hero created successfully!");
        System.out.println(hero);

        System.out.println("\n🚀 The adventure begins!");

        // Main combat loop - continues until hero dies
        while (hero.isAlive()) {
            System.out.println("\n🔄 Preparing for next battle...\n");
            try {
                Thread.sleep(1500); // Brief pause for better user experience
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            // Generate new enemy and start battle
            Enemy enemy = combatManager.createEnemy();
            System.out.println("Your new " + enemy);
            
            // Battle loop between hero and current enemy
            while (enemy.isAlive() && hero.isAlive()) {
                HeroActions action = combatManager.askHeroAboutAction(sc);
                combatManager.heroActionProcessing(action, hero, enemy);
                if (enemy.isAlive()) enemy.attack(hero);
                combatManager.showGameInfo(hero, enemy);
            }
            
            // Award victory if hero survived the battle
            if (hero.isAlive()) {
                hero.addVictory();
            }
        }

        // Display final results and save to file
        combatManager.displayGameResults(hero);

        try {
            combatManager.saveGameResults(hero);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }

    /**
     * Validates that the hero selection is within the allowed range (1-3).
     * @param choice The character choice number to validate
     * @throws HeroOutOfRangeException if choice is not between 1 and 3
     */
    public static void checkHeroRange(int choice) throws HeroOutOfRangeException {
        if (choice < 1 || choice > 3) {
            throw new HeroOutOfRangeException("You can choose a character from the three presented");
        }
    }

    /**
     * Prompts the user to enter their hero's name with input validation.
     * @return A valid, non-empty hero name
     */
    private static String getHeroName() {
        System.out.print("\n🏷️ Enter your hero's name: ");
        String name = "";
        try {
            name = sc.nextLine().trim();
        } catch (Exception e) {
            System.out.println("You entered an invalid input" + e);
            sc.nextLine();
        }

        // Ensure name is not empty
        while (name.isEmpty()) {
            System.out.print("❌ Name cannot be empty! Please enter a valid name: ");
            name = sc.nextLine().trim();
        }

        System.out.println("Hello, " + name + "! 👋");
        return name;
    }

    /**
     * Displays character options and handles user selection with input validation.
     * @return The selected character choice (1=Warrior, 2=Mage, 3=Ninja)
     */
    public static int heroSelectionRequest() {
        System.out.println("""
                1. 🗡️ Warrior – strong and durable fighter
                2. 🧙 Mage – Powerful magic user
                3. 🥷 Ninja – Fast and balanced
                """);
        int characterChoice;
        while (true) {
            try {
                System.out.println("Choose your character:");
                characterChoice = sc.nextInt();
                checkHeroRange(characterChoice);
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid number. Please try again." + e);
                sc.nextLine();
            } catch (HeroOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
        }
        return characterChoice;
    }
}