package com.epam.spring.homework2.bpp;

import com.epam.spring.homework2.validation.Validator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Validator) {
            ((Validator) bean).validate();
            System.out.println("Validation for " + beanName + " successfully performed.");
        }
        return bean;
    }
}
