package com.atlmm.myselfrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyselfRole {
    @Bean
    public IRule myselfRule(){
        return new RandomRule();
    }
}
