package com.kata.marsrover;

import com.kata.marsrover.command.MoveBackCommandTest;
import com.kata.marsrover.command.MoveForwardCommandTest;
import com.kata.marsrover.command.SpinLeftCommandTest;
import com.kata.marsrover.command.SpinRightCommandTest;
import com.kata.marsrover.direction.EastDirectionTest;
import com.kata.marsrover.direction.NorthDirectionTest;
import com.kata.marsrover.direction.SouthDirectionTest;
import com.kata.marsrover.direction.WestDirectionTest;
import com.kata.marsrover.rover.RoverExceptionTest;
import com.kata.marsrover.rover.RoverTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        MoveBackCommandTest.class,
        MoveForwardCommandTest.class,
        SpinLeftCommandTest.class,
        SpinRightCommandTest.class,
        EastDirectionTest.class,
        NorthDirectionTest.class,
        SouthDirectionTest.class,
        WestDirectionTest.class,
        RoverTest.class,
        RoverExceptionTest.class,
        InputUtilsTest.class,
        PlateauTest.class
})
public class MarsRoverTestSuite extends BaseTest {

}
