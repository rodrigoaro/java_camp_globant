package com.globant.javacodecamp.paths;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PublicTransportTest {

    @Test
    void testWorksForPathWhenItDoesAndOnlyTwoPointsInPath(){
        var path = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ONE),
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        )
                )
        );

        var transportPath = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ONE),
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ONE, BigDecimal.ONE),
                                new Point(BigDecimal.TEN, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.TEN, BigDecimal.ONE),
                                new Point(BigDecimal.TEN, BigDecimal.TEN)
                        )
                )
        );

        var publicTransport = new PublicTransport(PublicTransport.PublicTransportType.BUS, transportPath);

        assertTrue(publicTransport.worksForPath(path));
    }

    @Test
    void testWorksForPathWhenItDoesNot(){
        var path = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ONE),
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        )
                )
        );

        var transportPath = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ONE),
                                new Point(BigDecimal.ZERO, new BigDecimal(100))
                        ),
                        new Segment(
                                new Point(BigDecimal.ONE, BigDecimal.TEN),
                                new Point(BigDecimal.TEN, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.TEN, BigDecimal.ONE),
                                new Point(BigDecimal.TEN, BigDecimal.TEN)
                        )
                )
        );

        var publicTransport = new PublicTransport(PublicTransport.PublicTransportType.BUS, transportPath);

        assertFalse(publicTransport.worksForPath(path));
    }


    @Test
    void testWorksForPathWhenItDoesAndOnlyThreePointsInPath(){
        var path = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(new BigDecimal(10), new BigDecimal(10)),
                                new Point(new BigDecimal(20), new BigDecimal(20))
                        ),
                        new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ONE),
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        )
                )
        );

        var transportPath = new Path(
                List.of(new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                new Point(BigDecimal.ZERO, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ZERO, BigDecimal.ONE),
                                new Point(BigDecimal.ONE, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.ONE, BigDecimal.ONE),
                                new Point(BigDecimal.TEN, BigDecimal.ONE)
                        ),
                        new Segment(
                                new Point(BigDecimal.TEN, BigDecimal.ONE),
                                new Point(BigDecimal.TEN, BigDecimal.TEN)
                        )
                )
        );

        var publicTransport = new PublicTransport(PublicTransport.PublicTransportType.BUS, transportPath);

        assertTrue(publicTransport.worksForPath(path));
    }
}