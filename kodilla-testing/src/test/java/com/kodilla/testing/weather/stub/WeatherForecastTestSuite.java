package com.kodilla.testing.weather.stub;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithStub(){
        //Given
        Temperatures temperatures = new TemperaturesStub();
        WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        for (Map.Entry<Integer,Double> temperature : weatherForecast.calculateForecast().entrySet()){
            System.out.println(temperature.getKey() + " : " + temperature.getValue());
        }
        Assert.assertEquals(5,quantityOfSensors);
    }
}
