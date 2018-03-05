package com.kodilla.good.patterns.airlines;
import java.util.HashMap;
import java.util.Map;

public final class Flights {
    private final Map<AircraftData, Flight> flights;

    public Flights() {
        this.flights = new HashMap<>();
    }

    public void addFlights (AircraftData aircraftData, Flight flight) {
        flights.put(aircraftData, flight);
    }
    public Map<AircraftData, Flight> getFlights() {
        return flights;
    }

}
