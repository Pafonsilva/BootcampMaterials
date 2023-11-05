package org.academiadecodigo.finder.exceptions;

/**
 * Created by pantoninho on 22/05/16.
 */
public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException() {
        super("Not enough space!");
    }
}
