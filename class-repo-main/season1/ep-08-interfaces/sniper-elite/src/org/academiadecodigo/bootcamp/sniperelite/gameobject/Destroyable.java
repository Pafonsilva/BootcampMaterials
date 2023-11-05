package org.academiadecodigo.bootcamp.sniperelite.gameobject;

/**
 * Implemented by all objects capable of getting shot
 */
public interface Destroyable {

    /**
     * Inflict damage on object
     * @param damage the amount of damage to inflict
     */
    void hit(int damage);

    boolean isDestroyed();

}
