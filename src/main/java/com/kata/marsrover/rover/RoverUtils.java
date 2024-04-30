package com.kata.marsrover.rover;

import com.kata.marsrover.Plateau;
import com.kata.marsrover.command.Command;
import com.kata.marsrover.direction.Direction;
import com.kata.marsrover.exception.RoverOutOfBoundsException;

import java.util.ArrayList;

public class RoverUtils {

    private final Plateau plateau;
    private int coordinateX;
    private int coordinateY;
    private Direction direction;

    public RoverUtils(Plateau plateau, int coordinateX, int coordinateY, Direction direction) {
        if (plateau == null) throw new NullPointerException("The Plateau containing the rover cannot be null!");
        if (direction == null) throw new NullPointerException("The Direction the rover is pointing at cannot be null!");

        this.plateau = plateau;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.direction = direction;
        validateLocation();
    }

    private Plateau getPlateau() {
        return plateau;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void executeCommandList(ArrayList<Command> commands) {
        for (Command command : commands)
            command.execute(this);
    }

    public void spinRight() {
        direction = getDirection().spinRight();
    }

    public void spinLeft() {
        direction = getDirection().spinLeft();
    }

    public void moveForward() {
        getDirection().moveForward(this);
        validateLocation();
    }

    public void moveBack() {
        getDirection().moveBack(this);
        validateLocation();
    }

    public String broadcastLocation() {
        return coordinateX + " "
                + coordinateY + " "
                + getDirection().getClass().getSimpleName().charAt(0);
    }

    private void validateLocation() {
        if (this.getCoordinateX() > this.getPlateau().getUpperBoundCoordinateX()
                || this.getCoordinateY() > this.getPlateau().getUpperBoundCoordinateY()
                || this.getCoordinateX() < this.getPlateau().getLowerBoundCoordinateX()
                || this.getCoordinateY() < this.getPlateau().getLowerBoundCoordinateY())
            throw new RoverOutOfBoundsException();
    }
}
