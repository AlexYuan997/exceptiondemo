package com.example.exception;


import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ExPolicy {
    String policys () default "";
    boolean isThrow() default true;
    int exType() default -1;
}
