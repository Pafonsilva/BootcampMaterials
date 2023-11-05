package org.academiadecodigo.bootcamp.guessnumber;

public class Main {

    public static void main(String[] args) {

        Player[] players = new Player[] {
                new Player("Rui"),
                new Player("Campelo"),
                new Player("Antoninho"),
                new Player("Catarina")
        };

        GuessNumber game = new GuessNumber(10, players);
        game.start();

    }

}
