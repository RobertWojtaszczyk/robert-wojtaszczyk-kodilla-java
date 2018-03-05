package com.kodilla.good.patterns.airlines;
import java.util.Map;
import static com.kodilla.good.patterns.airlines.data.Data.createFlights;

public class SearchFlightRunner {
    public static void main(String[] args) {
        Map<AircraftData, Flight> flights = createFlights();
        SearchFlight searchFlight = new SearchFlight();

        System.out.println("\n*** Search example: all to Destination ***");
        for (Map.Entry<AircraftData,Flight> entry : searchFlight.searchDestination(flights, "Krakow").entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\n*** Search example: from Origin to all ***");
        for (Map.Entry<AircraftData,Flight> entry : searchFlight.searchOrigin(flights,"Warszawa").entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\n*** Search example: from Origin to Destination ***");
        for (Map.Entry<AircraftData,Flight> entry : searchFlight.searchOriginToDestination(flights, "Katowice", "Wroclaw").entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("\n*** Search example: from Origin to Destination With Stopover ***");
        for (Map.Entry<AircraftData,Flight> entry : searchFlight.searchOriginToDestinationWithStopover(flights, "Katowice", "Wroclaw").entrySet()) {
            System.out.println(entry.getValue());
        }

    }
}
