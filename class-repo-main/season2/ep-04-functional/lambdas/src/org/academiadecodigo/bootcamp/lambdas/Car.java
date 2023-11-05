package org.academiadecodigo.bootcamp.lambdas;

public class Car {

    private final String brand;
    private String color;
    private String audioSystem;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
        this.audioSystem = "standard";
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAudioSystem() {
        return audioSystem;
    }

    public void setAudioSystem(String audioSystem) {
        this.audioSystem = audioSystem;
    }
}
