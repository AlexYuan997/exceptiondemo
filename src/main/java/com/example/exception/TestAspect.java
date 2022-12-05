package com.example.exception;


import com.sun.xml.internal.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(com.example.exception.ExPolicy)")
    public void afterPointAcive(){
    }

    @AfterThrowing(value = "afterPointAcive()" , throwing = "e")
    public void afterThrowing(Throwable e,JoinPoint joinPoint){
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        ExPolicy testAnnotation = method.getAnnotation(ExPolicy.class);
        /**
         *  TODO
         *  获取注解参数，调用ExceptionPolicy
         */
    }

}
