package com.kata.marsrover.direction;

public enum DirectionLookup {

    N(new NorthDirection()),

    E(new EastDirection()),

    S(new SouthDirection()),

    W(new WestDirection());

    private final Direction direction;

    DirectionLookup(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }
}
