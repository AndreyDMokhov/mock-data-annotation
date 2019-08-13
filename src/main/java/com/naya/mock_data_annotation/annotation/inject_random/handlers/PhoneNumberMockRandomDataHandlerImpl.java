package com.naya.mock_data_annotation.annotation.inject_random.handlers;

import com.github.javafaker.Faker;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhoneNumberMockRandomDataHandlerImpl implements MockRandomDataHandler {

    private Faker faker;

    @Override
    public String data() {

        return faker.phoneNumber().cellPhone();
    }

    @Override
    public MockDataType getType() {
        return MockDataType.PHONE_NUMBER;
    }
}
