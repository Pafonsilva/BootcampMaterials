package org.academiadecodigo.carcrash;

public class Main {

    public static void main(String[] args) throws InterruptedException{


        Game g = new Game(100, 25, 150);

        g.init();
        g.start();

    }
}
