package org.academiadecodigo.bootcamp;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * UniqueWord iterates through the words of the string
 */
public class UniqueWord implements Iterable<String> {

    private Set<String> words = new HashSet<String>();

    public UniqueWord(String s) {

        //Collections.addAll(words, s.split(" ");
        for (String word : s.split(" ")) {
            words.add(word);
        }

    }

    @Override
    public Iterator<String> iterator() {
        return words.iterator();
    }

}
