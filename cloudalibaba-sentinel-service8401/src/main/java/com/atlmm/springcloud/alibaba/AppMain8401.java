package com.atlmm.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author gyh
 * @create 2020-10-30 13:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AppMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(AppMain8401.class,args);
    }
}
