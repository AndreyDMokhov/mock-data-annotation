package com.naya.mock_data_annotation.annotation.inject_random.handlers;

import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import org.springframework.stereotype.Service;

@Service
public class NameMockRandomDataHandlerImpl implements MockRandomDataHandler {
    @Override
    public String data() {
        Faker faker = new Faker();

        return faker.name().firstName();
    }

    @Override
    public MockDataType getType() {
        return MockDataType.NAME;
    }
}
