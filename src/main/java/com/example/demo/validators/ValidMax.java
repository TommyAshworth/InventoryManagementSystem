package com.example.demo.validators;

import com.example.demo.validators.MaxValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MaxValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMax {
    String message() default "Count is above Maximum";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
