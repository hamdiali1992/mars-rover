package com.kata.marsrover;

import com.kata.marsrover.command.Command;
import com.kata.marsrover.rover.RoverUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Rover {

    public static void main(String[] args) throws IOException {

        ArrayList<String> inputFileAsList = InputUtil.parseInputFromFile(Rover.class.getResourceAsStream("/input.txt"));
        List<String> roverInput = inputFileAsList.subList(1, inputFileAsList.size());

        System.out.println("\n" + "Output:" + "\n");
        Plateau plateau = InputUtil.parsePlateauInput(inputFileAsList.get(0));

        for (int i = 0; i < roverInput.size(); i += 2) {
            RoverUtils rover = InputUtil.parsePositionInput(roverInput.get(i), plateau);
            ArrayList<Command> commands = InputUtil.parseCommandInput(roverInput.get(i + 1));
            rover.executeCommandList(commands);
            System.out.println(rover.broadcastLocation());
        }
    }
}
