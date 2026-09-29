package com.aopApp.services.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShipmentServiceImplTest {
    @Autowired
    private  ShipmentServiceImpl shipmentService;
    @Test
    void aopTestOrderPackage(){
        shipmentService.orderPackage(4L);
    }
    @Test
    void aopTestTackPackage(){
        shipmentService.trackPackage(8L);

    }
}
