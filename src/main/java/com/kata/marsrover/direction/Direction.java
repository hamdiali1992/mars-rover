package com.kata.marsrover.direction;

import com.kata.marsrover.rover.RoverUtils;

public interface Direction {

    Direction spinRight();

    Direction spinLeft();

    void moveForward(RoverUtils rover);

    void moveBack(RoverUtils rover);
}
