package com.atlmm.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyh
 * @create 2020-10-27 14:54
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("consumer/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id){
        return "nacos registry serverPort:"+serverPort+"\t id:"+id;
    }
}
