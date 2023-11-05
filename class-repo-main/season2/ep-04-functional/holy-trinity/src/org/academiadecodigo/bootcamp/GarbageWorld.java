package org.academiadecodigo.bootcamp;

import java.util.stream.Stream;

public class GarbageWorld {

    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        System.out.println(Stream.of(message.split(" "))
                .filter(e -> !e.equals("garbage"))
                .map(String::toUpperCase)
                .reduce("", (acc, elem) -> acc + " " + elem));

    }
}
