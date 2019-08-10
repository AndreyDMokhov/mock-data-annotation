package com.naya.mock_data_annotation.annotation.inject_random.handlers;

import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberMockRandomDataHandlerImpl implements MockRandomDataHandler {
    @Override
    public String data() {
        Faker faker = new Faker();
        return faker.phoneNumber().phoneNumber();
    }

    @Override
    public MockDataType getType() {
        return MockDataType.PHONE_NUMBER;
    }
}
