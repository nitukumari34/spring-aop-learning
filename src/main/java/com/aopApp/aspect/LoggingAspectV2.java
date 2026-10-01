package com.aopApp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspectV2 {

    @Before("allServiceMethodPointCut()")
    public  void beforeServiceMethodCalls(JoinPoint joinPoint){
     log.info("Before advice method calls ,{}",joinPoint.getSignature());
    }

//    @After("allServiceMethodPointCut()")
@AfterReturning(value = "allServiceMethodPointCut()",returning = "returnedObj")
    public  void afterServiceMethodCalls(JoinPoint joinPoint,Object returnedObj){
        log.info("After returning advice method calls ,{}",joinPoint.getSignature());
    log.info("After returning returned value   ,{}",returnedObj);
    }
    @Pointcut("execution(* com.aopApp.services.impl.*.*(..))")
    public  void allServiceMethodPointCut(){

    }
}
