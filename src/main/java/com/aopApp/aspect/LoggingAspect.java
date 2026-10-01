//package com.aopApp.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//public class LoggingAspect {
//
//   //types of advice: execution pointcut
////    @Before("execution(* com.aopApp.services.impl.ShipmentServiceImpl.*(..))")
//    //action
////   @Before("execution(* orderPackage(..))")
////   @Before("execution(* com.aopApp.services.impl.*.orderPackage(..))")
//   @Before("execution(* com.aopApp.services.impl.*.*(..))")
//   public void beforeShipmentServiceMethod(JoinPoint joinPoint) {
//       log.info("Before method call, kind: {}", joinPoint.getKind());
//       log.info("Before method call, signature : {}", joinPoint.getSignature());
//   }
////    @Before("execution(* com.aopApp.services.impl.*.*(..))")
//@Before("execution(* com.aopApp..*)")
//    public void beforeServiceMethodCalls() {
//        log.info("Service Impl calls");
//    }
//
//
//
////    public void beforeTransactionalAnnotationCalls() {
////        log.info("Before transactional annotation method calls");
////    }
//@Before("@annotation(com.aopApp.aspect.MyLogging)")
//public void beforeMyLoggingAnnotationCalls() {
//    log.info("Before MyLogging annotation calls");
//}
//@Pointcut("")
//    public  void MyLoggingAndAopMethodsPointCut(){
//
//
//}
//}
package com.aopApp.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.aopApp.services.impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before called from LoggingAspect kind: {}", joinPoint.getKind());
        log.info("Before called from LoggingAspect signature: {}", joinPoint.getSignature());
    }

    @Before("within(com.aopApp..*)")
    public void beforeServiceImplCalls() {
        log.info("Service Impl calls");
    }

    @Before("myLoggingAndAopMethodsPointCut()")
    public void beforeMyLoggingAnnotationCalls() {
        log.info("Before MyLogging Annotation calls");
    }

    @After("myLoggingAndAopMethodsPointCut()")
    public void afterMyLoggingAndAopMethodsPointCut() {
        log.info("After MyLogging Annotation calls");
    }

    @Pointcut("@annotation(com.aopApp.aspect.MyLogging) && within(com.aopApp..*)")
    public void myLoggingAndAopMethodsPointCut() {
    }
}