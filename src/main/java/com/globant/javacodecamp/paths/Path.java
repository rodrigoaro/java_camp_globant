package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public record Path(List<Segment> segments) {

    public BigDecimal distance(){
        //OLD WAY
        /*var distance = BigDecimal.ZERO;
        for(Segment segment: segments){
            distance = distance.add(segment.distance());
        }
        return distance;*/

        return segments.stream()
                .map(Segment::distance)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public boolean includesPoint(Point point) {
        return segments()
                .stream()
                .anyMatch(s -> s.includesPoint(point));
    }


    public boolean includesPoints(List<Point> points) {
        var pointsInPath = segments()
                .stream()
                .flatMap(s -> Stream.of(s.first(), s.second()))
                .collect(Collectors.toSet());

        return pointsInPath.containsAll(points);
    }

}
