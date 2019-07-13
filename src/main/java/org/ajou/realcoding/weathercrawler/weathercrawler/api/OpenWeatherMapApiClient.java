package org.ajou.realcoding.weathercrawler.weathercrawler.api;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapApiClient {
    private final String appid = "ed47fd9ca2f0ce282cf330ecfd9fa587";
    private final String openWeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid={appid}";
    @Autowired
    RestTemplate restTemplate;

    public CurrentWeather requestCurrentWeather(String cityName) {
        return restTemplate.exchange(openWeatherUrl, HttpMethod.GET, null, CurrentWeather.class, cityName, appid).getBody();
    }
}
