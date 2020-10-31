package com.atlmm.springcloud.alibaba.controller;

import com.atlmm.springcloud.alibaba.service.PaymentService;
import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gyh
 * @create 2020-10-31 16:13
 */
@RestController
public class OderController {
    @Resource
    private PaymentService paymentService;
    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id")Long id){
        CommonResult<Payment> paymentCommonResult = paymentService.paymentGet(id);
        return paymentCommonResult;
    }

}
