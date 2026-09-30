package com.aopApp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.aopApp.services.impl.ShipmentServiceImpl.*(..))")
    public void beforeShipmentServiceMethod(JoinPoint joinPoint) {

        log.info("Before method call : {}", joinPoint.getSignature());
    }
}