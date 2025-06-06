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

        System.out.println("\nWelcome to our epic RPG (*・ω・)ﾉ");

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
                1. ( ´-ω･)︻┻┳══━一
                2. (ノ ˘_˘)ノ　ζ|||ζ　ζ|||ζ　ζ|||ζ
                3. (◕‿◕✿)
                """);
        int characterChoice;

        while (true) {
            try {
                System.out.println("Enter the character's number:");
                characterChoice = sc.nextInt();
                checkHeroRange(characterChoice);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please try again." + e);
                sc.nextLine();
            } catch (HeroOutOfRangeException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("The game is on!");

        CombatManager combatManager = new CombatManager();
        combatManager.askHeroAboutAction();
        Hero hero = combatManager.createHero(name, characterChoice);

//        while (hero.isAlive()) {
//            Enemy enemy = combatManager.createEnemy();
//
//            while (enemy.isAlive()) {
//                HeroActions action = combatManager.askHeroAboutAction();
//            }
//            combatManager.showGameInfo(hero, enemy);
//
//        }

        try {
            combatManager.saveGameResults(hero);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}