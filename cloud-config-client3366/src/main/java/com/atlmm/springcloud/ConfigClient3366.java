package com.atlmm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author gyh
 * @create 2020-10-24 14:29
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient3366 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient3366.class,args);
    }
}
