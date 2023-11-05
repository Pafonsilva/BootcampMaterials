package org.academiadecodigo.bootcamp;

public class Main {

    public static void main(String[] args) {

        Hotel ritz = new Hotel("Ritz", 100);
        Hotel mundial = new Hotel("Mundial", 350);
        Person rui = new Person("Rui");
        Person antoninho = new Person("Antoninho");

        rui.setHotel(ritz);
        antoninho.setHotel(ritz);

        if (!antoninho.checkIn()) {
            System.out.println("Could not get a room for " + antoninho.getName());
        }

        if (!rui.checkIn()) {
            System.out.println("Could not get a room for " + rui.getName());
        }

        antoninho.checkOut();
        rui.checkOut();

        if (!rui.checkOut()) {
            System.out.println("Unable to checkOut twice in a row!");
        }

        if (rui.checkIn() && !rui.checkIn()) {
            System.out.println("Could not checkIn twice!");
        }

        if (rui.checkOut() && rui.checkIn()) {
            System.out.println("CheckIn after check out works fine!!!");
        }

        System.out.println(ritz);
        System.out.println(mundial);
        System.out.println(rui);
        System.out.println(antoninho);


    }
}
