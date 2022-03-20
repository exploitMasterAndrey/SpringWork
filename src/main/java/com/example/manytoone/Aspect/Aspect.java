package com.example.manytoone.Aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {
    @Around("allServiceMethods()")
    public Object aroundServiceMethodExecution(ProceedingJoinPoint jp) throws Throwable {
        long start =  System.currentTimeMillis();
        Object res =  jp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("Execution of method " + jp.getSignature() + " took " + (end - start) + "msec.");
        return res;
    }
    @Pointcut("within(com.example.manytoone.Services.*)")
    public void allServiceMethods() {}
}
