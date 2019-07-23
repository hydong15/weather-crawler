package org.ajou.realcoding.weathercrawler.weathercrawler.repository;

import org.ajou.realcoding.weathercrawler.weathercrawler.domain.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CurrentWeatherRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    public void saveCurrentWeather(CurrentWeather currentWeather) {
        mongoTemplate.save(currentWeather);
    }

    public CurrentWeather findCurrentWeather(String cityName) {
        return mongoTemplate.findOne(Query.query(Criteria.where("name").is(cityName)), CurrentWeather.class);
    }
}
