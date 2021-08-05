package com.example.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyUserConstraintValidator.class)
public @interface MyUserConstraint {
    String message() default "请输入正确的出生城市名";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
