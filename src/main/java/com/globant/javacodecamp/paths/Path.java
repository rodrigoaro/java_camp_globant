package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.List;

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


}
