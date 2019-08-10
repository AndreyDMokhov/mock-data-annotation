package com.naya.mock_data_annotation.annotation.inject_random.handlers;


import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class EmailMockRandomDataHandlerImpl implements MockRandomDataHandler {

    @Override
    public String data() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());

        return fakeValuesService.bothify("????##@ya.com");
    }

    @Override
    public MockDataType getType() {
        return MockDataType.EMAIL;
    }
}
