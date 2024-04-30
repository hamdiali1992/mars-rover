package com.kata.marsrover.command;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.direction.EastDirection;
import com.kata.marsrover.direction.NorthDirection;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SpinRightCommandTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new NorthDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
        command = new SpinRightCommand();
    }

    @Test
    public void whenSpinRightCommandIsExecutedRoverSpinsRight() throws Exception {
        command.execute(rover);
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }
}
