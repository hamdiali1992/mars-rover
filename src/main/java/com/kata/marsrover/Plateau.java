package com.kata.marsrover;

public class Plateau {
    private final int lowerBoundCoordinateX = 0;
    private final int lowerBoundCoordinateY = 0;
    private final int upperBoundCoordinateX;
    private final int upperBoundCoordinateY;

    public Plateau(int upperBoundCoordinateX, int upperBoundCoordinateY) {
        this.upperBoundCoordinateX = upperBoundCoordinateX;
        this.upperBoundCoordinateY = upperBoundCoordinateY;
    }

    public int getUpperBoundCoordinateX() {
        return upperBoundCoordinateX;
    }

    public int getUpperBoundCoordinateY() {
        return upperBoundCoordinateY;
    }

    public int getLowerBoundCoordinateX() {
        return lowerBoundCoordinateX;
    }

    public int getLowerBoundCoordinateY() {
        return lowerBoundCoordinateY;
    }
}
