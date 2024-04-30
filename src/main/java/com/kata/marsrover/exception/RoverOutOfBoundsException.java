package com.kata.marsrover.exception;

public class RoverOutOfBoundsException extends RuntimeException {

    public RoverOutOfBoundsException() {
        super("The Rover cannot be out of the plateau!");
    }
}
