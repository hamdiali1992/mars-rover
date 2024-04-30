package com.kata.marsrover.rover;

import com.kata.marsrover.BaseTest;
import com.kata.marsrover.Plateau;
import com.kata.marsrover.command.Command;
import com.kata.marsrover.command.MoveForwardCommand;
import com.kata.marsrover.command.SpinLeftCommand;
import com.kata.marsrover.command.SpinRightCommand;
import com.kata.marsrover.direction.EastDirection;
import com.kata.marsrover.direction.NorthDirection;
import com.kata.marsrover.direction.WestDirection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class RoverTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        direction = new NorthDirection();
        rover = new RoverUtils(plateau, xCoordinate, yCoordinate, direction);
    }

    @Test
    public void whenRequestedRoverCanSpinRight() throws Exception {
        rover.spinRight();
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRequestedRoverCanSpinLeft() throws Exception {
        rover.spinLeft();
        assertEquals(WestDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenRequestedRoverCanMoveForward() throws Exception {
        rover.moveForward();
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }

    @Test
    public void whenRequestedRoverCanMoveBack() throws Exception {
        rover.moveBack();
        assertEquals(--yCoordinate, rover.getCoordinateY());
    }

    @Test
    public void whenRequestedRoverCanPrintCurrentPosition() throws Exception {
        assertEquals(xCoordinate + " "
                + yCoordinate + " "
                + direction.getClass().getSimpleName().charAt(0), rover.broadcastLocation());
    }

    @Test
    public void whenRequestedRoverCanExecuteCommandAsAList() throws Exception {
        ArrayList<Command> commandArrayList = new ArrayList<>();
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinRightCommand());
        rover.executeCommandList(commandArrayList);

        assertEquals(1, rover.getCoordinateX());
        assertEquals(4, rover.getCoordinateY());
        assertEquals(NorthDirection.class, rover.getDirection().getClass());
    }

    @Test
    public void whenHardCodedTestInputIsRunCorrectOutputIsReturned() {
        // Test Input:
        // 5 5
        Plateau plateau = new Plateau(5, 5);

        // 1 2 N
        RoverUtils roverOne = new RoverUtils(plateau, 1, 2, new NorthDirection());

        // LMLMLMLMM
        ArrayList<Command> roverOneCommands = new ArrayList<>();
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOne.executeCommandList(roverOneCommands);

        // 3 3 E
        RoverUtils roverTwo = new RoverUtils(plateau, 3, 3, new EastDirection());

        // MMRMMRMRRM
        ArrayList<Command> roverTwoCommands = new ArrayList<>();
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwo.executeCommandList(roverTwoCommands);

        // Expected Output:
        // 1 3 N
        assertEquals(1, roverOne.getCoordinateX());
        assertEquals(3, roverOne.getCoordinateY());
        assertEquals(NorthDirection.class, roverOne.getDirection().getClass());

        // 5 1 E
        assertEquals(5, roverTwo.getCoordinateX());
        assertEquals(1, roverTwo.getCoordinateY());
        assertEquals(EastDirection.class, roverTwo.getDirection().getClass());
    }
}
