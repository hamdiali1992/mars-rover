package com.kata.marsrover.direction;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EastDirectionTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new EastDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test
    public void whenEastDirectionTurnsRightNewDirectionIsSouth() throws Exception {
        assertEquals(SouthDirection.class, direction.spinRight().getClass());
    }

    @Test
    public void whenEastDirectionTurnsLeftNewDirectionIsNorth() throws Exception {
        assertEquals(NorthDirection.class, direction.spinLeft().getClass());
    }

    @Test
    public void whenEastDirectionMovesForwardCoordinateXIncrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(++xCoordinate, rover.getCoordinateX());
    }

    @Test
    public void whenEastDirectionMovesBackCoordinateXDecrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(--xCoordinate, rover.getCoordinateX());
    }
}
