package org.academiadecodigo.bootcamp.guessnumber;

public class Player {

    private String name;

    public Player(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int chooseNumber(int maxGuess) {
        return RandomGenerator.getRandom(1, maxGuess);
    }

}
