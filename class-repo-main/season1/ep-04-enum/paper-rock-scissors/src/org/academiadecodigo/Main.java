package org.academiadecodigo;

/**
 * Application entry point
 */
public class Main {

    public static void main(String[] args) {

        Game g = new Game(10, new Player("Rui"), new Player("Campelo"));
        g.start();

    }
}
