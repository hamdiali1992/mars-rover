package com.kata.marsrover.direction;

import com.kata.marsrover.rover.RoverUtils;

public class WestDirection implements Direction {

    @Override
    public Direction spinRight() {
        return new NorthDirection();
    }

    @Override
    public Direction spinLeft() {
        return new SouthDirection();
    }

    @Override
    public void moveForward(RoverUtils rover) {
        rover.setCoordinateX(rover.getCoordinateX() - 1);
    }

    @Override
    public void moveBack(RoverUtils rover) {
        rover.setCoordinateX(rover.getCoordinateX() + 1);
    }
}
