package art.lapov.rpg;

import art.lapov.rpg.characters.Hero;
import art.lapov.rpg.utils.CombatManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
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
        System.out.println("Please select your character");
        System.out.println("""
                1. ( ´-ω･)︻┻┳══━一
                2. (ノ ˘_˘)ノ　ζ|||ζ　ζ|||ζ　ζ|||ζ
                3. (◕‿◕✿)
                """);
        int characterChoice;

        while (true) {
            try {
                characterChoice = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please try again." + e);
                sc.nextLine();
            }
        }

        CombatManager combatManager = new CombatManager();
        Hero hero = combatManager.createHero(name, characterChoice);

        System.out.println(hero.toString());







        sc.close();
    }
}