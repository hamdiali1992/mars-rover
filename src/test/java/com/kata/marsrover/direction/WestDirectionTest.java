package com.kata.marsrover.direction;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WestDirectionTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new WestDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test
    public void whenWestDirectionTurnsRightNewDirectionIsNorth() throws Exception {
        assertEquals(direction.spinRight().getClass(), NorthDirection.class);
    }

    @Test
    public void whenWestDirectionTurnsLeftNewDirectionIsSouth() throws Exception {
        assertEquals(direction.spinLeft().getClass(), SouthDirection.class);
    }

    @Test
    public void whenWestDirectionMovesForwardCoordinateXDecrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(--xCoordinate, rover.getCoordinateX());
    }

    @Test
    public void whenWestDirectionMovesBackCoordinateXIncrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(++xCoordinate, rover.getCoordinateX());
    }
}
