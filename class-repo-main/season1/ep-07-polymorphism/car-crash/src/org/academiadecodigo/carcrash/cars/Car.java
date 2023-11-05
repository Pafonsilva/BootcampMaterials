package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.CollisionDetector;
import org.academiadecodigo.carcrash.field.Direction;
import org.academiadecodigo.carcrash.field.Position;

/**
 * Generic Car behaviour
 */
abstract public class Car {

    /**
     * The position of the car on the grid
     */
    private Position pos;

    /**
     * The speed of the car
     */
    private int speed;

    /**
     * The specific type of car
     */
    private CarType carType;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * The randomness of Car currentDirection change from 1 to 10
     */
    private int directionChangeLevel = 8;

    /**
     * The current currentDirection of the car
     */
    private Direction currentDirection;

    /**
     * The car crashed state
     */
    boolean crashed = false;

    /**
     * Constructs a new car
     *
     * @param pos     the initial car position
     * @param carType the car type
     */
    public Car(Position pos, CarType carType, int speed) {

        this.pos = pos;
        this.carType = carType;
        this.speed = speed;

        currentDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];

    }

    public Position getPos() {
        return pos;
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void crash() {

        this.crashed = true;
    }

    public void setDirectionChangeLevel(int directionChangeLevel) {
        this.directionChangeLevel = directionChangeLevel;
    }

    /**
     * Perform specific moving behaviour according to the car type
     */
    abstract public void move();

    /**
     * Chooses a new currentDirection for the car
     *
     * @return the new currentDirection
     */
    public Direction chooseDirection() {

        // Let's move in the same currentDirection by default
        Direction newDirection = currentDirection;

        // Sometimes, we want to change currentDirection...
        if (Math.random() > ((double) directionChangeLevel) / 10) {
            newDirection = Direction.values()[(int) (Math.random() * Direction.values().length)];

            // but we do not want to perform U turns..
            if (newDirection.isOpposite(currentDirection)) {
                return chooseDirection();
            }

        }

        return newDirection;

    }

    /**
     * Accelerates the car towards a specific direction,
     * as long as we have not bumped against the wall,
     * in which case we bounce back
     *
     * @param direction the currentDirection to accelerate
     */
    public void accelerate(Direction direction) {

        // Crashed cars can not accelerate
        if (isCrashed()) {
            return;
        }

        Direction newDirection = direction;

        // Perform a U turn if we have bumped against the wall
        if (pos.isEdge(direction) && newDirection.equals(currentDirection)) {
            newDirection = currentDirection.oppositeDirection();
        }

        // Accelerate in the choosen direction
        this.currentDirection = newDirection;
        for (int speed = 0; speed < this.speed; speed++) {
            getPos().moveInDirection(newDirection, 1);
            if(collisionDetector.isUnSafe(getPos())) {
                crash();
                break;
            }
        }

    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    /**
     * The car representation on the field
     *
     * @return the car representation
     */
    @Override
    public String toString() {
        return isCrashed() ? "C" : Character.toString(carType.getSymbol());
    }

}
