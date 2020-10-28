package com.atlmm.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyh
 * @create 2020-10-27 16:48
 */
@RestController
@RefreshScope
public class NacosConfigController {
    @Value("${config.info}")
    private String info;
    @GetMapping("/config/info")
    public String getInfo(){
        return info;
    }
}
