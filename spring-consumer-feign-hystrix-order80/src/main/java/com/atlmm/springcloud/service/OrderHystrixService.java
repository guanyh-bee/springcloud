package com.atlmm.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderHystrixService implements OrderService{
    @Override
    public String paymentInfoOk(Long id) {
        return "orderHystrixServiceFallback+paymentInfoOk";
    }

    @Override
    public String paymentInfoNotOk(Long id) {
        return "orderHystrixServiceFallback+paymentInfoNotOk";
    }
}
