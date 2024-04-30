package com.kata.marsrover.direction;

import com.kata.marsrover.rover.RoverUtils;

public class NorthDirection implements Direction {

    @Override
    public Direction spinRight() {
        return new EastDirection();
    }

    @Override
    public Direction spinLeft() {
        return new WestDirection();
    }

    @Override
    public void moveForward(RoverUtils rover) {
        rover.setCoordinateY(rover.getCoordinateY() + 1);
    }

    @Override
    public void moveBack(RoverUtils rover) {
        rover.setCoordinateY(rover.getCoordinateY() - 1);
    }
}
