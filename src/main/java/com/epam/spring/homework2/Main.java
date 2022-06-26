package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanB;
import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanD;
import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("\nAll beans in context:");
        Stream.of(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("\nLazy BeanF:");
        context.getBean(BeanF.class);

        System.out.println("\nBeans configured by properties:");
        System.out.println(context.getBean(BeanB.class));
        System.out.println(context.getBean(BeanC.class));
        System.out.println(context.getBean(BeanD.class));
    }
}
