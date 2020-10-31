package com.atlmm.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gyh
 * @create 2020-10-31 16:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderFeignMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain90.class,args);
    }
}
