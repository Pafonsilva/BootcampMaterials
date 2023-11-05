package org.academiadecodigo.bootcamp;

/**
 * Created by ferrao on 29/01/16.
 */
public class Room {

    private boolean available = true;

    public boolean isAvailable() {
        return available;
    }

    public void occupy() {
        available = false;
    }

    public void vacate() {
        available = true;
    }
}
