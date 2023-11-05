package org.academiadecodigo.carcrash.cars;

/**
 * A factory capable of generating Cars of a random type
 */
public class CarFactory {

    /**
     * Manufactures new random cars
     * @return a newly instantiated car
     */
    public static Car getNewCar() {

        int random = (int) (Math.random() * CarType.values().length);
        CarType carType = CarType.values()[random];

        Car car;

        switch (carType) {
            case FIAT:
                car = new Fiat();
                break;
            case MUSTANG:
                car = new Mustang();
                break;
            default:
                car = new Fiat();
        }

        return car;

    }

}
