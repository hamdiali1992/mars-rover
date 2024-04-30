package com.kata.marsrover;

import com.kata.marsrover.command.*;
import com.kata.marsrover.direction.NorthDirection;
import com.kata.marsrover.rover.RoverUtils;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class InputUtilsTest extends BaseTest {

    @Test
    public void inputStringsCanBeParsedFromFile() throws Exception {
        InputStream testFileInputStream = getClass().getResourceAsStream("/testInput.txt");
        String expectedInputStringOne = "5 5";
        String expectedInputStringTwo = "1 2 N";
        String expectedInputStringThree = "LMLMLMLMM";
        String expectedInputStringFour = "3 3 E";
        String expectedInputStringFive = "MMRMMRMRRM";
        ArrayList<String> testFileLines = InputUtils.parseInputFromFile(testFileInputStream);

        assertEquals(5, testFileLines.size());
        assertEquals(expectedInputStringOne, testFileLines.get(0));
        assertEquals(expectedInputStringTwo, testFileLines.get(1));
        assertEquals(expectedInputStringThree, testFileLines.get(2));
        assertEquals(expectedInputStringFour, testFileLines.get(3));
        assertEquals(expectedInputStringFive, testFileLines.get(4));
    }

    @Test
    public void whenPlateauInputIsParsedPlateauIsInstructed() throws Exception {
        String plateauInput = "5 5";
        Plateau plateauOutput = InputUtils.parsePlateauInput(plateauInput);

        assertEquals(0, plateauOutput.getLowerBoundCoordinateX());
        assertEquals(0, plateauOutput.getLowerBoundCoordinateY());
        assertEquals(5, plateauOutput.getUpperBoundCoordinateX());
        assertEquals(5, plateauOutput.getUpperBoundCoordinateY());
    }

    @Test
    public void whenPositionInputIsParsedRoverIsInstructed() throws Exception {
        String positionInput = "1 2 N";
        RoverUtils roverOutput = InputUtils.parsePositionInput(positionInput, plateau);

        assertEquals(1, roverOutput.getCoordinateX());
        assertEquals(2, roverOutput.getCoordinateY());
        assertEquals(NorthDirection.class, roverOutput.getDirection().getClass());
    }

    @Test
    public void whenRCommandIsParsedSpinRightCommandIsInstructed() throws Exception {
        String rCommandInput = "R";
        ArrayList<Command> commandOutput = InputUtils.parseCommandInput(rCommandInput);

        assertEquals(rCommandInput.length(), commandOutput.size());
        assertEquals(SpinRightCommand.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenLCommandIsParsedSpinLeftCommandIsInstructed() throws Exception {
        String lCommandInput = "L";
        ArrayList<Command> commandOutput = InputUtils.parseCommandInput(lCommandInput);

        assertEquals(lCommandInput.length(), commandOutput.size());
        assertEquals(SpinLeftCommand.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenMCommandIsParsedMoveForwardCommandIsInstructed() throws Exception {
        String mCommandInput = "M";
        ArrayList<Command> commandOutput = InputUtils.parseCommandInput(mCommandInput);

        assertEquals(mCommandInput.length(), commandOutput.size());
        assertEquals(MoveForwardCommand.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenBCommandIsParsedMoveBackCommandIsInstructed() throws Exception {
        String mCommandInput = "B";
        ArrayList<Command> commandOutput = InputUtils.parseCommandInput(mCommandInput);

        assertEquals(mCommandInput.length(), commandOutput.size());
        assertEquals(MoveBackCommand.class, commandOutput.get(0).getClass());
    }

    @Test
    public void whenMultipleCommandsAreParsedCommandListIsInstructed() throws Exception {
        String multiCommandInput = "RLM";
        ArrayList<Command> commandOutput = InputUtils.parseCommandInput(multiCommandInput);

        assertEquals(multiCommandInput.length(), commandOutput.size());
        assertEquals(SpinRightCommand.class, commandOutput.get(0).getClass());
        assertEquals(SpinLeftCommand.class, commandOutput.get(1).getClass());
        assertEquals(MoveForwardCommand.class, commandOutput.get(2).getClass());
    }
}
