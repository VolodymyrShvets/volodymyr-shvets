package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanB extends BaseBean implements BeanNameAware {
    private String beanName;

    public BeanB(String name, int value) {
        super(name, value);
    }

    public void init() {
        System.out.println(this.getClass() + " init method");
    }

    public void otherInit() {
        System.out.println(this.getClass() + " init method set by CustomBeanFactoryPostProcessor");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + " -> postConstruct method.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " -> preDestroy method.");
    }

    public void destroy() {
        System.out.println(this.getClass() + " destroy method");
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
