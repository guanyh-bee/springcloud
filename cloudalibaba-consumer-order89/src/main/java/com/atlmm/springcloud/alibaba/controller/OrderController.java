package com.atlmm.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author gyh
 * @create 2020-10-31 15:10
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    public static final String URL = "http://cloudalibaba-provider-payment";

    //@SentinelResource(value = "fallback")
    //@SentinelResource(value = "fallback",fallback = "handlerFallback")
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler")//只负责sentinel规则的违规
    @SentinelResource(value = "fallback", blockHandler = "blockHandler",fallback = "handlerFallback")
    //@SentinelResource(value = "fallback", blockHandler = "blockHandler",fallback = "handlerFallback",
    // exceptionsToIgnore = IllegalArgumentException.class)忽略异常
    @GetMapping("/consumer/get/{id}")
    public CommonResult getId(@PathVariable("id") Long id) {
        CommonResult forObject = restTemplate.getForObject(URL + "/get/" + id, CommonResult.class);

        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException***非法参数异常.....");
        } else if (forObject.getData() == null) {
            throw new NullPointerException("NullPointerException,对应id没有数据，空指针异常");
        }
        return forObject;
    }

    public CommonResult<Payment> handlerFallback(@PathVariable("id")Long id,Throwable e){
        Payment payment =  new Payment(id,null);
        return new CommonResult<>(444,"兜底异常handlerFallback，异常信息："+e.getMessage(),payment);
    }

    public CommonResult<Payment> blockHandler(@PathVariable("id") Long id, BlockException blockException) {
        Payment payment = new Payment(id, null);
        return new CommonResult<>(444, "blockHandler-sentinel限流，无此流水：" + blockException.getMessage(), payment);
    }

}
