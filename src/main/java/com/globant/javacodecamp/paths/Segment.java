package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.List;

public record Segment(Point first,
                      Point second) {

    public BigDecimal distance(){
        return first.distance(second);
    }

    public boolean includesPoint(Point point) {
        return first().equals(point) || second().equals(point);
    }

    /*public boolean includesPoints(List<Point> points) {
        return points.stream()
                .allMatch(p -> p.equals(first) || p.equals(second));
    }*/

    public boolean includedPoint(Point point){
        return point.equals(first) || point.equals(second);
    }
}
