package com.kodilla.exception.test;
import java.util.ArrayList;

public class FlightRunner {
    public static void main(String[] args) {
        ArrayList<Flight> flights = new ArrayList<>();
        flights.add(new Flight("Atlanta", "O’Hare"));
        flights.add(new Flight("Dallas", "JFK"));
        flights.add(new Flight("San Francisco", "Atlant"));
        flights.add(new Flight("Phoenix", "Las Vegas"));
        flights.add(new Flight("Miami", "Atlanta"));

        FlightProcessing flightProcessing = new FlightProcessing();
        boolean isFlightPossible = false;

        for (Flight flight : flights){
            try {
                isFlightPossible = flightProcessing.findFlight(flight);
            } catch (RouteNotFoundException e) {
                System.out.println("Route not found to airport " + flight.getArrivalAirport() + "! Error: " + e);
                isFlightPossible = false;
            } finally {
                String flightStatus = isFlightPossible ? "OK" : "Not possible";
                System.out.println("Flight status from " + flight.getDepartureAirport() + " to " + flight.getArrivalAirport() + ": " + flightStatus + "\n");
            }
        }
    }
}
