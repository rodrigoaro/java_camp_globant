package com.globant.javacodecamp.paths;

import java.util.List;
import java.util.Optional;

public class PathService {

    public Result<PathWithTransport> findPathWithTransport(List<Point> pointList,
                                          PathList pathList,
                                          PublicTransportList publicTransportList,
                                          PublicTransport.PublicTransportType publicTransportType){

        System.out.println("Thread name for findPathWithTransport is: " + Thread.currentThread().getName());
        System.out.println("Finding paths...");
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("Path found...");

        return pathList.shortestPath(pointList)
                .flatMap(path -> publicTransportList.findFirstPublicTransportForTypeAndPath(publicTransportType, path))
                .map(Result::success)
                .orElse(Result.error(404, "Path with Transport not found"));
                 /*.ifPresentOrElse(
                         pathWithTransport -> System.out.println("The path found for the Transport was: "+ pathWithTransport),
                         () -> System.out.println("There was no path found for that public transport type")
                 );*/
    }

    public static void main(String[] ags){

        /*var pathService = new PathService();
        var pathList = new PathList(Collections.singletonList(createPath()));
        var publicTransport = createPublicTransport();
        var publicTransportList = new PublicTransportList(Collections.singletonList(publicTransport));
        var listOfPoints = List.of(new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                    new Point(BigDecimal.ZERO, BigDecimal.ONE));

        pathService.findPathWithTransport(listOfPoints,
                                        pathList,
                                        publicTransportList,
                                        PublicTransport.PublicTransportType.BUS);*/

    }

}
