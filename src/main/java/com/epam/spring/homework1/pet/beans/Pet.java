package com.epam.spring.homework1.pet.beans;

import com.epam.spring.homework1.pet.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Pet {
    private List<Animal> animalList;

    @Autowired
    public Pet(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public void printPets() {
        for (Animal animal : animalList) {
            System.out.println(animal.getClass().getSimpleName());
        }
    }
}
