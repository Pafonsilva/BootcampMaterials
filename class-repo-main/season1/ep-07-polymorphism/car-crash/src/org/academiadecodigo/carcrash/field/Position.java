package org.academiadecodigo.carcrash.field;

/**
 * Represents a position in a grid of columns and rows
 */
public class Position {

    private int row;
    private int col;

    public Position() {
        setRandom();
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRandom() {
        row = (int) (Math.random() * Field.getHeight());
        col = (int) (Math.random() * Field.getWidth());
    }

    public void moveDown(int distance) {
        if (this.row + distance < Field.getHeight()) {
            this.row += distance;
        } else {
            this.row = Field.getHeight() - 1;
        }
    }

    public void moveUp(int distance) {
        if (this.row - distance > 0) {
            this.row -= distance;
        } else {
            this.row = 0;
        }
    }

    public void moveLeft(int distance) {
        if (this.col - distance > 0) {
            this.col -= distance;
        } else {
            this.col = 0;
        }
    }

    public void moveRight(int distance) {

        if (this.col + distance < Field.getWidth()) {
            this.col += distance;
        } else {
            this.col = Field.getWidth() - 1;
        }
    }

    public void moveInDirection(Direction direction, int distance) {


        switch (direction) {

            case UP:
                moveUp(distance);
                break;
            case DOWN:
                moveDown(distance);
                break;
            case LEFT:
                moveLeft(distance);
                break;
            case RIGHT:
                moveRight(distance);
                break;
        }

    }

    public void moveInRandomDirection(int distance) {

        int randomIndex = (int) (Math.random() * Direction.values().length);
        Direction dir = Direction.values()[randomIndex];

        moveInDirection(dir, distance);

    }

    public boolean isEdge(Direction direction) {

        return (direction == Direction.UP && row == 0) ||
                (direction == Direction.DOWN && row == Field.getHeight() - 1) ||
                (direction == Direction.LEFT && col == 0) ||
                (direction == Direction.RIGHT && col == Field.getWidth() - 1);
    }

    /**
     * Tests for position equality
     * @param position The position to compare with
     * @return result of comparing positions
     */
    public boolean equals(Position position) {
        return col == position.getCol() &&
                row == position.getRow();
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
}
