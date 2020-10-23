package com.atlmm.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderHystrixService.class)
public interface OrderService {
    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Long id);

    @RequestMapping("/payment/hystrix/notOk/{id}")
    public String paymentInfoNotOk(@PathVariable("id") Long id);
}
