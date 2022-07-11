package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class BeanB extends BaseBean implements BeanNameAware {
    public BeanB(String name, int value) {
        super(name, value);
    }

    public void otherInit() {
        System.out.println(beanName + " -> init method set by CustomBeanFactoryPostProcessor");
    }

    @Override
    public void setBeanName(String s) {
        beanName = s;
    }

    @Override
    public String toString() {
        return beanName + super.toString();
    }
}
