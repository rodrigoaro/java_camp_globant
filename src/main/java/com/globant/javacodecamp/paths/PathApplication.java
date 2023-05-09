package com.globant.javacodecamp.paths;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class PathApplication {

    public static void main(String[] args) {
        /*IntStream.range(0, 10)
                .mapToObj(String::valueOf)
                .forEach(System.out::println);*/

        /*Stream.of("Mary", "Paul", "Peter")
                .flatMap(s -> s.chars().mapToObj(i -> (char)i))
                .map(s -> s.toString().toUpperCase())
                .filter(s -> !s.equals("E"))
                .forEach(System.out::println);*/

        var pathService = new PathService();
        var notificationService = new NotificationService();

        /*var voidCompletableFuture = CompletableFuture.supplyAsync(() -> getPathWithTransport(pathService))
                .thenAccept(pathWithTransportOpt -> pathWithTransportOpt.ifPresent(notificationService::notifyUser));

        System.out.println("Thread name for main function is: " + Thread.currentThread().getName());
        System.out.println("Process completed");

        voidCompletableFuture.join(); */

        getPathWithTransport(pathService)
                .flatMap(notificationService::notifyUser)
                .ifSuccessOrElse(System.out::println, statusAndMessage ->
                        System.out.println("Error finding path. Status was "+ statusAndMessage.status() +
                                            " and message " + statusAndMessage.message()));

    }

    private static Result<PathWithTransport> getPathWithTransport(PathService pathService) {

        return pathService.findPathWithTransport(List.of(
                                            new Point(BigDecimal.ZERO, BigDecimal.ZERO),
                                            new Point(BigDecimal.ZERO, BigDecimal.ONE)),
                                            new PathList(List.of(createPath())),
                                            new PublicTransportList(List.of(createPublicTransport())),
                                            PublicTransport.PublicTransportType.BUS);
                                            //.ifPresent(notificationService::notifyUser);
    }

    static PublicTransport createPublicTransport(){
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

        return new PublicTransport(PublicTransport.PublicTransportType.BUS, transportPath);
    }

    static Path createPath(){

        return new Path(
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
    }


}
