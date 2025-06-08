package art.lapov.rpg;

import art.lapov.rpg.characters.Enemy;
import art.lapov.rpg.characters.Hero;
import art.lapov.rpg.enums.HeroActions;
import art.lapov.rpg.exceptions.HeroOutOfRangeException;
import art.lapov.rpg.utils.CombatManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void checkHeroRange(int choice) throws HeroOutOfRangeException {
        if (choice < 1 || choice > 3) {
            throw new HeroOutOfRangeException("You can choose a character from the three presented");
        }
    }

    public static void main(String[] args) {

        System.out.println("🎮 Welcome to Epic Console RPG! 🎮");
        System.out.println("=".repeat(50));

        System.out.println("Choose a character and name to begin. Different characters have different starting characteristics.");

        // It is necessary to request all the necessary data to start the game
        Scanner sc = new Scanner(System.in);
        String name = "";
        System.out.print("Please enter your name: ");
        try {
            name = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid character name. Please try again." + e);
        }
        System.out.println("Hello, " + name);
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

        CombatManager combatManager = new CombatManager();
        Hero hero = combatManager.createHero(name, characterChoice);
        System.out.println("\n🎉 Hero created successfully!");
        System.out.println(hero);

        System.out.println("\n🚀 The adventure begins!");

// Combat loop
        while (hero.isAlive()) {
            System.out.println("\n🔄 Preparing for next battle...");
            try {
                Thread.sleep(1500); // 1,5 second pause for easy reading
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            Enemy enemy = combatManager.createEnemy();
            System.out.println("Your new enemy:\n" + enemy);
            while (enemy.isAlive() && hero.isAlive()) {
                HeroActions action = CombatManager.askHeroAboutAction();
                combatManager.userActionProcessing(action, hero, enemy);
                if (enemy.isAlive()) enemy.attack(hero);
                CombatManager.showGameInfo(hero, enemy);
            }
            if (hero.isAlive()) {                      // the hero survived - he won
                hero.addVictory();
            }
        }

        System.out.println("You're dead ☠️ Goodbye!");

        try {
            combatManager.saveGameResults(hero);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}