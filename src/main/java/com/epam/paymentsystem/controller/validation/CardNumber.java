package com.epam.paymentsystem.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CardNumber {
    String message() default "Invalid CreditCard number.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
