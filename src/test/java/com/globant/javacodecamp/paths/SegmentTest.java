package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    @Test
    void testDistance(){
        var segment = new Segment(
                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                new Point(BigDecimal.ZERO, BigDecimal.ONE)
        );
        assertEquals(BigDecimal.ONE, segment.distance());

        var segment2 = new Segment(
                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                new Point(BigDecimal.ZERO, BigDecimal.ONE)
        );
        assertEquals(BigDecimal.ONE, segment2.distance());
    }

}