package com.naya.mock_data_annotation.annotation.inject_random.handlers;

import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NameMockRandomDataHandlerImpl implements MockRandomDataHandler {

    private Faker faker;

    @Override
    public String data() {

        return faker.name().firstName();
    }

    @Override
    public MockDataType getType() {
        return MockDataType.NAME;
    }
}
