package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanA extends BaseBean implements BeanNameAware, InitializingBean, DisposableBean {
    public BeanA() {
        System.out.println(this.getClass().getSimpleName() + " -> no args constructor");
    }

    @Override
    public void setBeanName(String s) {
        beanName = s;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println(beanName + " -> initializingBean afterPropertiesSet method");
    }

    @Override
    public void postConstruct() {

    }

    @Override
    public void preDestroy() {

    }

    @Override
    public void destroy() {
        System.out.println(beanName + " -> disposableBean destroy method");
    }

    @Override
    public String toString() {
        return beanName + super.toString();
    }
}
