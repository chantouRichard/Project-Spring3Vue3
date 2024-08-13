package com.itheima.anno;

import com.auth0.jwt.interfaces.Payload;
import com.itheima.validation.StateValidation;
import com.sun.jdi.Field;
import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented//元注解
@Target({FIELD})//元注解
@Retention(RUNTIME)//元注解
@Constraint(validatedBy = {StateValidation.class})//指定提供校验规则的类

public @interface State {
    String message() default "state参数的值是能使已发布或者草稿";

    //制定分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
