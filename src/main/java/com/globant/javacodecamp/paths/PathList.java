package com.globant.javacodecamp.paths;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public record PathList(List<Path> paths) {

    /*public Optional<Path> shortestPath(){
        return paths.stream()
                .min(Comparator.comparing(Path::distance));
    }*/

    public Optional<Path> shortestPath(){
        return shortestPathWithCondition(p -> true);
    }

    /*public Optional<Path> shortestPath(Point point){
        return paths.stream()
                .filter(p -> p.includesPoint(point))
                .min(Comparator.comparing(Path::distance));
    }*/

    public Optional<Path> shortestPath(Point point){
        return shortestPathWithCondition(p -> p.includesPoint(point));
    }

    //OLD
    /*private boolean includesPoint(Path path, Point point) {
        return path.segments()
                .stream()
                .anyMatch(s -> s.first().equals(point) || s.second().equals(point));
    }*/

    /*public Optional<Path> shortestPath(List<Point> points){
        return paths.stream()
                .filter(p -> p.includesPoints(points))
                .min(Comparator.comparing(Path::distance));
    }*/

    public Optional<Path> shortestPath(List<Point> points){
        return shortestPathWithCondition(p -> p.includesPoints(points));
    }

    private Optional<Path> shortestPathWithCondition(Predicate<Path> condition){
        return paths.stream()
                .filter(condition)
                .min(Comparator.comparing(Path::distance));
    }

}
