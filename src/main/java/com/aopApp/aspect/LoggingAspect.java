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

   //types of advice: execution pointcut
//    @Before("execution(* com.aopApp.services.impl.ShipmentServiceImpl.*(..))")
    //action
//   @Before("execution(* orderPackage(..))")
//   @Before("execution(* com.aopApp.services.impl.*.orderPackage(..))")
   @Before("execution(* com.aopApp.services.impl.*.*(..))")
   public void beforeShipmentServiceMethod(JoinPoint joinPoint) {
       log.info("Before method call, kind: {}", joinPoint.getKind());
       log.info("Before method call, signature : {}", joinPoint.getSignature());
   }
//    @Before("execution(* com.aopApp.services.impl.*.*(..))")
@Before("execution(* com.aopApp..*)")
    public void beforeServiceMethodCalls() {
        log.info("Service Impl calls");
    }

    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactionalAnnotationCalls() {
        log.info("Before transactional annotation method calls");
    }
}