package com.kodilla.good.patterns.airlines;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchFlight {
    public Map<AircraftData, Flight> searchDestination(Map<AircraftData, Flight> flights, String destination) {
        return flights.entrySet().stream()
                .filter(to -> to.getValue().getFlyingTo().equals(destination))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<AircraftData, Flight> searchOrigin(Map<AircraftData, Flight> flights, String origin) {
        return flights.entrySet().stream()
                .filter(from-> from.getValue().getFlyingFrom().equals(origin))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<AircraftData, Flight> searchOriginToDestinationWithStopover(Map<AircraftData, Flight> flights, String origin, String destination) {
        Map<AircraftData, Flight> originSet = searchOrigin(flights, origin);
        Map<AircraftData, Flight> destinationSet = searchDestination(flights, destination);

        Map<AircraftData, Flight> stopover1Step = originSet.entrySet().stream()
                .filter(originToStopover -> destinationSet.entrySet().stream()
                        .anyMatch(destinationFromStopover ->
                                (destinationFromStopover.getValue().getFlyingFrom().equals(originToStopover.getValue().getFlyingTo())
                                        && originToStopover.getValue().getDepartureTime().plusMinutes(originToStopover.getValue().getFlightTimeInMinutes())
                                        .isBefore(destinationFromStopover.getValue().getDepartureTime().minusMinutes(120)))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Map<AircraftData, Flight> stopover2Step = destinationSet.entrySet().stream()
                .filter(destinationFromStopover -> stopover1Step.entrySet().stream()
                        .anyMatch(stopover ->
                                (stopover.getValue().getFlyingTo().equals(destinationFromStopover.getValue().getFlyingFrom()))))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        stopover1Step.putAll(stopover2Step);
        return stopover1Step;
    }
}
/**
 * Nie dałem rady zrobić wyszukiwania z przesiadką w jednym stream'ie. Zrobiłem to tak, że najpierw do mapy stopover1Step zapisuję loty do
 * miejsca pośredniego, potem do mapy stopover2Step zapisuję loty z miejsca pośredniego do końcowego i na końcu łączę te mapy
* */