package com.kodilla.good.patterns.airlines.data;
import com.kodilla.good.patterns.airlines.AircraftData;
import com.kodilla.good.patterns.airlines.Flight;
import com.kodilla.good.patterns.airlines.Flights;
import java.time.LocalDateTime;
import java.util.Map;

public final class Data {
    public static Map<AircraftData, Flight> createFlights() {
        Flights flights = new Flights();
        flights.addFlights(new AircraftData("ABC121", "ASD120"), new Flight("Katowice", "Warszawa", LocalDateTime.now().plusMinutes(1950), 180));
        flights.addFlights(new AircraftData("ABC122", "ASD121"), new Flight("Krakow", "Wroclaw", LocalDateTime.now().plusMinutes(2000), 160));
        flights.addFlights(new AircraftData("ABC123", "ASD122"), new Flight("Warszawa", "Krakow", LocalDateTime.now().plusMinutes(2100), 190));
        flights.addFlights(new AircraftData("ABC124", "ASD123"), new Flight("Wroclaw", "Radom", LocalDateTime.now().plusMinutes(2300), 120));
        flights.addFlights(new AircraftData("ABC125", "ASD124"), new Flight("Radom", "Gdansk", LocalDateTime.now().plusMinutes(2300), 140));
        flights.addFlights(new AircraftData("ABC121", "ASD125"), new Flight("Gdansk", "Katowice", LocalDateTime.now().plusMinutes(2500), 210));
        flights.addFlights(new AircraftData("ABC122", "ASD126"), new Flight("Krakow", "Warszawa", LocalDateTime.now().plusMinutes(2500), 150));
        flights.addFlights(new AircraftData("ABC123", "ASD127"), new Flight("Warszawa", "Wroclaw", LocalDateTime.now().plusMinutes(2600), 140));
        flights.addFlights(new AircraftData("ABC124", "ASD128"), new Flight("Katowice", "Krakow", LocalDateTime.now().plusMinutes(2650), 180));
        flights.addFlights(new AircraftData("ABC125", "ASD129"), new Flight("Warszawa", "Radom", LocalDateTime.now().plusMinutes(2800), 160));
        flights.addFlights(new AircraftData("ABC121", "ASD130"), new Flight("Wroclaw", "Gdansk", LocalDateTime.now().plusMinutes(2800), 120));
        flights.addFlights(new AircraftData("ABC122", "ASD131"), new Flight("Radom", "Katowice", LocalDateTime.now().plusMinutes(2900), 170));
        flights.addFlights(new AircraftData("ABC123", "ASD132"), new Flight("Gdansk", "Warszawa", LocalDateTime.now().plusMinutes(2900), 200));
        flights.addFlights(new AircraftData("ABC124", "ASD133"), new Flight("Katowice", "Wroclaw", LocalDateTime.now().plusMinutes(3000), 180));
        flights.addFlights(new AircraftData("ABC125", "ASD134"), new Flight("Warszawa", "Krakow", LocalDateTime.now().plusMinutes(3000), 180));
        flights.addFlights(new AircraftData("ABC121", "ASD135"), new Flight("Krakow", "Radom", LocalDateTime.now().plusMinutes(3100), 240));
        flights.addFlights(new AircraftData("ABC122", "ASD136"), new Flight("Warszawa", "Gdansk", LocalDateTime.now().plusMinutes(3150), 180));
        flights.addFlights(new AircraftData("ABC123", "ASD137"), new Flight("Wroclaw", "Katowice", LocalDateTime.now().plusMinutes(3200), 140));
        flights.addFlights(new AircraftData("ABC124", "ASD138"), new Flight("Radom", "Warszawa", LocalDateTime.now().plusMinutes(3300), 200));
        flights.addFlights(new AircraftData("ABC125", "ASD139"), new Flight("Gdansk", "Wroclaw", LocalDateTime.now().plusMinutes(3350), 180));
        flights.addFlights(new AircraftData("ABC121", "ASD140"), new Flight("Katowice", "Krakow", LocalDateTime.now().plusMinutes(3400), 170));
        flights.addFlights(new AircraftData("ABC122", "ASD141"), new Flight("Warszawa", "Radom", LocalDateTime.now().plusMinutes(3400), 180));
        flights.addFlights(new AircraftData("ABC123", "ASD142"), new Flight("Krakow", "Gdansk", LocalDateTime.now().plusMinutes(3500), 210));
        flights.addFlights(new AircraftData("ABC124", "ASD143"), new Flight("Warszawa", "Katowice", LocalDateTime.now().plusMinutes(3550), 200));
        flights.addFlights(new AircraftData("ABC125", "ASD144"), new Flight("Wroclaw", "Warszawa", LocalDateTime.now().plusMinutes(3600), 180));
        return flights.getFlights();
    }
}
