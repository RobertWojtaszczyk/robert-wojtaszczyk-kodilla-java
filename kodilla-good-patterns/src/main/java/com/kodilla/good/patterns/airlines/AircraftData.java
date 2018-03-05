package com.kodilla.good.patterns.airlines;
import java.util.Objects;

public final class AircraftData {
    private final String aircraftSymbol;
    private final String flightSymbol;

    public AircraftData(final String aircraftSymbol, final String flightSymbol) {
        this.aircraftSymbol = aircraftSymbol;
        this.flightSymbol = flightSymbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AircraftData that = (AircraftData) o;
        return Objects.equals(aircraftSymbol, that.aircraftSymbol) &&
                Objects.equals(flightSymbol, that.flightSymbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aircraftSymbol);
    }

    @Override
    public String toString() {
        return "Aircraft: " + aircraftSymbol + ", Flight Symbol: " + flightSymbol + ";";
    }
}
