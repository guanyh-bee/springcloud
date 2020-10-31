package com.atlmm.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gyh
 * @create 2020-10-30 17:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain89 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain89.class,args);
    }
}
