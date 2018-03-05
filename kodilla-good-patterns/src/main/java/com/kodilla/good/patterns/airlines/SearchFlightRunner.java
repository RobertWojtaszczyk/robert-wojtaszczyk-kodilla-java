package com.kodilla.good.patterns.airlines;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import static com.kodilla.good.patterns.airlines.data.Data.createFlights;

public class SearchFlightRunner {
    public static void main(String[] args) {
        Map<AircraftData, Flight> flights = createFlights();
        SearchFlight searchFlight = new SearchFlight();
        Map<AircraftData, Flight> searchResult;

        System.out.println("\n*** Search example: all to Destination ***");
        searchResult = searchFlight.searchDestination(flights, "Radom");
        searchResult = searchResult.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().getDepartureTime()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<AircraftData,Flight> entry : searchResult.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\n*** Search example: from Origin to all ***");
        searchResult = searchFlight.searchOrigin(flights,"Gdansk");
        searchResult = searchResult.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().getDepartureTime()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<AircraftData,Flight> entry : searchResult.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\n*** Search example: from Origin to Destination With Stopover ***");
        searchResult = searchFlight.searchOriginToDestinationWithStopover(flights, "Katowice", "Wroclaw");
        searchResult = searchResult.entrySet().stream()
                .sorted(Comparator.comparing(entry -> entry.getValue().getDepartureTime()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<AircraftData,Flight> entry : searchResult.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}