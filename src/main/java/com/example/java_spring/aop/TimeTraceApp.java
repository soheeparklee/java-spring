package com.example.java_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceApp {

    @Around("execution(* com.example.java_spring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("start = " + joinPoint.toString());
        try{
            Object result = joinPoint.proceed();
            return result;
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("end = " + joinPoint.toString() + " " + timeMs);
        }
    }
}
