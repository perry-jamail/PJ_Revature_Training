package com.revature.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class WeatherServiceTestStubAndMock {

    @Test
    public void testWeatherServiceWithStubAndMock() {
        WeatherApiClient apiClient = Mockito.mock(WeatherApiClient.class);

        // STUBBING: Define what the mock should return, always static (hard-coded)
        Mockito.when(apiClient.fetchTemperature("Plano")).thenReturn(35.0);

        WeatherService weatherService = new WeatherService(apiClient);

        String message = weatherService.getWeatherMessage("Plano");
        assertEquals("It's Hot in Plano", message);

        Mockito.verify(apiClient, times(1)).fetchTemperature("Plano");
    }
}
