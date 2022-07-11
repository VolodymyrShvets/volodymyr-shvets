package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanF extends BaseBean implements BeanNameAware {
    @Override
    public String toString() {
        return beanName + super.toString();
    }

    @Override
    public void setBeanName(String s) {
        beanName = s;
    }
}
