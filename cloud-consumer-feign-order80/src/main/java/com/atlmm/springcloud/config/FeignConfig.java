package com.atlmm.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level frignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
