package com.epam.spring.homework2.bpp;

import com.epam.spring.homework2.beans.BeanB;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        for (String bean : factory.getBeanDefinitionNames()) {
            if (factory.getType(bean) == BeanB.class) {
                BeanDefinition beanBDefinition = factory.getBeanDefinition(bean);
                beanBDefinition.setInitMethodName("otherInit");
            }
        }
    }
}
