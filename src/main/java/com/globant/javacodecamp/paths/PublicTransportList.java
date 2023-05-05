package com.globant.javacodecamp.paths;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public record PublicTransportList(List<PublicTransport> transports) {

    Optional<PathWithTransport> findFirstPublicTransportForTypeAndPath(PublicTransport.PublicTransportType type,
                                                                       Path path){

        return transports.stream()
                .filter(isRequestedType(type).and(t -> t.worksForPath(path)))
                .findFirst()
                .map(t -> new PathWithTransport(path, t));
    }

    private static Predicate<PublicTransport> isRequestedType(PublicTransport.PublicTransportType type) {
        return t -> t.publicTransportType().equals(type);
    }


}
