package art.lapov.rpg.utils;

import art.lapov.rpg.characters.Hero;

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
    // Start game
//    Current status display
//    Attack processing
//    Handling the use of special features
//    Handling the use of treatment
//    Battle Summary
//    Saving the result to a file

}
