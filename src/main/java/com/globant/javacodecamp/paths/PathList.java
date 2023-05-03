package com.globant.javacodecamp.paths;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public record PathList(List<Path> paths) {

    public Optional<Path> shortestPath(){
        return paths.stream()
                .min(Comparator.comparing(Path::distance));
    }

    public Optional<Path> shortestPath(Point point){
        return paths.stream()
                .filter(p -> p.includesPoint(point))
                .min(Comparator.comparing(Path::distance));
    }

    /*private boolean includesPoint(Path path, Point point) {
        return path.segments()
                .stream()
                .anyMatch(s -> s.first().equals(point) || s.second().equals(point));
    }*/

}
