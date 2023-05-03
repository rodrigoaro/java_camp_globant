package com.globant.javacodecamp.paths;

import java.math.BigDecimal;

public record Segment(Point first,
                      Point second) {

    public BigDecimal distance(){
        return first.distance(second);
    }

    public boolean includesPoint(Point point) {
        return first().equals(point) || second().equals(point);
    }
}
