package com.atlmm.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atlmm.springcloud.alibaba.handler.CustomerBlockHandler;
import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gyh
 * @create 2020-10-30 16:21
 */
@RestController
public class RateLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流OK", new Payment(2020L, "serialLmm"));
    }

    public CommonResult handleException(BlockException blockException){
        return new CommonResult(444,blockException.getClass().getCanonicalName()+"\t 服务不可用");
    }


    @GetMapping("/byCustomer")
    @SentinelResource(value = "byCustomer",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult byCustomer() {
        return new CommonResult(200, "byCustomer", new Payment(2020L, "serialLmm"));
    }
}
