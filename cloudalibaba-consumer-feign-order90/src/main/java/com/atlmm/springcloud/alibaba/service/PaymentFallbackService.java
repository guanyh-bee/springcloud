package com.atlmm.springcloud.alibaba.service;

import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author gyh
 * @create 2020-10-31 16:18
 */
@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentGet(Long id) {
        return new CommonResult<>(44444,"服务降级返回 ，来自于PaymentFallbackService",new Payment(id,"error"));
    }
}
