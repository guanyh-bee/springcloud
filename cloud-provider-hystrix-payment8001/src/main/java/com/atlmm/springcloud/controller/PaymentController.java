package com.atlmm.springcloud.controller;

import com.atlmm.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id){
        String result = paymentService.paymentInfoOk(id);
        log.info("**************************"+result);
        return result;
    }

    @RequestMapping("/payment/hystrix/notOk/{id}")
    public String paymentInfoNotOk(@PathVariable("id") Long id){


        String result = paymentService.paymentInfoNotOk(id);
        log.info("**************************"+result);
        return result;
    }
    //服务熔断
    @GetMapping("payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("******************"+result);
        return result;
    }



}
