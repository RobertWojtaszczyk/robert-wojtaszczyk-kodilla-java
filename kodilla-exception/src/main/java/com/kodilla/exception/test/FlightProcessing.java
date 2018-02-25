package com.kodilla.exception.test;
import java.util.HashMap;
import java.util.Map;

public class FlightProcessing {
    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        Map<String,Boolean> airports = new HashMap<>();
        airports.put("Atlanta", true);
        airports.put("O’Hare", false);
        airports.put("Los Angeles", true);
        airports.put("Dallas", false);
        airports.put("JFK", true);
        airports.put("San Francisco", true);
        airports.put("Charlotte", false);
        airports.put("Las Vegas", true);
        airports.put("Phoenix", false);
        airports.put("Houston", true);
        airports.put("Miami", false);
        if (airports.containsKey(flight.getArrivalAirport()))
            return airports.get(flight.getArrivalAirport());
        else {
            throw new RouteNotFoundException("Unknown airport");
        }
    }
}
