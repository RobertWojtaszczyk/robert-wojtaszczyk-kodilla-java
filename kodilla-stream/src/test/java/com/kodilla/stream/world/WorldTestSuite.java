package com.kodilla.stream.world;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent southAmerica = new Continent("South America");

        europe.addCountry(new Country("Poland", new BigDecimal("38000000")));
        europe.addCountry(new Country("Germany", new BigDecimal("82000000")));
        europe.addCountry(new Country("France", new BigDecimal("67000000")));

        asia.addCountry(new Country("China", new BigDecimal("1330044605")));
        asia.addCountry(new Country("Kazakhstan", new BigDecimal("15396929")));
        asia.addCountry(new Country("India", new BigDecimal("1147996000")));

        southAmerica.addCountry(new Country("Brazil", new BigDecimal("198739269")));
        southAmerica.addCountry(new Country("Argentina", new BigDecimal("40913584")));
        southAmerica.addCountry(new Country("Colombia", new BigDecimal("43677372")));

        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(southAmerica);
        //When
        BigDecimal totalPopulation = world.getPeopleQuantity();
        //Then
        BigDecimal expectedPopulation = new BigDecimal("2963767759");
        Assert.assertEquals(expectedPopulation,totalPopulation);
    }
}
