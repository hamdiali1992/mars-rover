package com.kata.marsrover.command;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.direction.NorthDirection;
import com.kata.marsrover.direction.WestDirection;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SpinLeftCommandTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new NorthDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
        command = new SpinLeftCommand();
    }

    @Test
    public void whenSpinLeftCommandIsExecutedRoverSpinsLeft() throws Exception {
        command.execute(rover);
        assertEquals(WestDirection.class, rover.getDirection().getClass());
    }
}
