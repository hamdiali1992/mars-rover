package com.kata.marsrover.command;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.direction.NorthDirection;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoveForwardCommandTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new NorthDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
        command = new MoveForwardCommand();
    }

    @Test
    public void whenMoveForwardCommandIsExecutedRoverMovesForward() throws Exception {
        command.execute(rover);
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }
}
