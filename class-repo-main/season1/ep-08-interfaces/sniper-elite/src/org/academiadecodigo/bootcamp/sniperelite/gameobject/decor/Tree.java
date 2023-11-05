package org.academiadecodigo.bootcamp.sniperelite.gameobject.decor;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;

/**
 * A simple tree, not worthy of getting shot
 */
public class Tree extends GameObject {

    /**
     * @see GameObject#getMessage()
     */
    @Override
    public String getMessage() {
        return "Just a Tree. Save the Trees!";
    }

}
