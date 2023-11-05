package org.academiadecodigo.bootcamp.guessnumber;

/**
 * Utility class capable of generating random numbers
 */
public class RandomGenerator {

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static int getRandom(int min, int max) {

        // Between 0 and max :
        //return (int) (Math.random() * (max + 1));

        // Between 0+min and (max-min+min)
        return (int) (Math.random() * (max - min + 1) + min);

    }
}
