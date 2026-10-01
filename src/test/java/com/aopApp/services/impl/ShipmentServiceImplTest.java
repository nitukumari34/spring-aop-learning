package com.aopApp.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
@SpringBootTest
public class ShipmentServiceImplTest {
    @Autowired
    private  ShipmentServiceImpl shipmentService;
    @Test
    void aopTestOrderPackage(){
      String orderString=  shipmentService.orderPackage(4L);
      log.info(orderString);
    }
    @Test
    void aopTestTrackPackage() {
        assertThrows(
                RuntimeException.class,
                () -> shipmentService.trackPackage(4L)
        );
    }
    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void beforeTransactionalAnnotationCalls() {
        log.info("Before transactional annotation method calls");
    }
}
