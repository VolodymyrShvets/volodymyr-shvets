package com.epam.spring.homework1.pet.beans;

import com.epam.spring.homework1.pet.Animal;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Dog implements Animal {
}
