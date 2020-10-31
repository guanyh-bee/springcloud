package com.atlmm.springcloud.alibaba.controller;

import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gyh
 * @create 2020-10-30 17:28
 */
@RestController
public class PaymentController {
    private static Map<Long, String> map = new HashMap();

    static {
        map.put(1L, "11111");
        map.put(2L, "22222");
        map.put(3L, "33333");
    }

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id) {
        return new CommonResult(200, "端口：" + serverPort, new Payment(id,map.get(id)));
    }
}
