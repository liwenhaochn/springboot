package com.example;


import org.apache.commons.lang.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyUserConstraintValidator implements ConstraintValidator<MyUserConstraint, String> {

    @Override
    public void initialize(MyUserConstraint constraintAnnotation) {
        System.out.println("initialize");
        ;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.equals(s, "焦作");
    }
}
