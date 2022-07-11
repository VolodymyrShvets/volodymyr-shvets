package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanE extends BaseBean implements BeanNameAware {
    @Override
    public String toString() {
        return beanName + super.toString();
    }

    @Override
    public void setBeanName(String s) {
        beanName = s;
    }
}
