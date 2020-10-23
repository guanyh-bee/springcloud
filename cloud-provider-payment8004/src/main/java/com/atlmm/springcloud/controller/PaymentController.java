package com.atlmm.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZk(){
        return "springCloud with zookeeper"+serverPort+ UUID.randomUUID().toString();
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}