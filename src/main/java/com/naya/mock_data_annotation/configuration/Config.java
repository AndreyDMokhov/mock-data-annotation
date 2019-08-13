package com.naya.mock_data_annotation.configuration;

import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import com.naya.mock_data_annotation.annotation.inject_random.handlers.MockRandomDataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Configuration
public class Config {

    @Bean
    public Faker faker() {
        return Faker.instance();
    }

    @Bean
    public Map<MockDataType, MockRandomDataHandler> initMap(List<MockRandomDataHandler> mockRandomDataList) {
        return mockRandomDataList.stream().collect(toMap(MockRandomDataHandler::getType, v -> v));
    }

}
