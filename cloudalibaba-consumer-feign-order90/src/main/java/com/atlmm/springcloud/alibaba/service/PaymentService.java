package com.atlmm.springcloud.alibaba.service;

import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author gyh
 * @create 2020-10-31 16:14
 */
@FeignClient(value = "cloudalibaba-provider-payment")
public interface PaymentService {
    @GetMapping("/get/{id}")
    CommonResult<Payment> paymentGet(@PathVariable("id")Long id);
}
