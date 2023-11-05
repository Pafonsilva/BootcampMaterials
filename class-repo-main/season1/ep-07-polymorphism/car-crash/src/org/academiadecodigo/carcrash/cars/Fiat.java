package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

/**
 * A car that moves slowly and may start to break after a while
 */
public class Fiat extends Car {

    private final static int MOVES_BEFORE_BREAK = 30;
    private final static int MOVES_AFTER_BREAK = 4;

    private int moves = 0;

    public Fiat() {
        super(new Position(), CarType.FIAT, 1);
    }

    @Override
    public void move() {

        moves++;

        if (moves < MOVES_BEFORE_BREAK || moves % MOVES_AFTER_BREAK != 0) {
            accelerate(chooseDirection());
        }

    }
}
