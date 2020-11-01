package com.atlmm.springcloud.controller;

import com.atlmm.springcloud.entities.CommonResult;
import com.atlmm.springcloud.entity.Order;
import com.atlmm.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"创建成功");
    }
}
