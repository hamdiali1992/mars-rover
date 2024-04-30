package com.kata.marsrover.command;

import com.kata.marsrover.rover.RoverUtils;

public class SpinRightCommand implements Command {

    @Override
    public void execute(RoverUtils rover) {
        rover.spinRight();
    }
}
