package com.atlmm.springcloud.controller;

import com.atlmm.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id){
        String result = orderService.paymentInfoOk(id);
        log.info("**************************"+result);
        return result;
    }
//    @HystrixCommand(fallbackMethod = "paymentInfoNotOkHandler",commandProperties = {@HystrixProperty(
//            name="execution.isolation.thread.timeoutInMilliseconds",value="1500")})
    @HystrixCommand
    @RequestMapping("/consumer/payment/hystrix/notOk/{id}")
    public String paymentInfoNotOk(@PathVariable("id") Long id){
//        int age = 70/0;
        String result = orderService.paymentInfoNotOk(id);
        log.info("**************************"+result);
        return result;
    }

    public String paymentInfoNotOkHandler(@PathVariable("id") Long id){

        return "我是80 出错了...";
    }

    //全局fallback方法
    public String paymentGlobalFallbackMethod(){
        return "Global异常处理信息，请稍后再试";
    }
}
