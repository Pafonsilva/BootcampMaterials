package org.academiadecodigo.arabiannights;

import org.academiadecodigo.arabiannights.genie.Genie;
import org.academiadecodigo.arabiannights.genie.RecyclableDemon;

/**
 * Arabian Nights Test Class
 */
public class ArabianNights {

    /** Container of Genies */
    private static Genie[] genies;

    /** Entry point */
    public static void main(String[] args) {

        // Instantiate a new magic lamp with capacity for 4 genies
        MagicLamp lamp = new MagicLamp(4);

        // Rub the lamp 5 times and store all genies
        genies = new Genie[] {
                lamp.rub(2),
                lamp.rub(3),
                lamp.rub(4),
                lamp.rub(5),
                lamp.rub(1)
        };

        // Print status of all genies
        geniesStatus();

        // Ask for wishes
        askForWishes();
        askForWishes();
        askForWishes();
        askForWishes();

        // Feed the lamp with a recyclable genie
        System.out.println(">>>> Will try to feed a demon to the lamp!!!");
        lamp.recharge((RecyclableDemon) genies[4]);

        // Rub the lamp one more time to get a new genie
        Genie extraGenie = lamp.rub(7);

        // Ask for wish and print genie status
        extraGenie.grantWish();
        System.out.println(extraGenie);

        // Instantiate a new lamp and compare it with the existing one
        System.out.println(">>>> Will create a new lamp and compare with existing one");
        MagicLamp newLamp = new MagicLamp(4);

        System.out.println("The lamps are" + (lamp.equals(newLamp) ? " " : " not ") + "equal");

    }

    /**
     * Ask each genie in the container to grant a wish
     */
    public static void askForWishes() {

        System.out.println("======================");

        for (Genie g : genies) {
            g.grantWish();
        }

        geniesStatus();
    }

    /**
     * Ask each genie in the container to print its status
     */
    public static void geniesStatus() {
        for (Genie g : genies) {
            System.out.println(g);
        }
    }

}
