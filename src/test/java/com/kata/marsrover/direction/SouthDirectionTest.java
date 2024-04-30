package com.kata.marsrover.direction;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SouthDirectionTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new SouthDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test
    public void whenSouthDirectionTurnsRightNewDirectionIsWest() throws Exception {
        assertEquals(WestDirection.class, direction.spinRight().getClass());
    }

    @Test
    public void whenSouthDirectionTurnsLeftNewDirectionIsEast() throws Exception {
        assertEquals(EastDirection.class, direction.spinLeft().getClass());
    }

    @Test
    public void whenSouthDirectionMovesForwardCoordinateYDecrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(--yCoordinate, rover.getCoordinateY());
    }

    @Test
    public void whenSouthDirectionMovesBackCoordinateYIncrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }
}
