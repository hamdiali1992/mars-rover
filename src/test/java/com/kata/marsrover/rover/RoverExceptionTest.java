package com.kata.marsrover.rover;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.direction.NorthDirection;
import com.kata.marsrover.exception.RoverOutOfBoundsException;
import org.junit.Before;
import org.junit.Test;

public class RoverExceptionTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new NorthDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test(expected = NullPointerException.class)
    public void whenRoverIsCreatedWithANullPlateauExceptionIsThrown() {
        new RoverUtils(null, xCoordinate, yCoordinate, direction);
    }

    @Test(expected = NullPointerException.class)
    public void whenRoverIsCreatedWithANullDirectionExceptionIsThrown() {
        new RoverUtils(plateau, xCoordinate, yCoordinate, null);
    }

    @Test(expected = RoverOutOfBoundsException.class)
    public void whenRoverIsCreatedOutOfPlateauBoundsExceptionIsThrown() {
        new RoverUtils(plateau, -1, 6, direction);
    }

    @Test(expected = RoverOutOfBoundsException.class)
    public void whenRoverMovesOutOfNorthBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getUpperBoundCoordinateX());
        rover.setCoordinateY(plateau.getUpperBoundCoordinateY());
        rover.moveForward();
    }

    @Test(expected = RoverOutOfBoundsException.class)
    public void whenRoverMovesOutOfEastBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getUpperBoundCoordinateX());
        rover.setCoordinateY(plateau.getUpperBoundCoordinateY());
        rover.spinRight();
        rover.moveForward();
    }

    @Test(expected = RoverOutOfBoundsException.class)
    public void whenRoverMovesOutOfSouthBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getLowerBoundCoordinateX());
        rover.setCoordinateY(plateau.getLowerBoundCoordinateY());
        rover.moveBack();
    }

    @Test(expected = RoverOutOfBoundsException.class)
    public void whenRoverMovesOutOfWestBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getLowerBoundCoordinateX());
        rover.setCoordinateY(plateau.getLowerBoundCoordinateY());
        rover.spinLeft();
        rover.moveForward();
    }
}
