package com.kodilla.testing.weather.mock;
import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithMock(){
        //Given
        Temperatures temperaturesMock = mock(Temperatures.class);
        HashMap<Integer,Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put(0, 125.5);
        temperaturesMap.put(1, 126.2);
        temperaturesMap.put(2, 124.8);
        temperaturesMap.put(3, 125.2);
        temperaturesMap.put(4, 126.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);
        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        for (Map.Entry<Integer,Double> temperature : weatherForecast.calculateForecast().entrySet()){
            System.out.println(temperature.getKey() + " : " + temperature.getValue());
        }
        Assert.assertEquals(5,quantityOfSensors);
    }
}
