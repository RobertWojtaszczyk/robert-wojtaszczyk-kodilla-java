package com.kodilla.good.patterns.airlines;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchFlight {
    public Map<AircraftData, Flight> searchDestination(Map<AircraftData, Flight> flights, String destination) {
        return flights.entrySet().stream()
                .filter(from-> from.getValue().getFlyingTo().equals(destination))
                //.sorted((o1, o2)->o1.getValue().getDepartureTime().compareTo(o2.getValue().getDepartureTime()))
                .sorted(Comparator.comparing(departure -> departure.getValue().getDepartureTime())) // referencja do metody??? jak wywołać?
                .collect(Collectors.toMap(data -> data.getKey(), data -> data.getValue()));
    }
    public Map<AircraftData, Flight> searchOrigin(Map<AircraftData, Flight> flights, String origin) {
        return flights.entrySet().stream()
                .filter(from-> from.getValue().getFlyingFrom().equals(origin))
                .sorted(Comparator.comparing(departure -> departure.getValue().getDepartureTime())) // referencja do metody??? jak wywołać?
                .collect(Collectors.toMap(data -> data.getKey(), data -> data.getValue()));
    }
    public Map<AircraftData, Flight> searchOriginToDestination(Map<AircraftData, Flight> flights, String origin, String destination) {
        return flights.entrySet().stream()
                .filter(flight -> flight.getValue().getFlyingTo() == destination && flight.getValue().getFlyingFrom().equals(origin))
                .sorted(Comparator.comparing(departure -> departure.getValue().getDepartureTime())) // referencja do metody??? jak wywołać?
                .collect(Collectors.toMap(data -> data.getKey(), data -> data.getValue()));
    }
    public Map<AircraftData, Flight> searchOriginToDestinationWithStopover(Map<AircraftData, Flight> flights, String origin, String destination) {
        Map<AircraftData, Flight> originSet = searchOrigin(flights, origin);
        Map<AircraftData, Flight> destinationSet = searchDestination(flights, destination);

        originSet.putAll(destinationSet);
        originSet.entrySet().stream()
                .filter(originToStopover -> destinationSet.entrySet().stream()
                        .anyMatch(destinationFromStopover ->
                                (destinationFromStopover.getValue().getFlyingFrom().equals(originToStopover.getValue().getFlyingTo())
                                        && originToStopover.getValue().getDepartureTime().plusMinutes(originToStopover.getValue().getFlightTimeInMinutes())
                                        .isBefore(destinationFromStopover.getValue().getDepartureTime().minusMinutes(120)))))
                .forEach(data -> System.out.println(data.getValue()));

        return originSet;
    }
}
