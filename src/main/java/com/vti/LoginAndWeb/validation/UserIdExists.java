package com.vti.LoginAndWeb.validation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(
        validatedBy = {UserIdExistsValidator.class}
)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserIdExists {
    String message() default "User Id is not exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
