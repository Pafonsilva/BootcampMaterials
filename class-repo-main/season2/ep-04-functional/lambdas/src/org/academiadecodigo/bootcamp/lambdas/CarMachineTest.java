package org.academiadecodigo.bootcamp.lambdas;

public class CarMachineTest {


    public static void main(String[] args) {

        System.out.println("\n===== Car Operations =====\n");

        Car fiat = new Car("fiat", "white");
        Car mustang = new Car("mustang", "blue");

        Machine<Car> carMachine = new MachineImpl<>();

        // store a Lambda Expressions in a variables of a Functional Interface type

        MonoOperation<Car> pimpMyRide = car -> {
            car.setColor("pacific blue with single lightning white stripe");
            car.setAudioSystem("the best BOSE");
            return car;
        };

        BiOperation<Car> copyCarColor = (car, carToCopy) -> {
          car.setColor(carToCopy.getColor());
          car.setAudioSystem(carToCopy.getAudioSystem());
          return car;
        };

        // change car colour by passing lambda directly

        fiat = carMachine.perform(car -> {
            car.setColor("black");
            return car;
        }, fiat);

        System.out.println("New fiat color is: " + fiat.getColor());

        // change car sound system by passing lambda directly

        fiat = carMachine.perform(car -> {
            car.setAudioSystem("xuning");
            return car;
        }, fiat);

        System.out.println("New fiat audio system is: " + fiat.getAudioSystem());

        System.out.println("\nComplete Pimp my Ride!!");

        // apply previously created lambda

        mustang = carMachine.perform(pimpMyRide, mustang);

        Machine<String> stringMachine = new MachineImpl<>();

        System.out.println(stringMachine.perform(String::concat, "New " + mustang.getBrand() +
                " color is: ", mustang.getColor()));
        System.out.println(stringMachine.perform(String::concat, "New " + mustang.getBrand() +
                "  audio system is: ", mustang.getAudioSystem()));

        // apply previously created lambda

        System.out.println("There's always a copy cat...");

        fiat = carMachine.perform(copyCarColor, fiat, mustang);

        System.out.println(stringMachine.perform(String::concat, "New " + fiat.getBrand() +
                "  color is: ", fiat.getColor()));
        System.out.println(stringMachine.perform(String::concat, "New " + fiat.getBrand() +
                " audio system is: ", fiat.getAudioSystem()));

    }

}
