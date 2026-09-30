package com.aopApp.services.impl;

import com.aopApp.aspect.MyLogging;
import com.aopApp.services.ShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Override
    @MyLogging
    public String orderPackage(Long orderId) {
//        log.info("orderPackage is called");
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
    @Transactional
    public String trackPackage(Long orderId) {
        try {
            log.info("Tracking the order...");
            Thread.sleep(300);

            throw new RuntimeException("Exception occurred during trackPackage");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
