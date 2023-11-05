package org.academiadecodigo.finder;

import org.academiadecodigo.finder.exceptions.FileNotFoundException;
import org.academiadecodigo.finder.exceptions.NotEnoughPermissionsException;
import org.academiadecodigo.finder.exceptions.NotEnoughSpaceException;

/**
 * Created by pantoninho on 22/05/16.
 */
public class FileManager {

    private File[] files;
    private boolean loggedIn = false;
    private int fileCounter = 0; // avoids countinously iterating over the files array

    public FileManager(int maxFiles) {
        this.files = new File[maxFiles];
    }

    public void login() {
        loggedIn = true;
    }

    public void logout() {
        loggedIn = false;
    }

    public File getFile(String filename) throws FileNotFoundException {

        for (File file : files) {

            if (file == null) {
                break;
            }

            if (file.getName().equals(filename)) {
                return file;
            }
        }

        throw new FileNotFoundException();
    }

    public void createFile(String filename) throws NotEnoughPermissionsException, NotEnoughSpaceException {

        if (!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        if (fileCounter == files.length) {
            throw new NotEnoughSpaceException();
        }

        files[fileCounter] = new File(filename);
        fileCounter++;

    }

}
