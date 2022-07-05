package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.beans.Cheetah;
import com.epam.spring.homework1.pet.beans.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);

        Pet pet = context.getBean(Pet.class);
        pet.printPets();

        System.out.println("\n--------------\n");
        System.out.println("Cheetah by name: " + context.getBean("CheetahName"));//.getClass().getSimpleName());
        System.out.println("Cheetah by type: " + context.getBean(Cheetah.class));//.getClass().getSimpleName());
    }
}
