package com.epam.spring.homework1.pet.config;

import com.epam.spring.homework1.pet.beans.Cheetah;
import com.epam.spring.homework1.pet.beans.Spider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.homework1.pet", excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Spider.class)})
public class PetConfig {
    @Bean(name = "CheetahName")
    @Primary
    public Cheetah getCheetah() {
        return new Cheetah();
    }

    @Bean
    @Qualifier("qualifierCheetah")
    public Cheetah getAnotherCheetah() {
        return new Cheetah();
    }
}
