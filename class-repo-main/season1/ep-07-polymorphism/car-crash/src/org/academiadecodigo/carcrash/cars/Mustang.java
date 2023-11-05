package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

/**
 * A Car that moves fast and never breaks
 */
public class Mustang extends Car {

    public Mustang() {
        super(new Position(), CarType.MUSTANG, 3);
    }

    @Override
    public void move() {
        accelerate(chooseDirection());
    }
}
