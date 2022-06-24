package com.epam.spring.homework1.config;

import com.epam.spring.homework1.pet.config.PetConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({PetConfig.class})
@ComponentScan(basePackages = "com.epam.spring.homework1.other")
public class OtherConfig {
}
