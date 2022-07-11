package com.epam.spring.homework2.beans;

import com.epam.spring.homework2.validation.Validator;

public class BaseBean implements Validator {
    private String name;
    private int value;

    public BaseBean() {
    }

    public BaseBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean validate() {
        return this.name != null && this.value >= 0;
    }

    @Override
    public String toString() {
        return " says: name -> " + name +
                "; value -> " + value;
    }
}
