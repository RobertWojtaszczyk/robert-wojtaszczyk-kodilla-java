package com.kodilla.good.patterns.airlines;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Flight {
    private final String flyingFrom; //?class Airport?
    private final String flyingTo; //?class Airport?
    private final LocalDateTime departureTime;
    private final int flightTimeInMinutes;

    public Flight(final String flyingFrom, final String flyingTo, final LocalDateTime departureTime, final int flightTimeInMinutes) {
        this.flyingFrom = flyingFrom;
        this.flyingTo = flyingTo;
        this.departureTime = departureTime;
        this.flightTimeInMinutes = flightTimeInMinutes;
    }

    public String getFlyingFrom() {
        return flyingFrom;
    }

    public String getFlyingTo() {
        return flyingTo;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getFlightTimeInMinutes() {
        return flightTimeInMinutes;
    }

    @Override
    public String toString() {
        return "\nFrom: " + flyingFrom + "\tTo: " + flyingTo + "\nDeparture Time: " + departureTime.format(DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm")) + "\tFlight time: " + flightTimeInMinutes + " minutes.";
    }
}
