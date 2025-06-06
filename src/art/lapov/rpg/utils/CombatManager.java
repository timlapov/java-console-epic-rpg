package art.lapov.rpg.utils;

import art.lapov.rpg.characters.Dragon;
import art.lapov.rpg.characters.Enemy;
import art.lapov.rpg.characters.Goblin;
import art.lapov.rpg.characters.Hero;
import art.lapov.rpg.characters.Troll;
import art.lapov.rpg.enums.HeroActions;
import art.lapov.rpg.exceptions.HeroOutOfRangeException;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CombatManager {

    //Create a hero
    public static Hero createHero(String name, int choice) {
        switch (choice) {
            case 1 -> {
                return new Hero(name, 100, 7, 10, 25);
            }
            case 2 -> {
                return new Hero(name, 80, 3, 40, 15);
            }
            default -> {
                return new Hero(name, 90, 5, 20, 20);
            }
        }

    }

    // Create an enemy
    public static Enemy createEnemy() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);

        switch (randomNumber) {
            case 1 -> {
                return new Goblin();
            }
            case 2 -> {
                return new Dragon();
            }
            default -> {
                return new Troll();
            }
        }
    }
    //    Current status display
    public static void showGameInfo(Hero hero, Enemy enemy) {
        System.out.println("*************** GAME INFO ***************");
        System.out.println(hero);
        System.out.println(enemy);
    }

    // Start game

//    Attack processing
//    Handling the use of special features
//    Handling the use of treatment
//    Battle Summary

    // Get poiton
    public static int getPoiton() {
        Random random = new Random();
        return random.nextInt(18) + 2;
    }

    public void userActionProcessing(HeroActions action, Hero hero, Enemy enemy) {
        switch (action) {
            case ATTACK -> {
                hero.attack(enemy);
            }
            case USE_SPECIAL_ABILITY -> {

            }
            case POTION -> {

            }
            default -> {

            }
        }
    }

    public static HeroActions askHeroAboutAction() {
        System.out.println("Make your choice");
        HeroActions[] actions = HeroActions.values();
        for (int i = 0; i < actions.length; i++) {
            System.out.println((i + 1) + ". " + actions[i].getDisplayName());
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter the number:");
                int number = sc.nextInt();

                if (number < 1 || number > actions.length) {
                    throw new IllegalArgumentException("Invalid choice: number must be between 1 and " + actions.length);
                }
                return actions[number - 1];

            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please try again.");
                sc.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //    Saving the result to a file
    public static void saveGameResults(Hero hero) {
        // Realize writing to a file
        System.out.println("Realize writing to a file");
    }

}
