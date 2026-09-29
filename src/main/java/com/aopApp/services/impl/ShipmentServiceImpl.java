package com.aopApp.services.impl;

import com.aopApp.services.ShipmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    public String orderPackage(Long orderId) {
        log.info("orderPackage is called");
       try{
           log.info("Processing the order...");
           Thread.sleep(1000);


       }
       catch (InterruptedException e) {
           Thread.currentThread().interrupt(); // restore interrupt status
           log.error("Error occurred while processing the order ", e);

       }
       return  "Order has been processed  successfully,orderId "+orderId;

    }

    @Override
    public String trackPackage(Long orderId) {
        log.info("trackPackage is called");
        try{
            log.info("Tracking  the order...");
            Thread.sleep(300);
            throw  new RuntimeException("Exception occurred during trackPackage");

        }
        catch (InterruptedException e) {
            throw  new RuntimeException(e);

        }
    }
}
