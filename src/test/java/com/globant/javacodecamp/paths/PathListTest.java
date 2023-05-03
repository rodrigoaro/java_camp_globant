package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PathListTest {

    @Test
    void testShortestPath(){

        var path1 = new Path(List.of(new Segment(
                        new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                        new Point(BigDecimal.ZERO, BigDecimal.ZERO)
                ),
                new Segment(
                        new Point(BigDecimal.ZERO, BigDecimal.ONE),
                        new Point(BigDecimal.ONE, BigDecimal.ONE)
                )
        )
        );
        var path2 = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.TEN, BigDecimal.ONE),
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        )
                )
        );

        var pathList = new PathList(List.of(path1, path2));

        var optionalPath  = pathList.shortestPath();
        assertTrue(optionalPath.isPresent());

        assertEquals(path1, optionalPath.get());
    }

    @Test
    void testShortestPathWhenEmpty(){

        var pathList = new PathList(Collections.emptyList());

        var optionalPath  = pathList.shortestPath();

        assertFalse(optionalPath.isPresent());
    }

    @Test
    void testShortestPathIncludingPoint(){

        var path1 = new Path(List.of(new Segment(
                        new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                        new Point(BigDecimal.ZERO, BigDecimal.ZERO)
                ),
                new Segment(
                        new Point(BigDecimal.ZERO, BigDecimal.ONE),
                        new Point(BigDecimal.ONE, BigDecimal.ONE)
                )
        )
        );

        var includingPoint = new Point(BigDecimal.TEN, BigDecimal.ONE);

        var path2 = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                includingPoint,
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        )
                )
        );

        var pathList = new PathList(List.of(path1, path2));

        var optionalPath  = pathList.shortestPath(includingPoint);
        assertTrue(optionalPath.isPresent());

        assertEquals(path2, optionalPath.get());
    }

}