package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.Validator;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BaseBean implements Validator {
    protected String beanName;
    private String name;
    private int value;

    public BaseBean() {
    }

    public BaseBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public void init() {
        System.out.println(beanName + " -> init method");
    }

    @Override
    public boolean validate() {
        return this.name != null && this.value >= 0;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(beanName + " -> postConstruct method.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(beanName + " -> preDestroy method.");
    }

    public void destroy() {
        System.out.println(beanName + " -> destroy method");
    }

    @Override
    public String toString() {
        return " says: name -> " + name + "; value -> " + value;
    }
}
