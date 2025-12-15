package com.revature.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class WeatherServiceTestMock {

    @Test
    public void testMockDemo() {
        WeatherApiClient apiClient = Mockito.mock(WeatherApiClient.class);

        WeatherService weatherService = new WeatherService(apiClient);

        weatherService.refresh("Frisco");
        Mockito.verify(apiClient, times(1)).fetchTemperature("Plano");
    }
}
