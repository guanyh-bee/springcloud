package com.atlmm.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author gyh
 * @create 2020-10-30 13:22
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "*********test-A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "*********test-B";
    }

    @GetMapping("/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("测试rt");
        return "*********test-D";
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey",blockHandler = "dealHotKey")
    public String testhotKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2) throws InterruptedException {

        log.info("测试hotkey");
        return "*********test-hotKey";
    }
    public String dealHotKey(String p1, String p2, BlockException blockException){
        return "delHotKey爆炸！！！";
    }

}
