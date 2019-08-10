package com.naya.mock_data_annotation.annotation.inject_random;

import com.naya.mock_data_annotation.annotation.inject_random.handlers.MockRandomDataHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Component
public class InjectRandomAnnotationBeanPostProcessor implements BeanPostProcessor {


    private Map<MockDataType, MockRandomDataHandler> handlers;


    @Autowired
    private void initMap(List<MockRandomDataHandler> mockRandomDataList) {
        handlers = mockRandomDataList.stream().collect(toMap(MockRandomDataHandler::getType, v -> v));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            InjectRandom annotation = field.getAnnotation(InjectRandom.class);
            if (annotation != null) {
                MockDataType type = annotation.type();
                MockRandomDataHandler mockRandomDataHandler = handlers.get(type);
                String value = mockRandomDataHandler.data();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, value);
            }
        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
