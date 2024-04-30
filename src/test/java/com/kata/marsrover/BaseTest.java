package com.kata.marsrover;

import com.kata.marsrover.command.Command;
import com.kata.marsrover.direction.Direction;
import com.kata.marsrover.rover.RoverUtils;

public abstract class BaseTest {

    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected Direction direction;
    protected RoverUtils rover;
    protected Command command;
}
