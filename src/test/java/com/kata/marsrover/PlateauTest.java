package com.kata.marsrover;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlateauTest extends BaseTest {

    @Test
    public void whenPlateauIsConstructedLowerLeftCoordinatesAreZeroZero() throws Exception {
        assertEquals(0, plateau.getLowerBoundCoordinateX());
        assertEquals(0, plateau.getLowerBoundCoordinateY());
    }
}
