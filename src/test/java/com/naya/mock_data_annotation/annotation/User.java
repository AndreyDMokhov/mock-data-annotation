package com.naya.mock_data_annotation.annotation;

import com.naya.mock_data_annotation.annotation.inject_random.InjectRandom;
import com.naya.mock_data_annotation.annotation.inject_random.MockDataType;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
public class User {

    @InjectRandom(type = MockDataType.NAME)
    private String name;
    @InjectRandom(type = MockDataType.PHONE_NUMBER)
    private String phoneNumber;
    @InjectRandom(type = MockDataType.EMAIL)
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
