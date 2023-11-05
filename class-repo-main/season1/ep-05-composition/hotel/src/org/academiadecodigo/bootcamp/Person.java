package org.academiadecodigo.bootcamp;

public class Person {

    private String name;
    private Hotel hotel;
    private int roomId = Hotel.NO_ROOM; // -1 means no room ID

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean checkIn() {

        if (hotel == null || roomId != Hotel.NO_ROOM) {
            return false;
        }

        roomId = hotel.checkIn();
        if (roomId == Hotel.NO_ROOM) {
            return false;
        }

        return true;

    }

    public boolean checkOut() {

        if (hotel == null || roomId == Hotel.NO_ROOM) {
            return false;
        }

        hotel.checkOut(roomId);
        roomId = Hotel.NO_ROOM;
        return true;

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hotel=" + (hotel == null ? "" : hotel) +
                ", roomId=" + (roomId == Hotel.NO_ROOM ? "" : roomId) +
                '}';
    }
}
