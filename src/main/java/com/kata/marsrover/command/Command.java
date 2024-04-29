package com.kata.marsrover.command;

import com.kata.marsrover.rover.RoverUtils;

public interface Command {

    void execute(RoverUtils rover);
}
